package com.web.listener;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationData implements ServletContextListener {

    private static final Map menus = new LinkedHashMap();
    static {
        menus.put("item1", new String[]{"mvc/item1/", "項目一"});
        menus.put("item2", new String[]{"mvc/item2/", "項目二"});
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("menus", menus);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }

}
