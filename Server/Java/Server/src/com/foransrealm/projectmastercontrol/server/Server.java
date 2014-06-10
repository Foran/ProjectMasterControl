/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server;

import java.io.IOException;

/**
 *
 * @author Foran
 */
public class Server {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        IWebServicesServer server = new SoapServicesServer();
        server.start();
        System.in.read();
        server.stop();
    }
}
