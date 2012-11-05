/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.programmastercontrol.server.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author foran
 */
@XmlRootElement
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
    
    /**
     * 
     */
    public enum Type {
        UserStory,
        Feature,
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
    /**
     * 
     */
    public Requirement() {
        
    }
    /**
     * 
     * @param rquirementId 
     */
    public Requirement(BigInteger rquirementId) {
        
    }
    /**
     * 
     * @param rquirementId 
     */
    public void load(BigInteger rquirementId) {
        
    }
    /**
     * 
     */
    public void add() {
        
    }
    /**
     * 
     */
    public void update() {
        
    }
    /**
     * 
     * @return 
     */
    public static Requirement[] getRequirements() {
        return getRequirements("");
    }
    /**
     * 
     * @param pattern
     * @return 
     */
    public static Requirement[] getRequirements(String pattern) {
        throw new NotImplementedException();
    }
}
