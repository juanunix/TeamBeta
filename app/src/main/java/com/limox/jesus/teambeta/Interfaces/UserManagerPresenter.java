package com.limox.jesus.teambeta.Interfaces;

import android.content.Context;

import com.limox.jesus.teambeta.Model.User;

/**
 * Created by jesus on 2/03/17.
 */

public interface UserManagerPresenter {
    void addUser(User user);
    void getUser(String mUserName);
    void getUser(String mUserName, String mPassword);

    void getUser(int idUser);

    public interface View {
        Context getContext();

        void showMessage(String message);

        void onUserCreated();

        void onUserObtained(User tryUser);
    }
}