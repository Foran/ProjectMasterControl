/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Foran
 */
@XmlRootElement
@XmlType
public class Configuration {
    private static Configuration configuration = null;
    @XmlElement(name = "DatabaseConnection", type=DatabaseConfiguration.class, required=true)
    public DatabaseConfiguration databaseConfiguration = null;

    private Configuration() {
        databaseConfiguration = new DatabaseConfiguration();
    }

    private Configuration(DatabaseConfiguration database) {
        this.databaseConfiguration = database;
    }
    
    public static synchronized Configuration getInstance() throws JAXBException, IOException {
        if(configuration == null) {
            try {
                JAXBContext configurationContext = JAXBContext.newInstance(Configuration.class);
                Unmarshaller configurationUnmarshaller = configurationContext.createUnmarshaller();
                configuration = (Configuration)configurationUnmarshaller.unmarshal(new FileReader("config.xml"));
            } catch (Exception ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return configuration;
    }
}
