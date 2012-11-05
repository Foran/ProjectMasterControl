/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foransrealm.projectmastercontrol.server.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foran
 */
@XmlRootElement
public class User {
    private BigInteger mUserId;
    private String mUserName;
    private String mEmail;
    private String mFirstName;
    private String mMiddleName;
    private String mLastName;
    private String mPassword;
    private boolean mEmailVerified;
    
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
    
    /**
     * 
     * @return 
     */
    public String getUserName() {
        return mUserName;
    }
    
    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        mUserName = userName;
    }
    
    /**
     * 
     * @return 
     */
    public String getEmail() {
        return mEmail;
    }
    
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        mEmail = email;
    }
    
    /**
     * 
     * @return 
     */
    public String getFirstName() {
        return mFirstName;
    }
    
    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
    
    /**
     * 
     * @return 
     */
    public String getMiddleName() {
        return mMiddleName;
    }
    
    /**
     * 
     * @param middleName 
     */
    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
    }
    
    /**
     * 
     * @return 
     */
    public String getLastName() {
        return mLastName;
    }
    
    /**
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    
    /**
     * 
     * @param password
     * @return 
     */
    public boolean checkPassword(String password) {
        return false;
    }
    
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        mPassword = password;
    }
    
    /**
     * 
     */
    public void disablePassword() {
        
    }
    
    /**
     * 
     * @return 
     */
    public boolean getEmailVerified() {
        return mEmailVerified;
    }
    
    /**
     * 
     * @param emailVerified 
     */
    public void setEmailVerified(boolean emailVerified) {
        mEmailVerified = emailVerified;
    }
}
