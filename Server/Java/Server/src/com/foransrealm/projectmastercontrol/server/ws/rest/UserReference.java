/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.ws.rest;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 *
 * @author Foran
 */
@Path("/Users")
public class UserReference extends BaseReference {
    public UserReference(@HeaderParam("Authorization") String authorization) {
        super(authorization);
    }
}
