/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.model;

import com.foransrealm.projectmastercontrol.server.common.Configuration;
import com.foransrealm.projectmastercontrol.server.common.Database;
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
public class Company {
    private BigInteger mCompanyId;
    /**
     * 
     * @return Company ID
     */
    public BigInteger getCompanyId() {
        return mCompanyId;
    }
    /**
     * 
     * @param companyId Company ID
     */
    public void setCompanyId(BigInteger companyId) {
        mCompanyId = companyId;
    }
    
    private String mName;
    /**
     * 
     * @return Company Name
     */
    public String getName() {
        return mName;
    }
    /**
     * 
     * @param name Company Name
     */
    public void setName(String name) {
        mName = name;
    }
    
    /**
     * 
     */
    public Company() {
        
    }
    
    /**
     * 
     * @param companyId
     * @throws SQLException
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException 
     */
    public Company(BigInteger companyId) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        load(companyId);
    }
    
    /**
     * 
     * @param companyId
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException
     * @throws SQLException 
     */
    public final void load(BigInteger companyId) throws ClassNotFoundException, JAXBException, IOException, SQLException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT * FROM " + Configuration.getInstance().databaseConfiguration.prefix + "Companies WHERE Company_ID=? LIMIT 1");
        statement.setString(1, getCompanyId().toString());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        setName(resultSet.getString("Name"));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void add() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getCompanyId() != null && getCompanyId().compareTo(BigInteger.ZERO) == 0) throw new SQLException("Record already exists");
        PreparedStatement statement = Database.getInstance().prepareStatement("INSERT INTO " + Configuration.getInstance().databaseConfiguration.prefix + "Companies (Name) VALUES (?)");
        statement.setString(1, getName());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        setCompanyId(new BigInteger(resultSet.getString(1)));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void update() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getCompanyId().compareTo(BigInteger.ZERO) != 0) throw new SQLException("Record does not already exist");
        PreparedStatement statement = Database.getInstance().prepareStatement("UPDATE " + Configuration.getInstance().databaseConfiguration.prefix + "Companies SET Name=? WHERE Company_ID=?");
        statement.setString(1, getName());
        statement.setString(2, getCompanyId().toString());
        statement.execute();
    }
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException 
     */
    public static Company[] getCompanies() throws SQLException, IOException, JAXBException, ClassNotFoundException {
        return getCompanies("");
    }
    
    /**
     * 
     * @param pattern
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException 
     */
    public static Company[] getCompanies(String pattern) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT Company_ID FROM " + Configuration.getInstance().databaseConfiguration.prefix + "Companies WHERE Name like ?");
        statement.setString(1, "%" + pattern + "%");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        List<Company> companies = new ArrayList<Company>();
        while(resultSet.next()) {
            companies.add(new Company(new BigInteger(resultSet.getString("Company_ID"))));
        }
        return companies.toArray(new Company[companies.size()]);
    }
}
