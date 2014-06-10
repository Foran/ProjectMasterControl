/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.foransrealm.projectmastercontrol.server;

import java.net.URI;
import java.security.AccessController;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;
import org.glassfish.grizzly.ssl.SSLEngineConfigurator;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.util.PropertiesHelper;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Foran
 */
public class RestServicesServer implements IWebServicesServer {
    private static final String KEYSTORE_SERVER_FILE = "./keystore_server";
    private static final String KEYSTORE_SERVER_PWD = "asdfgh";
    private static final String TRUSTORE_SERVER_FILE = "./truststore_server";
    private static final String TRUSTORE_SERVER_PWD = "asdfgh";
    private static HttpServer webServer;
    public static final URI BASE_URI = getBaseURI();
    public static final String CONTENT = "JERSEY HTTPS EXAMPLE\n";

    @Override
    public void start() {
        SSLContextConfigurator sslContext = new SSLContextConfigurator();
        sslContext.setKeyStoreFile(KEYSTORE_SERVER_FILE);
        sslContext.setKeyStorePass(KEYSTORE_SERVER_PWD);
        sslContext.setTrustStoreFile(TRUSTORE_SERVER_FILE);
        sslContext.setTrustStorePass(TRUSTORE_SERVER_PWD);
        //ResourceConfig rc = new PackagesResourceConfig("com.foransrealm.programmastercontrol.server.ws.rest");
        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(com.foransrealm.projectmastercontrol.server.ws.rest.UserReference.class, com.foransrealm.projectmastercontrol.server.ws.rest.RequirementReference.class, com.foransrealm.projectmastercontrol.server.ws.rest.ProjectReference.class);
        try {
            webServer = GrizzlyHttpServerFactory.createHttpServer(getBaseURI(),rc,true,new SSLEngineConfigurator(sslContext).setClientMode(false).setNeedClientAuth(true));
            System.out.println("Jersey app started. Try out " + BASE_URI + "\nHit CTRL + C to stop it...");
            webServer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void stop() {
        webServer.stop();
    }

    @Override
    public boolean isRunning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("https://localhost/").port(getPort(4463)).build();
    }
    
    private static int getPort(int defaultPort) {
        final String port = AccessController.doPrivileged(PropertiesHelper.getSystemProperty("jersey.config.test.container.port"));
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
                System.out.println("Value of jersey.config.test.container.port property" + " is not a valid positive integer [" + port + "]." + " Reverting to default [" + defaultPort + "].");
            }
        }
        return defaultPort;
    }
}
