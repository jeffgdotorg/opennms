/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2008-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.web.rest;

import com.sun.jersey.spi.resource.PerRequest;
import org.opennms.core.criteria.CriteriaBuilder;
import org.opennms.core.criteria.restrictions.Restrictions;
import org.opennms.core.utils.InetAddressUtils;
import org.opennms.netmgt.dao.OutageDao;
import org.opennms.netmgt.model.OnmsOutage;
import org.opennms.netmgt.model.OnmsOutageCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
@PerRequest
@Scope("prototype")
@Path("timeline")
public class TimelineRestService extends OnmsRestService {

    private static class TimescaleDescriptor {
        /**
         * The divisor to use for calculating the number of labels
         */
        private int m_divisor;
        /**
         * The calendar field type to be used
         */
        private int m_type;
        /**
         * The calendar field types to be zeroed
         */
        private int[] m_typesToZero;
        /**
         * The increment for the calendar field
         */
        private int m_increment;
        /**
         * The date format to be used
         */
        private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        /**
         * Red color
         */
        private static final Color ONMS_RED = Color.decode("#CC0000");
        /**
         * Green color
         */
        private static final Color ONMS_GREEN = Color.decode("#336600");

        /**
         * Constructor for an instance.
         *
         * @param divisor     the divisor to be used
         * @param type        the calendar field type
         * @param increment   the increment for the calendar field type
         * @param typesToZero the calendar field types to be zeroed
         */
        public TimescaleDescriptor(int divisor, int type, int increment, int... typesToZero) {
            this.m_divisor = divisor;
            this.m_type = type;
            this.m_increment = increment;
            this.m_typesToZero = typesToZero;
        }

        public int getDivisor() {
            return m_divisor;
        }

        public int getType() {
            return m_type;
        }

        public int[] getTypesToZero() {
            return m_typesToZero;
        }

        public int getIncrement() {
            return m_increment;
        }

        /**
         * Checks whether this instance matches the required number of labels.
         *
         * @param delta the delta used
         * @param num   the number of labels
         * @return true, if matches, false otherwise
         */
        public boolean match(long delta, int num) {
            return (delta / m_divisor < num);
        }

        public void draw(Graphics2D graphics2D, long delta, long start, int width) {
            Calendar calendar = GregorianCalendar.getInstance();

            calendar.setTimeInMillis(start * 1000);

            for (int typeToZero : getTypesToZero()) {
                calendar.set(typeToZero, calendar.getActualMinimum(typeToZero));
            }

            calendar.add(getType(), -getIncrement());

            graphics2D.setColor(Color.BLACK);

            while (calendar.getTimeInMillis() / 1000 - getDivisor() < (start + delta)) {
                int n = (int) ((calendar.getTimeInMillis() / 1000 - start) / (delta / width));
                graphics2D.drawLine(n, 9, n, 19);
                String d = SIMPLE_DATE_FORMAT.format(calendar.getTime());
                graphics2D.drawString(d, n - graphics2D.getFontMetrics().stringWidth(d) / 2, 10);
                calendar.add(getType(), getIncrement());
            }

        }

        public void drawLine(Graphics2D graphics2D, long delta, long start, int width) {
            Calendar calendar = GregorianCalendar.getInstance();

            calendar.setTimeInMillis(start * 1000);

            for (int typeToZero : getTypesToZero()) {
                calendar.set(typeToZero, calendar.getActualMinimum(typeToZero));
            }

            calendar.add(getType(), -getIncrement());

            graphics2D.setColor(Color.BLACK);

            while (calendar.getTimeInMillis() / 1000 - getDivisor() < (start + delta)) {
                int n = (int) ((calendar.getTimeInMillis() / 1000 - start) / (delta / width));
                graphics2D.drawLine(n, 0, n, 19);
                calendar.add(getType(), getIncrement());
            }
        }

        public void drawEvent(Graphics2D graphics2D, long delta, long start, int width, OnmsOutage onmsOutage) {
            long p1 = onmsOutage.getServiceLostEvent().getEventCreateTime().getTime() / 1000;
            long p2 = start + delta;

            if (onmsOutage.getServiceRegainedEvent() != null) {
                p2 = onmsOutage.getServiceRegainedEvent().getEventCreateTime().getTime() / 1000;
            }

            graphics2D.setColor(ONMS_RED);
            int n1 = (int) ((p1 - start) / (delta / width));
            int n2 = (int) ((p2 - start) / (delta / width));
            graphics2D.fillRect(n1, 2, (n2 - n1 > 0 ? n2 - n1 : 1), 16);
        }

        public void drawGreen(Graphics2D graphics2D, int width) {
            graphics2D.setColor(ONMS_GREEN);
            graphics2D.fillRect(0, 2, width, 16);
        }

