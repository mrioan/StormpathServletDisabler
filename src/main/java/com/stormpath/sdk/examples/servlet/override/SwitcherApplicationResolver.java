package com.stormpath.sdk.examples.servlet.override;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.application.ApplicationResolver;
import com.stormpath.sdk.servlet.application.DefaultApplicationResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

public class SwitcherApplicationResolver implements ApplicationResolver {

    DefaultApplicationResolver defaultApplicationResolver = new DefaultApplicationResolver();

    @Override
    public Application getApplication(ServletContext servletContext) {
        if (AppProperties.STORMPATH_ENABLED) {
            return defaultApplicationResolver.getApplication(servletContext);
        }
        return null;
    }

    @Override
    public Application getApplication(ServletRequest servletRequest) {
        if (AppProperties.STORMPATH_ENABLED) {
            return defaultApplicationResolver.getApplication(servletRequest);
        }
        return null;
    }
}
