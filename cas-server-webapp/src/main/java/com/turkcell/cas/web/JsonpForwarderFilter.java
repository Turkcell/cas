/*
 * Copyright 2013 Jasig.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.turkcell.cas.web;

/**
 *
 * @author capacman
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonpForwarderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(JsonpForwarderFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
// TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String callback = req.getParameter("callback");
        String timeValue = req.getParameter("_");
        LOGGER.debug("callback {} timevalue {}", callback, timeValue);
        if (callback != null) {
            MyWrapper wrappedResponse = new MyWrapper(res);
            chain.doFilter(request, wrappedResponse);
            String locationValue = wrappedResponse.getLocationValue();
            if (locationValue != null) {
                LOGGER.debug("location value {} ", locationValue);
                String newLocation = null;
                if (locationValue.contains("?ticket=")) {
                    LOGGER.debug("location value contains ticket");
                    newLocation = locationValue + "&callback="
                            + callback + "&_=" + timeValue;
                } else {
                    newLocation = locationValue + "?callback="
                            + callback + "&_=" + timeValue;
                }
                LOGGER.debug("newLocationValue {}", newLocation);
                res.sendRedirect(newLocation);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
// TODO Auto-generated method stub
    }

    static public class MyWrapper extends HttpServletResponseWrapper {

        private String locationValue = null;

        public MyWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void setHeader(String name, String value) {
            if (name.equalsIgnoreCase("Location")) {
                this.locationValue = value;
            }
            super.setHeader(name, value);
        }

        public String getLocationValue() {
            return locationValue;
        }

        @Override
        public void sendRedirect(String location) throws IOException {
            this.locationValue = location;
// prevent server from actually send redirect
        }
    }
}
