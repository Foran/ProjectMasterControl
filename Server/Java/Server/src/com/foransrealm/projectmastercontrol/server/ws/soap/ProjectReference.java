/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.foransrealm.projectmastercontrol.server.ws.soap;

import com.foransrealm.projectmastercontrol.server.model.Project;
import com.foransrealm.projectmastercontrol.server.ws.model.ProjectInfo;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Foran
 */
@WebService
public class ProjectReference {
    @WebMethod
    public ProjectInfo[] getProjects() throws SQLException, IOException, JAXBException, ClassNotFoundException {
        return ProjectInfo.getAllProjects();
    }
    
    @WebMethod
    public Project getProject(BigInteger projectId) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        Project retval = new Project(projectId);
        return retval;
    }
    
    @WebMethod
    public void updateProject(BigInteger projectId, Project project) throws Exception {
        if(projectId.compareTo(project.getProjectId()) != 0) throw new Exception("Project Id's do not match");
        project.update();
    }
    
    @WebMethod
    public void addProject(Project project) throws Exception {
        if(project.getProjectId() != null && project.getProjectId().compareTo(BigInteger.ZERO) != 0) throw new Exception("Project Id must be 0 or null");
        project.add();
    }
}
