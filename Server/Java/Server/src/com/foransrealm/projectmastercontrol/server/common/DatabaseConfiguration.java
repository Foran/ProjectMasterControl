/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Foran
 */
@XmlType(propOrder = {"hostname", "database", "username", "password"})
public class DatabaseConfiguration {
    @XmlAttribute(name = "Hostname", required = true)
    public String hostname;
    @XmlAttribute(name = "Database", required = true)
    public String database;
    @XmlAttribute(name = "Username", required = true)
    public String username;
    @XmlAttribute(name = "Password", required = true)
    public String password;
    @XmlAttribute(name = "Prefix", required = true)
    public String prefix;

    public DatabaseConfiguration() {

    }

    public DatabaseConfiguration(String hostname, String database, String username, String password, String prefix) {
        this.hostname = hostname;
        this.database = database;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
    }
}
