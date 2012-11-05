/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.ws.rest;

import javax.ws.rs.HeaderParam;
import com.sun.jersey.core.util.Base64;

/**
 *
 * @author Foran
 */
public class BaseReference {
    public BaseReference(@HeaderParam("Authorization") String authorization) {
        mAuthorization = authorization;
        if(mAuthorization != null) {
            if(mAuthorization.startsWith("Basic ")) {
                String[] parts = Base64.base64Decode(mAuthorization.substring("Basic ".length())).split(":");
                if(parts.length == 2) {
                    mAuthorizedUsername = parts[0];
                    mAuthorizedPassword = parts[1];
                }
            }
        }
    }
    
    /**
     * Quick and dirty auth implementation
     * To be replaced with OAuth 2.0 in the future
     */
    private String mAuthorization;
    protected String getAuthorization() {
        return mAuthorization;
    }
    
    /**
     * Quick and dirty auth implementation
     * To be replaced with OAuth 2.0 in the future
     */
    private String mAuthorizedUsername;
    protected String getAuthorizedUsername() {
        return mAuthorizedUsername;
    }
    
    /**
     * Quick and dirty auth implementation
     * To be replaced with OAuth 2.0 in the future
     */
    private String mAuthorizedPassword;
    protected String getAuthorizedPassword() {
        return mAuthorizedPassword;
    }
    
    /**
     * 
     * @return true if authorized and false if not
     */
    protected boolean isAuthorized() {
        return mAuthorizedUsername.length() > 0 ? true : false;
    }
}
