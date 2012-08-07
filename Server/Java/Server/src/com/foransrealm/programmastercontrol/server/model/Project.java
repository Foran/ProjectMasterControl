/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.model;

import com.foransrealm.programmastercontrol.server.common.Configuration;
import com.foransrealm.programmastercontrol.server.common.Database;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foran
 */
@XmlRootElement
public class Project {
    private BigInteger mProjectId;
    /**
     * 
     * @return Project ID
     */
    public BigInteger getProjectId() {
        return mProjectId;
    }
    /**
     * 
     * @param projectId Project ID
     */
    public void setProjectId(BigInteger projectId) {
        mProjectId = projectId;
    }
    
    private String mTitle;
    /**
     * 
     * @return Project Title
     */
    public String getTitle() {
        return mTitle;
    }
    /**
     * 
     * @param title Project Title
     */
    public void setTitle(String title) {
        mTitle = title;
    }
    
    /**
     * 
     */
    public Project() {
        
    }
    
    /**
     * 
     * @param projectId
     * @throws SQLException
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException 
     */
    public Project(BigInteger projectId) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        load(projectId);
    }
    
    /**
     * 
     * @param projectId
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException
     * @throws SQLException 
     */
    public final void load(BigInteger projectId) throws ClassNotFoundException, JAXBException, IOException, SQLException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT * FROM " + Configuration.getInstance().databaseConfiguration.prefix + "Projects WHERE Project_ID=? LIMIT 1");
        statement.setString(1, getProjectId().toString());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        setTitle(resultSet.getString("Title"));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void add() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getProjectId() != null && getProjectId().compareTo(BigInteger.ZERO) == 0) throw new SQLException("Record already exists");
        PreparedStatement statement = Database.getInstance().prepareStatement("INSERT INTO " + Configuration.getInstance().databaseConfiguration.prefix + "Projects (Title) VALUES (?)");
        statement.setString(1, getTitle());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        setProjectId(new BigInteger(resultSet.getString(1)));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void update() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getProjectId().compareTo(BigInteger.ZERO) != 0) throw new SQLException("Record does not already exist");
        PreparedStatement statement = Database.getInstance().prepareStatement("UPDATE " + Configuration.getInstance().databaseConfiguration.prefix + "Projects SET Title=? WHERE Project_ID=?");
        statement.setString(1, getTitle());
        statement.setString(2, getProjectId().toString());
        statement.execute();
    }
    
    public static Project[] getProjects() throws SQLException, IOException, JAXBException, ClassNotFoundException {
        return getProjects("");
    }
    
    public static Project[] getProjects(String pattern) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT Project_ID FROM " + Configuration.getInstance().databaseConfiguration.prefix + "Projects WHERE Title like ?");
        statement.setString(1, "%" + pattern + "%");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        List<Project> projects = new ArrayList<Project>();
        while(resultSet.next()) {
            projects.add(new Project(new BigInteger(resultSet.getString("Project_ID"))));
        }
        return projects.toArray(new Project[projects.size()]);
    }
}
