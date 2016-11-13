package com.limox.jesus.monksresurrection.Model;

import android.media.Image;

/**
 * Created by jesus on 8/11/16.
 */

public class User {
    int mGameCode;
    int mIdUser;
    String mNick;
    String mEmail;
    String mPassword;
    int mProfilePicture;
    boolean mProfileBlocked;
    boolean mUserDeleted;
    int mUserType;

    public User(int gameCode, int idUser, String nick, String email, String password, int profilePicture, boolean profileBlocked, boolean userDeleted, int userType) {
        this.mGameCode = gameCode;
        this.mIdUser = idUser;
        this.mNick = nick;
        mEmail = email;
        mPassword = password;
        this.mProfilePicture = profilePicture;
        this.mProfileBlocked = profileBlocked;
        this.mUserDeleted = userDeleted;
        this.mUserType = userType;
    }

    public User(int gameCode,int mIdUser, String mNick, String mEmail, String mPassword, int mProfilePicture, int mUserType) {
        this.mGameCode = gameCode;
        this.mIdUser = mIdUser;
        this.mNick = mNick;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mProfilePicture = mProfilePicture;
        this.mUserType = mUserType;
        this.mProfileBlocked = false;
        this.mUserDeleted = false;
    }
    public User(String nick){
        this.mNick = nick;
    }

    /**
     * This is just fot find a user by is id at the lists
     * @param mIdUser
     */
    public User(int mIdUser) {
        this.mIdUser = mIdUser;
    }

    public int getIdUser() {
        return mIdUser;
    }

    public void setIdUser(int mIdUser) {
        this.mIdUser = mIdUser;
    }

    public String getNick() {
        return mNick;
    }

    public void setNick(String mNick) {
        this.mNick = mNick;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public int getProfilePicture() {
        return mProfilePicture;
    }

    public void setProfilePicture(int mProfilePicture) {
        this.mProfilePicture = mProfilePicture;
    }

    public boolean isProfileBlocked() {
        return mProfileBlocked;
    }

    public void setProfileBlocked(boolean mProfileBlocked) {
        this.mProfileBlocked = mProfileBlocked;
    }

    public boolean isUserDeleted() {
        return mUserDeleted;
    }

    public void setUserDeleted(boolean mUserDeleted) {
        this.mUserDeleted = mUserDeleted;
    }

    public int getUserType() {
        return mUserType;
    }

    public void setUserType(int mUserType) {
        this.mUserType = mUserType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return mIdUser == user.mIdUser;

    }

    @Override
    public int hashCode() {
        return mIdUser;
    }
}
