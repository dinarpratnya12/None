package com.dnr.none.Login;

import android.content.Intent;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import com.dnr.none.R;
import com.dnr.none.User.DataHelper;


public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister;
    SessionManagement sessionManagement;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DataHelper(this);
        edtUsername = findViewById(R.id.etUsername);
        edtPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
//        initCreateAccountTextView();
//        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String username = edtUsername.getText().toString();
                    String pass = edtPassword.getText().toString();

                    //Authenticate user
                    User currentUser = dbHelper.Authenticate(new User(null, null, username,null, pass));

                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(btnLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        //User Logged in Successfully Launch You home screen activity
                        Intent intent=new Intent(LoginActivity.this,LoginSuccessActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                        finish();

                    } else {
                        //User Logged in Failed
                        Snackbar.make(btnLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }


    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String username = edtUsername.getText().toString();
        String pass = edtPassword.getText().toString();

        //Handling validation for Email field
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
//            valid = false;
//            Toast.makeText(LoginActivity.this, "Email Must Be Valid!", Toast.LENGTH_SHORT).show();
//        } else if(username.isEmpty()) {
//            valid = true;
//            Toast.makeText(LoginActivity.this, "Input Must Be Filled!", Toast.LENGTH_SHORT).show();
//        }

        //Handling validation for Password field
        if (pass.isEmpty()) {
            valid = false;
            Toast.makeText(LoginActivity.this, "Input Must Be Filled!", Toast.LENGTH_SHORT).show();
        } else {
            if (pass.length() > 5) {
                valid = true;
            } else {
                valid = false;
                Toast.makeText(LoginActivity.this, "Password Must Be Valid!", Toast.LENGTH_SHORT).show();
            }
        }
        return valid;
    }
}