package com.limox.jesus.monksresurrection.Validators;

import android.util.Patterns;

import com.limox.jesus.monksresurrection.Model.User;
import com.limox.jesus.monksresurrection.R;
import com.limox.jesus.monksresurrection.Singleton.Users_Singleton;

import java.util.regex.Pattern;

/**
 * Valida con sus metodos estáticos
 * all the returns are strings references
 */

public class Validate {

    public static int USERNAME_MAX_LENGTH = 16;
    public static int USERNAME_MIN_LENGTH = 4;
    public static int PASSWORD_MIN_LENGTH = 8;
    public static int PASSWORD_MAX_LENGTH = 255;
    public static int MESSAGE_OK = R.string.message_all_ok;

    public static int validateName(String name) {
        int referenceMensaje = R.string.message_all_ok;
        if (name.length() > USERNAME_MAX_LENGTH) {
            referenceMensaje = R.string.message_error_username_tooLong;
        }
        if (name.length() < USERNAME_MIN_LENGTH) {
            referenceMensaje = R.string.message_error_username_tooShort;
        }
        return referenceMensaje;
    }

    public static int validateEmail(String email) {
        int referenceMensaje = R.string.message_all_ok;
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            referenceMensaje = R.string.message_error_email_wrong;
        return referenceMensaje;
    }

    public static int validatePassword(String password) {
        int referenceMensaje = R.string.message_all_ok;
        if (password.length() > PASSWORD_MAX_LENGTH)
            referenceMensaje = R.string.message_error_password_tooLong;
        if (password.length() < PASSWORD_MIN_LENGTH)
            referenceMensaje = R.string.message_error_password_tooShort;
        if (!password.matches("^.{0,}([0-9])+.{0,}$"))
            referenceMensaje = R.string.message_error_password_case;
        if (!password.matches("^.+[a-zA-Z]+.+$"))
            referenceMensaje = R.string.message_error_password_digit;

        return referenceMensaje;
    }

    public static int validateRepeatedPassword(String password,String repeatedPassword){
        int referenceMensaje = R.string.message_all_ok;

        if (!password.equals(repeatedPassword))
            referenceMensaje = R.string.message_error_password_match;

        return referenceMensaje;
    }
    public static int validateAccount(String userName, String password){
        int messageError = R.string.message_error_nonexistent;
        User tmpUser;
        if ((tmpUser =Users_Singleton.getUsers_Singleton().getUser(userName)) != null){
            if (tmpUser.getNick().equals(userName) && tmpUser.getPassword().equals(password))
                messageError = MESSAGE_OK;
        }
        return messageError;
    }
}