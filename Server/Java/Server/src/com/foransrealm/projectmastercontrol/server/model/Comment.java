/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Foran
 */
@XmlRootElement
public class Comment {
    private BigInteger mCommentId;
    /**
     * 
     * @return 
     */
    public BigInteger getCommentId() {
        return mCommentId;
    }
    /**
     * 
     * @param commentId 
     */
    public void setCommentId(BigInteger commentId) {
        mCommentId = commentId;
    }
    private BigInteger mUserId;
    /**
     * 
     * @return 
     */
    public BigInteger getUserId() {
        return mUserId;
    }
    /**
     * 
     * @param userId 
     */
    public void setUserId(BigInteger userId) {
        mUserId = userId;
    }
    private String mComment;
    /**
     * 
     * @return 
     */
    public String getComment() {
        return mComment;
    }
    /**
     * 
     * @param comment 
     */
    public void setComment(String comment) {
        mComment = comment;
    }
    /**
     * 
     */
    public Comment() {
        
    }
    /**
     * 
     * @param commentId 
     */
    public Comment(BigInteger commentId) {
        
    }
    /**
     * 
     * @param commentId 
     */
    public void load(BigInteger commentId) {
        
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
    public static Comment[] getComments() {
        return getComments("");
    }
    /**
     * 
     * @param pattern
     * @return 
     */
    public static Comment[] getComments(String pattern) {
        throw new NotImplementedException();
    }
}
