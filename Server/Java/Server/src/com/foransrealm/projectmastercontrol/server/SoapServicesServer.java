/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.foransrealm.projectmastercontrol.server;

import com.foransrealm.projectmastercontrol.server.ws.soap.ProjectReference;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Foran
 */
public class SoapServicesServer implements IWebServicesServer {

    @Override
    public void start() {
        Endpoint.publish("http://localhost:4464/Project", new ProjectReference());
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRunning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
