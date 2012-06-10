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
public class User {
    private BigInteger mUserId;
    private String mUserName;
    private String mEmail;
    private String mFirstName;
    private String mMiddleName;
    private String mLastName;
    private String mPassword;
    private boolean mEmailVerified;
    
    public BigInteger getUserId() {
        return mUserId;
    }
    
    public void setUserId(BigInteger userId) {
        mUserId = userId;
    }
    
    public String getUserName() {
        return mUserName;
    }
    
    public void setUserName(String userName) {
        mUserName = userName;
    }
    
    public String getEmail() {
        return mEmail;
    }
    
    public void setEmail(String email) {
        mEmail = email;
    }
    
    public String getFirstName() {
        return mFirstName;
    }
    
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
    
    public String getMiddleName() {
        return mMiddleName;
    }
    
    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
    }
    
    public String getLastName() {
        return mLastName;
    }
    
    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    
    public boolean checkPassword(String password) {
        return false;
    }
    
    public void setPassword(String password) {
        mPassword = password;
    }
    
    public void disablePassword() {
        
    }
    
    public boolean getEmailVerified() {
        return mEmailVerified;
    }
    
    public void setEmailVerified(boolean emailVerified) {
        mEmailVerified = emailVerified;
    }
}
