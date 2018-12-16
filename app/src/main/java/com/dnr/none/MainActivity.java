package com.dnr.none;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dnr.none.User.LihatBiodata;
import com.dnr.none.User.Main2Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    List<Team> lstTeam ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTeam = new ArrayList<>();
        lstTeam.add(new Team("A.C. Milan","Coach : Gennaro Gattuso","Associazione Calcio Milan, sering disebut sebagai A.C. Milan atau hanya Milan, adalah sebuah klub sepak bola Italia yang berbasis di Milan, Lombardia, yang bermain di Serie A. Mereka bermain dengan seragam bergaris merah-hitam dan celana putih, sehingga dijuluki rossoneri.",R.drawable.img_acm));
        lstTeam.add(new Team("Arsenal F.C.","Coach : Unai Emery","Arsenal Football Club (dikenal pula sebagai Arsenal atau The Gunners) adalah klub sepak bola profesional Inggris yang berbasis di daerah Holloway, London. didirikan pada 1886 dengan nama Dial Square. Klub ini bermain di Liga Utama Inggris yang termasuk salah satu klub tersukses di sepak bola Inggris, yang telah memenangkan 13 gelar kasta utama Liga Inggris (10 pada era Divisi Pertama dan 3 pada era Premier League) dan 13 gelar di Piala FA (Gelar paling banyak).",R.drawable.img_arsenal));
        lstTeam.add(new Team("FC Barcelona", "Coach : Ernesto Valverde", "Fútbol Club Barcelona, juga dikenal sebagai Barcelona atau Barça, adalah klub sepak bola profesional yang berbasis di Barcelona, Catalunya, Spanyol. Didirikan pada tahun 1899 oleh sekelompok pemain Swiss, Inggris dan Catalan yang dipimpin oleh Joan Gamper, klub telah menjadi simbol budaya Catalan dan Catalanisme, yang mempunyai motto \"Més que un club\" (Lebih dari sebuah klub). Tidak seperti banyak klub sepak bola lainnya, para pendukung memiliki dan mengoperasikan Barcelona. Ia adalah klub sepak bola kedua terkaya di dunia dalam hal pendapatan, dengan omset tahunan sebesar €560,8 juta dan kedua yang paling berharga, senilai $3,56 miliar.",R.drawable.img_barca));
        lstTeam.add(new Team("FC Bayern München","Coach : Niko Kovač","FC Bayern Munich, atau FC Bayern, adalah sebuah klub olahraga Jerman yang berbasis di München, Bavaria. Hal ini terkenal karena tim sepak bola profesional, yang bermain di Bundesliga, peringkat teratas sistem liga sepak bola Jerman, dan merupakan klub paling sukses dalam sejarah sepak bola Jerman, setelah memenangkan rekor 28 gelar nasional dan 18 piala nasional.",R.drawable.img_bayern));
        lstTeam.add(new Team("Chelsea F.C.","Coach : Maurizio Sarri","Chelsea Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di Fulham, London. Chelsea didirikan pada tahun 1905 dan kini berkompetisi di Liga Utama Inggris. Kesuksesan pertama Chelsea diraih saat meraih gelar juara liga pada tahun 1955. Beberapa gelar dari berbagai kompetisi juga berhasil diraih pada dekade 1960an, 1970an, 1990an, dan 2000an. Sepanjang sejarah penampilan dalam dunia sepak bola di Inggris dan Eropa, Chelsea telah meraih enam gelar juara Liga Utama Inggris, tujuh Piala FA, lima Piala Liga, satu trofi Liga Champions UEFA, dua Piala Winners UEFA, satu Liga Eropa UEFA dan satu Piala Super UEFA.",R.drawable.img_chelsea));
        lstTeam.add(new Team("New York City FC","Coach : Jason Kreis","New York City FC adalah tim sepak bola profesional Amerika yang akan datang dan berbasis di New York City. New York City FC akan berlaga di Major League Soccer (MLS). New York City FC diumumkan sebagai franchise kedua puluh dalam liga pada 21 Mei 2013.",R.drawable.img_city));
        lstTeam.add(new Team("Real Madrid C.F.","Coach : Santiago Solari","Real Madrid, adalah klub sepak bola profesional yang berbasis di Madrid, Spanyol. Didirikan pada tahun 1902 sebagai Madrid Football Club, secara tradisional mengenakan kostum kandang putih. Kata Real (\"dari kerajaan\") Spanyol dan dianugerahkan ke klub oleh Raja Alfonso XIII pada tahun 1920 bersama-sama dengan mahkota kerajaan di lambang klub. Klub ini telah memainkan pertandingan kandang di Stadion Santiago Bernabéu dengan kapasitas 85.454 di pusat kota Madrid sejak tahun 1947. Klub ini adalah klub sepak bola terkaya di dunia dalam hal pendapatan, dengan omset tahunan sebesar €513 juta dan paling berharga, senilai €3.3 miliar.",R.drawable.img_madrid));
        lstTeam.add(new Team("Manchester United F.C.", "Coach : José Mourinho","Manchester United Football Club adalah sebuah klub sepak bola profesional Inggris yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Inggris. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910.",R.drawable.img_mu));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstTeam);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }


}