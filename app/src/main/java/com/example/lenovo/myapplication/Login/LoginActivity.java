package com.example.lenovo.myapplication.Login;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.*;
import com.example.lenovo.myapplication.R;
/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.loginViewContract {

    // UI references.
    private AutoCompleteTextView editText_email,editText_password;
    private TextInputLayout emailInputLayout,passwordInputLayout;
    Button sign_in_button ;
    LoginPresenter loginPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_email = findViewById(R.id.editText_email);
        editText_password = findViewById(R.id.editText_password);
        emailInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        sign_in_button = findViewById(R.id.sign_in_button);
        editText_email.addTextChangedListener(new MyTextWatcher(editText_email));
        editText_password.addTextChangedListener(new MyTextWatcher(editText_password));

        // bind the view using butterknife
        //ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);

        sign_in_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String email = editText_email.getText().toString().trim();
        String password = editText_password.getText().toString().trim();
        if(!loginPresenter.setUserNameError(email)){
            return;
        }

        if (!loginPresenter.setPasswordError(password)) {
            return;
        }

        Toast.makeText(getApplicationContext(), "Go to next Page!", Toast.LENGTH_SHORT).show();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void getUsernameError() {
        emailInputLayout.setError("Enter Valid Email");
       // Toast.makeText(this,"Enter Valid EmailId.",Toast.LENGTH_LONG).show();
        requestFocus(editText_email);
    }

    @Override
    public void setUserNameErrorEnable() {
        emailInputLayout.setErrorEnabled(false);
    }

    @Override
    public void setPasswordErrorEnable() {
        passwordInputLayout.setErrorEnabled(false);
    }

    @Override
    public void getPasswordError() {
        //Toast.makeText(this,"Enter Valid password.",Toast.LENGTH_LONG).show();
        passwordInputLayout.setError("Enter password");
        requestFocus(editText_password);
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.editText_email:
                    emailInputLayout.setError(null);
                    break;
                case R.id.editText_password:
                    passwordInputLayout.setError(null);
                    break;
            }
        }
    }


}

