/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.model;

import com.foransrealm.programmastercontrol.server.common.Database;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author foran
 */
public class Project {
    private BigInteger mProjectId;
    private String mTitle;
    
    public BigInteger getProjectId() {
        return mProjectId;
    }
    
    public void setProjectId(BigInteger projectId) {
        mProjectId = projectId;
    }
    
    public String getTitle() {
        return mTitle;
    }
    
    public void setTitle(String title) {
        mTitle = title;
    }
    
    public Project() {
        
    }
    
    public Project(BigInteger projectId) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        load(projectId);
    }
    
    public void load(BigInteger projectId) throws ClassNotFoundException, JAXBException, IOException, SQLException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT * FROM Projects WHERE Project_ID=?");
        statement.setString(1, getProjectId().toString());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        setTitle(resultSet.getString("Title"));
    }
}
