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
package org.opennms.features.vaadin.jmxconfiggenerator.ui.mbeans;

import java.util.Objects;

import org.opennms.features.vaadin.jmxconfiggenerator.data.SelectionChangedListener;
import org.opennms.features.vaadin.jmxconfiggenerator.data.SelectionValueChangedListener;
import org.opennms.features.vaadin.jmxconfiggenerator.ui.mbeans.validation.NameValidator;
import org.opennms.netmgt.vaadin.core.UIHelper;

import com.vaadin.ui.FormLayout;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.Validator;
import com.vaadin.v7.data.fieldgroup.FieldGroup;
import com.vaadin.v7.data.util.BeanItem;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.CheckBox;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;


/**
 * Handles the editing of the MBeans name.
 *
 * @author Markus von Rüden
 */
public class NameEditForm extends VerticalLayout implements SelectionChangedListener, SelectionValueChangedListener {

    private final Validator nameValidator = new NameValidator();
    private final Label captionLabel;
    private FormParameter parameter;
    private FieldGroup fieldGroup;
    private FormLayout contentLayout = new FormLayout();
    private TextField editableField;
    private TextField nonEditableField;
    private CheckBox selectedField;
    private MBeansController controller;
    /** Defines if the overall validation should be blocked. */
    private boolean blockListenerOrValidators;
    private String itemId;

    public NameEditForm(MBeansController controller) {
        initFields();
        this.controller = controller;
        captionLabel = new Label();
        captionLabel.setContentMode(ContentMode.HTML);

        addComponent(captionLabel);
        addComponent(contentLayout);
        setWidth(100, Unit.PERCENTAGE);
    }

    protected void setParameter(FormParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void selectionChanged(SelectionChangedEvent changeEvent) {
        if (parameter != null) {
            try {
                blockListenerOrValidators = true;
                setData(changeEvent.getSelectedBean());
                setItemId(changeEvent.getSelectedItemId());

                final BeanItem beanItem = new BeanItem(changeEvent.getSelectedBean(), parameter.getEditablePropertyName(), parameter.getNonEditablePropertyName());
                // this is a hack, but we need to know if the selection changed
                beanItem.addItemProperty("selected", changeEvent.getSelectedItem().getItemProperty("selected"));

                captionLabel.setValue(String.format("<b>%s</b>", parameter.getCaption()));
                fieldGroup = new FieldGroup();
                fieldGroup.setBuffered(false);
                fieldGroup.bind(selectedField, "selected");
                fieldGroup.bind(editableField, parameter.getEditablePropertyName());
                fieldGroup.bind(nonEditableField, parameter.getNonEditablePropertyName());
                fieldGroup.setItemDataSource(beanItem);
                fieldGroup.getField(parameter.getNonEditablePropertyName()).setCaption(parameter.getNonEditablePropertyCaption());
                fieldGroup.getField(parameter.getNonEditablePropertyName()).setReadOnly(true);
                fieldGroup.getField(parameter.getEditablePropertyName()).setCaption(parameter.getEditablePropertyCaption());
                fieldGroup.getField(parameter.getEditablePropertyName()).setReadOnly(false);

                updateEnabledState();

                UIHelper.validateField(editableField, true);
            } finally {
                blockListenerOrValidators = false;
            }
        }
    }

    @Override
    public void selectionValueChanged(SelectionValueChangedEvent selectionValueChangedEvent) {
        if (selectionValueChangedEvent.getBean() == getData()) {
            selectedField.setValue(selectionValueChangedEvent.getNewValue());
        }
    }

    private void setItemId(String itemId) {
        this.itemId = itemId;
    }

    private String getItemId() {
        return itemId;
    }

    private void initFields() {
        nonEditableField = new TextField();
		nonEditableField.setWidth(400, Unit.PIXELS);
        nonEditableField.setReadOnly(true);
        nonEditableField.setEnabled(false);

        editableField = new TextField();
		editableField.setWidth(400, Unit.PIXELS);
        editableField.setRequired(true);
        editableField.setRequiredError("You must provide a value.");
        editableField.setValidationVisible(false);
        editableField.setBuffered(false);
        editableField.setImmediate(true);
        editableField.addValidator(nameValidator);
        editableField.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (!blockListenerOrValidators) {
                    controller.validateCurrentSelection();
                }
            }
        });
        editableField.setTextChangeTimeout(200);
        editableField.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                editableField.setComponentError(null);
                editableField.setValue(event.getText());
                editableField.validate();
            }
        });

        selectedField = new CheckBox();
        selectedField.setCaption("selected");
        selectedField.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                updateEnabledState();
                if (!selectedField.getValue()) {
                    editableField.discard();
                }
                if (!blockListenerOrValidators) {
                    try {
                        blockListenerOrValidators = true;
                        controller.fireSelectionValueChanged(getData(), getItemId(), selectedField.getValue());
                    } finally {
                        blockListenerOrValidators = false;
                    }
                }
            }
        });

        contentLayout.addComponent(selectedField);
        contentLayout.addComponent(editableField);
        contentLayout.addComponent(nonEditableField);
    }

    void validate() throws Validator.InvalidValueException {
        if (fieldGroup != null
                && fieldGroup.getItemDataSource() != null
                && fieldGroup.getItemDataSource().getItemProperty("selected") != null
                && fieldGroup.getItemDataSource().getItemProperty("selected").getValue() != null) { // fieldGroup may have not yet been initialized
            if (Objects.equals(true, fieldGroup.getItemDataSource().getItemProperty("selected").getValue())) {
                UIHelper.validateFields(fieldGroup.getFields(), false);
            }
        }
    }

    boolean isDirty() {
        return fieldGroup.isModified();
    }

    void discard() {
        fieldGroup.discard();
    }

    private void updateEnabledState() {
        nonEditableField.setEnabled(selectedField.getValue());
        editableField.setEnabled(selectedField.getValue());
        editableField.setComponentError(null);
    }
}
