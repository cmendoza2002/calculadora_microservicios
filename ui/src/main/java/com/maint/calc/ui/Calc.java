package com.maint.calc.ui;

import com.maint.calc.ui.views.CalculadoraView;
import com.maint.calc.ui.views.DefaultView;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.*;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringUI
@Title("Calculadora Microservicios")
@SpringViewDisplay
public class Calc extends UI implements ViewDisplay {


    private CssLayout menu = new CssLayout();
    private ValoMenuLayout root = new ValoMenuLayout();
    private CssLayout menuItemsLayout = new CssLayout();

    @Override
    protected void init(VaadinRequest request) {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
        Responsive.makeResponsive(this);
        getNavigator().addView("", DefaultView.class);
        root.setWidth("100%");
        root.addMenu(buildMenu());
        Notification.show("Hola","Bienvenido(a) ", Notification.Type.TRAY_NOTIFICATION);
        getNavigator().navigateTo(DefaultView.VIEW_NAME);
        setContent(root);
    }

    private CssLayout buildMenu() {
        final HorizontalLayout top = new HorizontalLayout();
        top.setWidth("100%");
        top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        top.addStyleName("valo-menu-title");
        menu.addComponent(top);
        //menu.addComponent(createThemeSelect());
        final Button showMenu = new Button("Menu", new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if (menu.getStyleName().contains("valo-menu-visible")) {
                    menu.removeStyleName("valo-menu-visible");
                } else {
                    menu.addStyleName("valo-menu-visible");
                }
            }
        });
        showMenu.addStyleName(ValoTheme.BUTTON_PRIMARY);
        showMenu.addStyleName(ValoTheme.BUTTON_SMALL);
        showMenu.addStyleName("valo-menu-toggle");
        showMenu.setIcon(FontAwesome.LIST);
        menu.addComponent(showMenu);
        final Label title = new Label(
                "<h3><strong>Calculadora </strong></h3>", ContentMode.HTML);
        title.setSizeUndefined();
        top.addComponent(title);
        top.setExpandRatio(title, 1);
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");

        menu.addComponent(settings);
        menuItemsLayout.setPrimaryStyleName("valo-menuitems");
        menu.addComponent(menuItemsLayout);

        for (OptionMenu item :getOptionsMenu()) {
            final Button b = new Button(item.getNombre(), (Button.ClickListener) event -> {
                String key = item.getId();
                getNavigator().navigateTo(key);
            });
            b.setHtmlContentAllowed(true);
            b.setPrimaryStyleName("valo-menu-item");
            b.setIcon(item.getIcon());
            menuItemsLayout.addComponent(b);
        }
        return menu;
    }

    @Override
    public void showView(View view) {
        root.getContentContainer().removeAllComponents();
        root.getContentContainer().addComponent((Component) view);
    }


    private List<OptionMenu> getOptionsMenu()
    {
        OptionMenu optionCalc = new OptionMenu(FontAwesome.CALCULATOR, CalculadoraView.VIEW_NAME,"Basica");
        ArrayList<OptionMenu> menus = new ArrayList<>();
        menus.add(optionCalc);
        return new ArrayList<>(menus);
    }

}