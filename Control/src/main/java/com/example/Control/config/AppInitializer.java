package com.example.Control.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("root");
        return new Class[]{Hibernateforemp.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("Servlet");

        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
