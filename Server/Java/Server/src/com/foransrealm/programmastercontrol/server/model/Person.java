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
public class Person {
    private BigInteger mPersonId;
    /**
     * 
     * @return Person ID
     */
    public BigInteger getPersonId() {
        return mPersonId;
    }
    /**
     * 
     * @param personId Person ID
     */
    public void setPersonId(BigInteger personId) {
        mPersonId = personId;
    }
    
    private String mFirstName;
    /**
     * 
     * @return First Name
     */
    public String getFirstName() {
        return mFirstName;
    }
    /**
     * 
     * @param firstName First Name
     */
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
    
    /**
     * 
     */
    public Person() {
        
    }
    
    /**
     * 
     * @param personId
     * @throws SQLException
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException 
     */
    public Person(BigInteger personId) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        load(personId);
    }
    
    /**
     * 
     * @param personId
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException
     * @throws SQLException 
     */
    public final void load(BigInteger personId) throws ClassNotFoundException, JAXBException, IOException, SQLException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT * FROM " + Configuration.getInstance().databaseConfiguration.prefix + "People WHERE Person_ID=? LIMIT 1");
        statement.setString(1, getPersonId().toString());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        setFirstName(resultSet.getString("First_Name"));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void add() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getPersonId() != null && getPersonId().compareTo(BigInteger.ZERO) == 0) throw new SQLException("Record already exists");
        PreparedStatement statement = Database.getInstance().prepareStatement("INSERT INTO " + Configuration.getInstance().databaseConfiguration.prefix + "People (First_Name) VALUES (?)");
        statement.setString(1, getFirstName());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        setPersonId(new BigInteger(resultSet.getString(1)));
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JAXBException
     * @throws IOException 
     */
    public void update() throws SQLException, ClassNotFoundException, JAXBException, IOException {
        if(getPersonId().compareTo(BigInteger.ZERO) != 0) throw new SQLException("Record does not already exist");
        PreparedStatement statement = Database.getInstance().prepareStatement("UPDATE " + Configuration.getInstance().databaseConfiguration.prefix + "People SET First_Name=? WHERE Person_ID=?");
        statement.setString(1, getFirstName());
        statement.setString(2, getPersonId().toString());
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
    public static Person[] getPeople() throws SQLException, IOException, JAXBException, ClassNotFoundException {
        return getPeople("");
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
    public static Person[] getPeople(String pattern) throws SQLException, IOException, JAXBException, ClassNotFoundException {
        PreparedStatement statement = Database.getInstance().prepareStatement("SELECT Person_ID FROM " + Configuration.getInstance().databaseConfiguration.prefix + "People WHERE First_Name like ?");
        statement.setString(1, "%" + pattern + "%");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        List<Person> people = new ArrayList<Person>();
        while(resultSet.next()) {
            people.add(new Person(new BigInteger(resultSet.getString("Person_ID"))));
        }
        return people.toArray(new Person[people.size()]);
    }
}
