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
    private BigInteger mParentId;
    private BigInteger mProjectId;
    private String mTitle;
    private boolean mIsFunctional;
    public enum Type {
        Business,
        Technical,
        Test
    }
    private Type mType;
    private String mDescription;
}
