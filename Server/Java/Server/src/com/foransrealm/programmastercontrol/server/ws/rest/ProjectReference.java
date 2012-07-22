/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.ws.rest;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 *
 * @author Foran
 */
@Path("/Projects")
public class ProjectReference extends BaseReference {
    public ProjectReference(@HeaderParam("Authorization") String authorization) {
        super(authorization);
    }
}
