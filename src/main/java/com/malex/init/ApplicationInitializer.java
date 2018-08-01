package com.malex.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.Nonnull;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import static com.malex.constant.Constant.*;

public class ApplicationInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(@Nonnull ServletContext servletContext)
    {
        // Create the 'root' Spring application context
        WebApplicationContext context = getContext();

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(context));

        // Security config
//        servletContext.addFilter(FILTER_NAME, new DelegatingFilterProxy(TARGET_BEAN_NAME))
//                .addMappingForUrlPatterns(null, false, URL_PATTERNS);

        // add CORSFilter filter
        DelegatingFilterProxy filter = new DelegatingFilterProxy("CORSFilter");
        servletContext.addFilter("CORSFilter", filter).addMappingForUrlPatterns(null, true, URL_PATTERNS);

        // Create the dispatcher servlet's Spring application context
        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet(SERVLET_NAME, new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.setAsyncSupported(true);
        dispatcher.setMultipartConfig(getMultiPartConfigElement());
        dispatcher.addMapping(MAPPING_URL);
    }

    /**
     * Create the 'root' Spring application context and add config class
     */
    private AnnotationConfigWebApplicationContext getContext()
    {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // path to config classes
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

    /**
     * Config multipart data
     */
    private MultipartConfigElement getMultiPartConfigElement()
    {
        return new MultipartConfigElement(LOCATION,
                MAX_FILE_SIZE,
                MAX_REQUEST_SIZE,
                FILE_SIZE_THRESHOLD);
    }
}
