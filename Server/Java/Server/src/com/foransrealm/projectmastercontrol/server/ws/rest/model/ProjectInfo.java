/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.ws.rest.model;

import com.foransrealm.projectmastercontrol.server.model.Project;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Summary info of a Project instance
 * @author Foran
 */
@XmlRootElement
public final class ProjectInfo {
    /**
     * 
     */
    public ProjectInfo() {

    }

    /**
     * 
     * @param projectId
     * @param title 
     */
    public ProjectInfo(BigInteger projectId, String title) {
        setProjectId(projectId);
        setTitle(title);
    }

    private BigInteger mProjectId;
    /**
     * 
     * @return 
     */
    public BigInteger getProjectId() {
        return mProjectId;
    }
    /**
     * 
     * @param projectId 
     */
    public void setProjectId(BigInteger projectId) {
        mProjectId = projectId;
    }

    private String mTitle;
    /**
     * 
     * @return 
     */
    public String getTitle() {
        return mTitle;
    }
    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        mTitle = title;
    }
    
    public static ProjectInfo[] getAllProjects() throws SQLException, IOException, JAXBException, ClassNotFoundException {
        Project[] projects = Project.getProjects();
        List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>(projects.length);
        for(int i = 0; i < projects.length; i++) {
            projectInfos.add(new ProjectInfo(projects[i].getProjectId(), projects[i].getTitle()));
        }
        return projectInfos.toArray(new ProjectInfo[projectInfos.size()]);
    }
}
