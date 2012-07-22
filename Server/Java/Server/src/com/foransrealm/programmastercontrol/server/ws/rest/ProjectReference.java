/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.ws.rest;

import com.foransrealm.programmastercontrol.server.model.Project;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author Foran
 */
@Path("/Projects")
public class ProjectReference extends BaseReference {
    public ProjectReference(@HeaderParam("Authorization") String authorization) {
        super(authorization);
    }
    
    @GET
    @Path("/{projectId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Project getProject(@PathParam("projectId") BigInteger projectId) {
        try {
            Project retval = new Project(projectId);
            return retval;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        } catch (IOException ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }
}
