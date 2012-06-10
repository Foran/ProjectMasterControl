/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Foran
 */
public interface IDatabase {
    PreparedStatement prepareStatement(String query) throws SQLException;
}
