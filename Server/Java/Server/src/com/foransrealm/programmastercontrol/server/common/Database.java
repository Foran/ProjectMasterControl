/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.common;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Foran
 */
public class Database implements IDatabase {
    private static IDatabase singleton = null;
    
    private Connection connection = null;
    
    private Database() throws ClassNotFoundException, SQLException, JAXBException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + Configuration.getInstance().databaseConfiguration.hostname + "/" + Configuration.getInstance().databaseConfiguration.database,  Configuration.getInstance().databaseConfiguration.username, Configuration.getInstance().databaseConfiguration.password);
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(connection != null) connection.close();
    }
    
    public static synchronized IDatabase getInstance() throws ClassNotFoundException, SQLException, JAXBException, IOException {
        if(singleton == null) singleton = new Database();
        return singleton;
    }
    
    @Override
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return (PreparedStatement) connection.prepareStatement(query);
    }
}
