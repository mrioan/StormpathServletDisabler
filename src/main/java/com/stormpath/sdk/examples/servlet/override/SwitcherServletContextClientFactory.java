package com.stormpath.sdk.examples.servlet.override;

import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.servlet.client.DefaultServletContextClientFactory;
import com.stormpath.sdk.servlet.client.ServletContextClientFactory;

import javax.servlet.ServletContext;

public class SwitcherServletContextClientFactory implements ServletContextClientFactory {

    @Override
    public Client createClient(ServletContext servletContext) {
        if (AppProperties.STORMPATH_ENABLED) {
            ServletContextClientFactory servletContextClientFactory = new DefaultServletContextClientFactory();
            return servletContextClientFactory.createClient(servletContext);
        }
        return null;
    }
}
