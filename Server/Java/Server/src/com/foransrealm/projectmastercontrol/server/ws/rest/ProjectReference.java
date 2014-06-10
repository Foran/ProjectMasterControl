/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.ws.rest;

import com.foransrealm.projectmastercontrol.server.model.Project;
import com.foransrealm.projectmastercontrol.server.ws.model.ProjectInfo;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author Foran
 */
@Path("/Projects")
public class ProjectReference extends BaseReference {
    /**
     * 
     * @param authorization 
     */
    public ProjectReference(@HeaderParam("Authorization") String authorization) {
        super(authorization);
    }
    
    /**
     * 
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ProjectInfo[] getProjects() {
        try {
            return ProjectInfo.getAllProjects();
        } catch (Exception ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(ex);
        }
    }
    
    /**
     * 
     * @param projectId
     * @return 
     */
    @GET
    @Path("/{projectId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Project getProject(@PathParam("projectId") BigInteger projectId) {
        try {
            Project retval = new Project(projectId);
            return retval;
        } catch (Exception ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }
    
    /**
     * 
     * @param projectId
     * @param project
     * @return 
     */
    @POST
    @Path("/{projectId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateProject(@PathParam("projectId") BigInteger projectId, Project project) {
        try {
            if(projectId.compareTo(project.getProjectId()) != 0) throw new WebServiceException("Project Id's do not match");
            project.update();
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(ex);
        }
    }
    
    /**
     * 
     * @param project
     * @return 
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addProject(Project project) {
        try {
            if(project.getProjectId() != null && project.getProjectId().compareTo(BigInteger.ZERO) != 0) throw new WebServiceException("Project Id must be 0 or null");
            project.add();
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception ex) {
            Logger.getLogger(ProjectReference.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(ex);
        }
    }
}
