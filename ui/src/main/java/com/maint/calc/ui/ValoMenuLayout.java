package com.maint.calc.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class ValoMenuLayout extends HorizontalLayout {

    CssLayout contentArea = new CssLayout();

    CssLayout menuArea = new CssLayout();

    public ValoMenuLayout() {
        setSizeFull();
        menuArea.setPrimaryStyleName("valo-menu");
        contentArea.addStyleName("v-scrollable");
        contentArea.setSizeFull();
        addComponents(menuArea, contentArea);
        setExpandRatio(contentArea, 1);
        contentArea.setWidth("100%");
    }

    public ComponentContainer getContentContainer() {
        return contentArea;
    }

    public void addMenu(Component menu) {
        menu.addStyleName("valo-menu-part");
        menuArea.addComponent(menu);
    }

}