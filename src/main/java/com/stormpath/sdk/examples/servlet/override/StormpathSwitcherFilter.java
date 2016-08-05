package com.stormpath.sdk.examples.servlet.override;

import com.stormpath.sdk.servlet.filter.StormpathFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StormpathSwitcherFilter extends StormpathFilter {

    @Override
    protected void doInit() throws ServletException {
        if (AppProperties.STORMPATH_ENABLED) {
            super.doInit();
        }
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws Exception {
        if (AppProperties.STORMPATH_ENABLED) {
            super.filter(request, response, chain);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
