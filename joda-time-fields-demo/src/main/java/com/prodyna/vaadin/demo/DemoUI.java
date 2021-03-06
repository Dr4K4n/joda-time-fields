package com.prodyna.vaadin.demo;

import javax.servlet.annotation.WebServlet;

import com.prodyna.vaadin.jodatimefields.DateTimeField;
import com.prodyna.vaadin.jodatimefields.IntervalField;
import com.prodyna.vaadin.jodatimefields.JodaTimeFieldGroupFieldFactory;
import com.prodyna.vaadin.jodatimefields.LocalTimeField;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("joda-time-fields Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = DemoUI.class,
            widgetset = "com.prodyna.vaadin.demo.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        final JodaTimeDemoBean demoBean = new JodaTimeDemoBean();
        BeanItem<JodaTimeDemoBean> demoBeanItem = new BeanItem<JodaTimeDemoBean>(demoBean);

        final FieldGroup fieldGroup = new FieldGroup(demoBeanItem);

        // We need to set the FieldFactory so that Joda-Time classes are recognized
        fieldGroup.setFieldFactory(new JodaTimeFieldGroupFieldFactory());

        // Initialize our new UI component
        final DateTimeField dateTimeField = (DateTimeField) fieldGroup.buildAndBind("dateTime");
        final IntervalField intervalField = (IntervalField) fieldGroup.buildAndBind("interval");
        final LocalTimeField localTimeField = (LocalTimeField) fieldGroup.buildAndBind("localTime");

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.addComponent(dateTimeField);
        layout.addComponent(intervalField);
        layout.addComponent(localTimeField);

        layout.addComponent(new Button("Show values", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    fieldGroup.commit();
                } catch (CommitException e) {
                    e.printStackTrace();
                }
                StringBuilder valueString = new StringBuilder();

                valueString.append("dateTime: ").append(demoBean.getDateTime().toString()).append("\n");
                valueString.append("interval: ").append(demoBean.getInterval().toString()).append("\n");
                valueString.append("localTime: ").append(demoBean.getLocalTime().toString());

                Notification.show(valueString.toString());
            }
        }));

        setContent(layout);

    }
}
