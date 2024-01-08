/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2023 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2023 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.events.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * A datetime formatter that attempts to mimic, as closely as possible, formatting in pre-2019 OpenNMS releases.
 * This will not work <em>exactly</em> the same unless you change the <code>-Djava.locale.provider=<code>
 * property during startup to be <code>COMPAT</code> by default.
 */
public class LegacyDatetimeFormatter implements EventDatetimeFormatter {
    public static final ThreadLocal<DateFormat> FORMATTER_FULL = ThreadLocal.withInitial(() -> {
        int timeFormat = DateFormat.FULL;

        // The DateFormat.FULL format for France/Germany do not include the seconds digit
        // which is necessary to have sub-minute resolution in event times. For these
        // locales, we'll fall back to using DateFormat.LONG.
        final String language = Locale.getDefault().getLanguage();
        if (language.equals(Locale.FRANCE.getLanguage()) || language.equals(Locale.GERMANY.getLanguage())) {
            timeFormat = DateFormat.LONG;
        }

        final DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, timeFormat);
        formatter.setLenient(true);
        return formatter;
    });

    public static final ThreadLocal<DateFormat> FORMATTER_LONG = ThreadLocal.withInitial(() -> {
        final DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
        formatter.setLenient(true);
        return formatter;
    });

    public static final ThreadLocal<DateFormat> FORMATTER_LONG_GMT = ThreadLocal.withInitial(() -> {
        final DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
        formatter.setLenient(true);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter;
    });

    /**
     * This {@link DateFormat} is used to parse timestamps from XML events that are generated by
     * the send-event.pl script. It always formats timestamps in English so we hard-code the locale
     * as {@link Locale#ENGLISH} in this {@link DateFormat}.
     */
    public static final ThreadLocal<DateFormat> FORMATTER_CUSTOM = ThreadLocal.withInitial(() -> {
        final DateFormat formatter = new SimpleDateFormat("EEEEE, d MMMMM yyyy k:mm:ss 'o''clock' z", Locale.ENGLISH);
        formatter.setLenient(true);
        return formatter;
    });

    public static final ThreadLocal<DateFormat> FORMATTER_DEFAULT = ThreadLocal.withInitial(() -> {
        final DateFormat formatter = DateFormat.getDateTimeInstance();
        formatter.setLenient(true);
        return formatter;
    });

    public static final ThreadLocal<DateFormat> FORMATTER_CUSTOM_LOCALE = ThreadLocal.withInitial(() -> {
        Locale.setDefault(Locale.US);
        final DateFormat formatter = DateFormat.getDateTimeInstance();
        formatter.setLenient(true);
        return formatter;
    });

    private static final List<ThreadLocal<DateFormat>> preferredOrder = Arrays.asList(FORMATTER_LONG, FORMATTER_CUSTOM, FORMATTER_CUSTOM_LOCALE, FORMATTER_FULL, FORMATTER_DEFAULT);

    @Override
    public Date parse(final String dateString) throws ParseException {
        if (dateString == null) {
            throw new ParseException("time was null!", -1);
        }
        final String noUtc = dateString.replaceAll("UTC$", "GMT");
        Exception e = null;
        for (final String attempt : Arrays.asList(dateString, noUtc)) {
            for (final ThreadLocal<DateFormat> formatter : preferredOrder) {
                final DateFormat dateFormatter = formatter.get();
                // System.err.println("attempt=" + attempt + ", formatter=" + dateFormatter);
                try {
                    return dateFormatter.parse(attempt);
                } catch (final ParseException pe) {
                    if (e == null) {
                        e = pe;
                    }
                }
            }
        }

        // we tried all the "legacy" formatters, either ISO will work, or we give up

        ParseException thrown = null;
        try {
            return Date.from(ZonedDateTime.parse(dateString).toInstant());
        } catch (final DateTimeParseException dtpe) {
            thrown = new ParseException("failed to parse " + dateString + " as any legacy format; giving up", dtpe.getErrorIndex());
        } catch (final Exception isoe) {
            thrown = new ParseException("failed to parse " + dateString + " as any legacy format; giving up", 0);
        }
        thrown.initCause(e);
        throw thrown;
    }

    @Override
    public String format(final Date date) {
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }

}
