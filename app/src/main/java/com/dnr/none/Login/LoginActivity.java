package com.dnr.none.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.dnr.none.R;
import com.dnr.none.User.BuatBiodata;
import com.dnr.none.User.DataHelper;
import com.dnr.none.User.Main2Activity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsename, edtPassword;
    Button buttonLogin, buttonRegister;
    SessionManagement sessionManagement;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DataHelper(this);
        edtUsename = findViewById(R.id.etUsername);
        edtPassword = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.btnLogin);
        buttonRegister = findViewById(R.id.btnRegister);
//        initCreateAccountTextView();
//        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String username = edtUsename.getText().toString();
                    String pass = edtPassword.getText().toString();

                    //Authenticate user
                    User currentUser = dbHelper.Authenticate(new User(null, null, username,null, pass));

                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        //User Logged in Successfully Launch You home screen activity
                        Intent intent=new Intent(LoginActivity.this,LoginSuccessActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                        finish();

                    } else {
                        //User Logged in Failed
                        Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
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
        String username = edtUsename.getText().toString();
        String pass = edtPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            valid = false;
            Toast.makeText(LoginActivity.this, "Email Must Be Valid!", Toast.LENGTH_SHORT).show();
        } else if(username.isEmpty()) {
            valid = true;
            Toast.makeText(LoginActivity.this, "Input Must Be Filled!", Toast.LENGTH_SHORT).show();
        }

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