/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.foransrealm.projectmastercontrol.server;

/**
 *
 * @author Foran
 */
public interface IWebServicesServer {
    void start();
    void stop();
    boolean isRunning();
}
