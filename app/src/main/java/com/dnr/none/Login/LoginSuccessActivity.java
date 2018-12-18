package com.dnr.none.Login;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dnr.none.R;
import com.dnr.none.User.DataHelper;

public class LoginSuccessActivity extends AppCompatActivity {

    DataHelper dBHelper;
    Cursor cursor;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        dBHelper = new DataHelper(this);
        welcome = (TextView) findViewById(R.id.welcome);
        SQLiteDatabase db = dBHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT fullname FROM user WHERE username='" +
                getIntent().getStringExtra("username")+ "'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            welcome.setText(cursor.getString(0).toString());
        }
    }
}
