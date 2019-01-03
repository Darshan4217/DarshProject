package com.example.lenovo.myapplication.Login;

 class LoginContract {

    interface loginViewContract {
        void getUsernameError();
        void getPasswordError();
        void setUserNameErrorEnable();
        void setPasswordErrorEnable();
    }

    interface loginPresenterContract {
        boolean setUserNameError(String email);
        boolean setPasswordError(String password);
    }
}
