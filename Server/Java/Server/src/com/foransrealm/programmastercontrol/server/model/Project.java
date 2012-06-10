/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.model;

import java.math.BigInteger;

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
}
