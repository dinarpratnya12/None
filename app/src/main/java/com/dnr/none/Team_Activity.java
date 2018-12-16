package com.dnr.none;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dnr.none.User.Main2Activity;

public class Team_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcoach;
    private ImageView img;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvcoach = (TextView) findViewById(R.id.txtCoach);
        img = (ImageView) findViewById(R.id.teamthumbnail);
        btn = (Button) findViewById(R.id.btnKembali);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Coach = intent.getExtras().getString("Coach");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");


        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvcoach.setText(Coach);
        img.setImageResource(image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Team_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.logout_menu,menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//
//        if(id==R.id.logout)
//        {
//            startActivity(new Intent(this, MainActivity.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
