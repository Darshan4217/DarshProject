package com.example.lenovo.myapplication.Login;

import android.text.TextUtils;

public class LoginPresenter implements LoginContract.loginPresenterContract {
    private LoginContract.loginViewContract loginView;

    LoginPresenter(LoginActivity loginActivity) {
        loginView = loginActivity;
    }

    @Override
    public void doLogin(String email, String password) {
        if (email.isEmpty()){
            loginView.displayEmptyEmailError();
            return;
        }
        if(!isValidEmail(email)){
            loginView.displayInvalidEmailError();
            return;
        }
        if(password.isEmpty()){
            loginView.displayEmptyPasswordError();
            return;
        }
        if(password.length()<6){
            loginView.displayInvalidPasswordError();
            return;
        }

        loginView.successResult();
    }

    private static boolean isValidEmail(String email) {
            return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
}
