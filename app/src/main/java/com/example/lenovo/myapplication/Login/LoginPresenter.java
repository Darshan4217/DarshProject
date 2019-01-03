package com.example.lenovo.myapplication.Login;

import android.text.TextUtils;

public class LoginPresenter implements LoginContract.loginPresenterContract {
    private LoginContract.loginViewContract loginView;

    LoginPresenter(LoginActivity loginActivity) {
        loginView = loginActivity;
    }

    @Override
    public boolean setUserNameError(String email) {
        if (email.isEmpty() || !isValidEmail(email)) {
            loginView.getUsernameError();
            return false ;
        }
        else {
            loginView.setUserNameErrorEnable();
        }
        return true ;
    }

    @Override
    public boolean setPasswordError(String password) {
        if(password.isEmpty() || (password.length() < 6)){
            loginView.getPasswordError();
            return false;
        }
        else {
            loginView.setPasswordErrorEnable();
        }
        return true;
    }

        private static boolean isValidEmail(String email) {
            return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
}