        public String getMapEntry(Graphics2D graphics2D, long delta, long start, int width, OnmsOutage onmsOutage) {
            long p1 = onmsOutage.getServiceLostEvent().getEventCreateTime().getTime() / 1000;
            long p2 = start + delta;

            if (onmsOutage.getServiceRegainedEvent() != null) {
                p2 = onmsOutage.getServiceRegainedEvent().getEventCreateTime().getTime() / 1000;
            }

            graphics2D.setColor(ONMS_RED);
            int n1 = (int) ((p1 - start) / (delta / width));
            int n2 = (int) ((p2 - start) / (delta / width));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<area shape=\"rect\" coords=\"");
            stringBuffer.append(n1);
            stringBuffer.append(",2,");
            stringBuffer.append(n2);
            stringBuffer.append(",18\" ");
            stringBuffer.append("href=\"/opennms/outage/detail.htm?id=");
            stringBuffer.append(onmsOutage.getId());
            stringBuffer.append("\" alt=\"Id " + onmsOutage.getId() + "\" title=\"" + onmsOutage.getServiceLostEvent().getEventCreateTime() + "\">");
            return stringBuffer.toString();
        }
    }

    public static final ArrayList<TimescaleDescriptor> TIMESCALE_DESCRIPTORS = new ArrayList<TimescaleDescriptor>();

    static {

        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 1, Calendar.MINUTE, 1, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 2, Calendar.MINUTE, 2, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 3, Calendar.MINUTE, 3, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 4, Calendar.MINUTE, 4, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 5, Calendar.MINUTE, 5, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 10, Calendar.MINUTE, 10, Calendar.SECOND));
        TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(60 * 30, Calendar.MINUTE, 30, Calendar.SECOND));

        for (int i = 1; i <= 10; i++) {
            TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(3600 * i, Calendar.HOUR, i, Calendar.SECOND, Calendar.MINUTE));
        }

        for (int i = 1; i <= 10; i++) {
            TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(3600 * 24 * i, Calendar.DAY_OF_MONTH, i, Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR));
        }

        for (int i = 1; i <= 10; i++) {
            TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(3600 * 24 * 30 * i, Calendar.MONTH, i, Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR, Calendar.DAY_OF_MONTH));
        }

        for (int i = 1; i <= 10; i++) {
            TIMESCALE_DESCRIPTORS.add(new TimescaleDescriptor(3600 * 24 * 360 * i, Calendar.YEAR, i, Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR, Calendar.DAY_OF_MONTH, Calendar.MONTH));
        }
    }

    @Autowired
    private OutageDao m_outageDao;

    @Context
    UriInfo m_uriInfo;

    @Context
    SecurityContext m_securityContext;

    @Context
    ServletContext m_servletContext;

    @GET
    @Produces("image/png")
    @Transactional
    @Path("header/{start}/{end}/{width}")
    public Response header(
            @PathParam("start")
            final long start,
            @PathParam("end")
            final long end,
            @PathParam("width")
            final int width) throws IOException {
        int delta = (int) end - (int) start;

        BufferedImage bufferedImage = new BufferedImage(width, 20, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        graphics2D.setColor(Color.BLACK);

        int numLabels = width / graphics2D.getFontMetrics().stringWidth("XXXX-XX-XX XX:XX");

        for (TimescaleDescriptor desc : TIMESCALE_DESCRIPTORS) {
            if (desc.match(delta, numLabels)) {
                desc.draw(graphics2D, delta, start, width);
                break;
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        byte[] imageData = baos.toByteArray();

        return Response.ok(imageData).build();
    }

    @GET
    @Produces("text/javascript")
    @Transactional
    @Path("html/{nodeId}/{ipAddress}/{serviceName}/{start}/{end}/{width}")
    public Response html(
            @PathParam("nodeId")
            final int nodeId,
            @PathParam("ipAddress")
            final String ipAddress,
            @PathParam("serviceName")
            final String serviceName,
            @PathParam("start")
            final long start,
            @PathParam("end")
            final long end,
            @PathParam("width")
            final int width) throws IOException {

        int delta = (int) end - (int) start;

        OnmsOutageCollection onmsOutageCollection;

        readLock();
        try {
            final CriteriaBuilder builder = new CriteriaBuilder(OnmsOutage.class);
            builder.eq("node.id", nodeId);
            final Date d = new Date();
            d.setTime(start);

            builder.or(Restrictions.isNull("ifRegainedService"), Restrictions.gt("ifRegainedService", d));
            builder.eq("serviceType.name", serviceName);
            builder.eq("ipInterface.ipAddress", InetAddressUtils.addr(ipAddress));

            builder.alias("monitoredService", "monitoredService");
            builder.alias("monitoredService.ipInterface", "ipInterface");
            builder.alias("monitoredService.ipInterface.node", "node");
            builder.alias("monitoredService.serviceType", "serviceType");

            applyQueryFilters(m_uriInfo.getQueryParameters(), builder);

            builder.orderBy("id").desc();

            onmsOutageCollection = new OnmsOutageCollection(m_outageDao.findMatching(builder.toCriteria()));
        } finally {
            readUnlock();
        }

        BufferedImage bufferedImage = new BufferedImage(width, 20, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        graphics2D.setColor(Color.BLACK);

        int numLabels = width / graphics2D.getFontMetrics().stringWidth("XXXX-XX-XX XX:XX");

        StringBuffer htmlBuffer = new StringBuffer();

        htmlBuffer.append("<img src=\"/opennms/rest/timeline/image/");
        htmlBuffer.append(nodeId);
        htmlBuffer.append("/");
        htmlBuffer.append(ipAddress);
        htmlBuffer.append("/");
        htmlBuffer.append(serviceName);
        htmlBuffer.append("/");
        htmlBuffer.append(start);
        htmlBuffer.append("/");
        htmlBuffer.append(end);
        htmlBuffer.append("/");
        htmlBuffer.append(width);
        htmlBuffer.append("\" usemap=\"");
        htmlBuffer.append(nodeId);
        htmlBuffer.append("-");
        htmlBuffer.append(ipAddress);
        htmlBuffer.append("-");
        htmlBuffer.append(serviceName);
        htmlBuffer.append("\"><map name=\"");
        htmlBuffer.append(nodeId);
        htmlBuffer.append("-");
        htmlBuffer.append(ipAddress);
        htmlBuffer.append("-");
        htmlBuffer.append(serviceName);
        htmlBuffer.append("\">");

        for (TimescaleDescriptor desc : TIMESCALE_DESCRIPTORS) {
            if (desc.match(delta, numLabels)) {
                for (OnmsOutage onmsOutage : onmsOutageCollection) {
                    htmlBuffer.append(desc.getMapEntry(graphics2D, delta, start, width, onmsOutage));
                }
                break;
            }
        }

        htmlBuffer.append("</map>");

        return Response.ok("document.write('" + htmlBuffer.toString() + "');").build();
    }

    @GET
    @Produces("image/png")
    @Transactional
    @Path("image/{nodeId}/{ipAddress}/{serviceName}/{start}/{end}/{width}")
    public Response image(
            @PathParam("nodeId")
            final int nodeId,
            @PathParam("ipAddress")
            final String ipAddress,
            @PathParam("serviceName")
            final String serviceName,
            @PathParam("start")
            final long start,
            @PathParam("end")
            final long end,
            @PathParam("width")
            final int width) throws IOException {
        int delta = (int) end - (int) start;

        OnmsOutageCollection onmsOutageCollection;

        readLock();
        try {
            final CriteriaBuilder builder = new CriteriaBuilder(OnmsOutage.class);
            builder.eq("node.id", nodeId);
            final Date d = new Date();
            d.setTime(start);

            builder.or(Restrictions.isNull("ifRegainedService"), Restrictions.gt("ifRegainedService", d));
            builder.eq("serviceType.name", serviceName);
            builder.eq("ipInterface.ipAddress", InetAddressUtils.addr(ipAddress));

            builder.alias("monitoredService", "monitoredService");
            builder.alias("monitoredService.ipInterface", "ipInterface");
            builder.alias("monitoredService.ipInterface.node", "node");
            builder.alias("monitoredService.serviceType", "serviceType");

            applyQueryFilters(m_uriInfo.getQueryParameters(), builder);

            builder.orderBy("id").desc();

            onmsOutageCollection = new OnmsOutageCollection(m_outageDao.findMatching(builder.toCriteria()));
        } finally {
            readUnlock();
        }

        BufferedImage bufferedImage = new BufferedImage(width, 20, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        graphics2D.setColor(Color.BLACK);

        int numLabels = width / graphics2D.getFontMetrics().stringWidth("XXXX-XX-XX XX:XX");

        for (TimescaleDescriptor desc : TIMESCALE_DESCRIPTORS) {
            if (desc.match(delta, numLabels)) {
                desc.drawGreen(graphics2D, width);

                for (OnmsOutage onmsOutage : onmsOutageCollection) {
                    desc.drawEvent(graphics2D, delta, start, width, onmsOutage);
                }

                desc.drawLine(graphics2D, delta, start, width);

                break;
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        byte[] imageData = baos.toByteArray();

        return Response.ok(imageData).build();
    }
}
