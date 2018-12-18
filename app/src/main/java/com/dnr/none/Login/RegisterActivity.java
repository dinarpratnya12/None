package com.dnr.none.Login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.dnr.none.R;
import com.dnr.none.User.DataHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    DataHelper dbHelper;
    Button ton1;
    EditText username, fullname, email, number, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new DataHelper(this);
        username = (EditText) findViewById(R.id.etUsername) ;
        fullname = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        ton1 = (Button) findViewById(R.id.btnRegister);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into user(id, username, fullname, email, number, password) values(null,'" +username.getText().toString() + "','" +fullname.getText().toString() + "','" +email.getText().toString() + "','" +password.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Register Succeed",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
