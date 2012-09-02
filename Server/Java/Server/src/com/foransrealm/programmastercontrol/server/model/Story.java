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
public class Story {
    private BigInteger mStoryId;
    /**
     * 
     * @return 
     */
    public BigInteger getStoryId() {
        return mStoryId;
    }
    /**
     * 
     * @param storyId 
     */
    public void setStoryId(BigInteger storyId) {
        mStoryId = storyId;
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
    public Story() {
        
    }
    /**
     * 
     * @param storyId 
     */
    public Story(BigInteger storyId) {
        
    }
    /**
     * 
     * @param storyId 
     */
    public void load(BigInteger storyId) {
        
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
    public static Story[] getStories() {
        return getStories("");
    }
    /**
     * 
     * @param pattern
     * @return 
     */
    public static Story[] getStories(String pattern) {
        throw new NotImplementedException();
    }
}
