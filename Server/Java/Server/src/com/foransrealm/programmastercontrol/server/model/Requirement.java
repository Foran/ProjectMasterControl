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
public class Requirement {
    private BigInteger mRequirementId;
    /**
     * 
     * @return 
     */
    public BigInteger getRequirementId() {
        return mRequirementId;
    }
    /**
     * 
     * @param requirementId 
     */
    public void setRequirementId(BigInteger requirementId) {
        mRequirementId = requirementId;
    }
    
    private BigInteger mParentId;
    /**
     * 
     * @return 
     */
    public BigInteger getParentId() {
        return mParentId;
    }
    /**
     * 
     * @param parentId 
     */
    public void setParentId(BigInteger parentId) {
        mParentId = parentId;
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
    
    private boolean mIsFunctional;
    /**
     * 
     * @return 
     */
    public boolean getIsFunctional() {
        return mIsFunctional;
    }
    /**
     * 
     * @param isFunctional 
     */
    public void setIsFunctional(boolean isFunctional) {
        mIsFunctional = isFunctional;
    }
    
    /**
     * 
     */
    public enum Type {
        Business,
        Technical,
        Test
    }
    
    private Type mType;
    /**
     * 
     * @return 
     */
    public Type getType() {
        return mType;
    }
    /**
     * 
     * @param type 
     */
    public void setType(Type type) {
        mType = type;
    }
    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        mType = Type.valueOf(type);
    }
    
    private String mDescription;
    /**
     * 
     * @return 
     */
    public String getDescription() {
        return mDescription;
    }
    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        mDescription = description;
    }
}
