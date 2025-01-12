package com.soigne_ton_temps.app;


import java.util.Objects;

import com.soigne_ton_temps.app.api.CustomJsonProvider;
import com.soigne_ton_temps.app.api.HeartbeatResource;
import com.soigne_ton_temps.app.persistance.ConnectDB;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationServer implements Runnable {
    private static final int PORT = 8181;

    private final Logger logger = LoggerFactory.getLogger(ApplicationServer.class);

    public static void main(String[] args) {
        new ApplicationServer().run();
    }

    public void run() {

        if (persistenceIsSqlite()) {
            new ConnectDB();
        }

        Server server = new Server(PORT);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);
        ResourceConfig packageConfig =
                new ResourceConfig()
                        .packages("com.soigne_ton_temps.app")
                        .register(JacksonFeature.withoutExceptionMappers())
                        .register(HeartbeatResource.class)
                        .register(CustomJsonProvider.class)
                        .register(org.glassfish.jersey.jackson.JacksonFeature.class);
        ServletContainer container = new ServletContainer(packageConfig);
        ServletHolder servletHolder = new ServletHolder(container);

        contextHandler.addServlet(servletHolder, "/*");

        try {
            server.start();
            logger.info("Server started on port " + PORT);
            server.join();
        } catch (Exception e) {
            logger.error("Error starting server", e);
        } finally {
            if (server.isRunning()) {
                server.destroy();
            }
        }
    }

    private boolean persistenceIsSqlite() {
        return (Objects.equals(System.getProperty("persistence"), "sqlite"));
    }
}
