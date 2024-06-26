/*
 * Licensed to The OpenNMS Group, Inc (TOG) under one or more
 * contributor license agreements.  See the LICENSE.md file
 * distributed with this work for additional information
 * regarding copyright ownership.
 *
 * TOG licenses this file to You under the GNU Affero General
 * Public License Version 3 (the "License") or (at your option)
 * any later version.  You may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at:
 *
 *      https://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.opennms.web.tags;

import org.apache.commons.lang.StringUtils;
import org.opennms.web.tags.select.SelectTagHandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Creates a HTML select-element for a given number of objects (called m_elements).
 * For each object an option-section is created.
 * There is also an empty option for a "no selection made" element.
 *
 * @param <T> The type of the m_elements (e.g. String)
 */
public class SelectTag<T> extends SimpleTagSupport {

    private static class DefaultSelectTagHandler<T> implements SelectTagHandler<T> {

        private String m_defaultText = "";

        public void setDefaultText(String defaultStr){
            m_defaultText = defaultStr;
        }

        @Override
        public String getValue(T input) {
            if (input == null) return m_defaultText;
            if (input instanceof String && StringUtils.isEmpty((String)input)) return m_defaultText;
            return input.toString();
        }

        @Override
        public String getDescription(T input) {
            return getValue(input);
        }

        @Override
        public boolean isSelected(Object currentElement, Object selectedElement) {
            if (currentElement == selectedElement) return true;
            if (currentElement != null) return currentElement.equals(selectedElement);
            return false;
        }
    }

    private static final String TEMPLATE = "<select id=\"favorite-select\" class=\"form-control\" {ONCHANGE}>\n{OPTIONS}\n</select>";
    private static final String OPTION_TEMPLATE = "<option value='{VALUE}' {SELECTED}>{DESCRIPTION}</option>\n";


    private List<T> m_elements;
    private T m_selected;
    private SelectTagHandler<T> m_selectTagHandler;
    private Comparator<T> m_comparator;
    private String m_onChange;
    private String m_defaultText = "";

    public void setDefaultText(String defaultStr){
        m_defaultText = defaultStr;
    }

    public void setOnChange(String onChange) {
        m_onChange = onChange;
    }

    public void setElements(T[] elements) {
        List<T> elementsToAdd = new ArrayList<>();
        for (T eachElement : elements) {
            elementsToAdd.add(eachElement);
        }
        setElements(elementsToAdd);
    }

    private void setElements(List<T> elements) {
        m_elements = new ArrayList<>();
        if (elements == null) return;
        m_elements.addAll(elements);
    }

    public void setSelected(T selected) {
        m_selected = selected;
    }

    public void setHandler(SelectTagHandler<T> selectTagHandler) {
        m_selectTagHandler = selectTagHandler;
    }

    public void setComparator(Comparator<T> comparator) {
        m_comparator = comparator;
    }

    @Override
    public void doTag() throws JspException, IOException {


        // prepare output
        List<T> viewElements = new ArrayList<>();
        if (m_elements != null) {
            viewElements.addAll(m_elements);
        }
        if (m_comparator != null) {
            Collections.sort(viewElements, m_comparator);
        }
        viewElements.add(0, null); // "" empty at the beginning of the line

        // create output
        final StringBuilder optionsBuffer = new StringBuilder();
        for (T eachElement : viewElements) {
            optionsBuffer.append(getOption(eachElement, m_selected));
        }
        String output = TEMPLATE
                .replace("{ONCHANGE}", StringUtils.isEmpty(m_onChange) ? "" : "onChange=\"" + m_onChange + "\"")
                .replace("{OPTIONS}", optionsBuffer.toString());

        // write output
        getJspContext().getOut().write(output);
    }

    private String getOption(T element, T selected) {
        SelectTagHandler<T> handler = getSelectTagHandler();
        return OPTION_TEMPLATE
                .replace("{VALUE}", handler.getValue(element))
                .replace("{DESCRIPTION}", handler.getDescription(element))
                .replace("{SELECTED}", handler.isSelected(element, selected) ? "selected" : "");
    }

    private SelectTagHandler<T> getSelectTagHandler() {
        if (m_selectTagHandler == null){
            DefaultSelectTagHandler<T> defaultSelectTagHandler = new DefaultSelectTagHandler<>();
            defaultSelectTagHandler.setDefaultText(m_defaultText);
            return defaultSelectTagHandler;
        }
        return m_selectTagHandler;
    }
}
