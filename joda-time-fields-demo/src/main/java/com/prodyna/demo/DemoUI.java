package com.prodyna.demo;

import com.prodyna.DateTimeField;



import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("DateTimeField Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

//    @WebServlet(value = "/*", asyncSupported = true)
//    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "com.prodyna.demo.DemoWidgetSet")
//    public static class Servlet extends VaadinServlet {
//    }

    @Override
    protected void init(VaadinRequest request) {

    	DemoBean bean = new DemoBean();
    	
    	BeanFieldGroup<DemoBean> fieldGroup = new BeanFieldGroup<DemoBean>(DemoBean.class);
    	fieldGroup.setItemDataSource(bean);
    	    	
        // Initialize our new UI component
        final DateTimeField component = new DateTimeField();

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.addComponent(fieldGroup.buildAndBind("date"));
        layout.addComponent(fieldGroup.buildAndBind("interval"));
        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        setContent(layout);

    }

}
