package com.example.lenovo.myapplication.Login;

 class LoginContract {

    interface loginViewContract {
        void displayEmptyEmailError();
        void displayInvalidEmailError();
        void displayEmptyPasswordError();
        void displayInvalidPasswordError();
        void successResult();
    }

    interface loginPresenterContract {
        void doLogin(String userName, String password);
    }
}
