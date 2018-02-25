package com.example.haspani.myuzarhaspani_1202154133_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailAir extends AppCompatActivity {
    ImageView gambar, battery;
    TextView nama, detail, ukuran;
    int hitungl = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_air);
        setTitle("Detail Air Mineral");

        //mengakses gambar, nama, detail, ukuran, battery yang ada pada layout
        gambar = findViewById(R.id.detailGambar);
        nama = findViewById(R.id.detailNama);
        detail = findViewById(R.id.detailDesc);
        ukuran = findViewById(R.id.liter);
        battery = findViewById(R.id.battery);


        //set gambar dengan gambar yang di dapat intent
        gambar.setImageDrawable(this.getResources().getDrawable(Integer.valueOf(getIntent().getStringExtra("gambar"))));
        //set nama pada layout dengan nama yang di dapat intent
        nama.setText(getIntent().getStringExtra("nama"));
        //set detail dengan deskripsi yang di dapat dari intent
        detail.setText(getIntent().getStringExtra("detail"));
        //set battery pada level terendah
        battery.setImageLevel(0);
    }

    //method yang akan dieksekusi ketika button minus di klik
    public void minus(View view) {
        //apabila battery dikurangi sampai satu tingkat sebelum level terendah
        if (battery.getDrawable().getLevel() - 1 >= 0) {
            //volume air akan dikurangi sebanyak 2 Liter
            hitungl=hitungl-2;
            //set text view dengan ukuran yang sudah dihitung
            ukuran.setText(hitungl + "L");
            //maka set image battery dengan battery satu tingkat sebelum level terendah
            battery.setImageLevel(battery.getDrawable().getLevel() - 1);
        } else {
            //apabila battery dikurangi sampai level paling rendah
            battery.setImageLevel(0);
            //maka akan muncul toast yang memberi tahu bahwa air hampir habis
            Toast.makeText(this, "Almost empty!", Toast.LENGTH_LONG).show();
        }
    }

    //method yang akan dieksekusi ketika button plus di klik
    public void plus(View view) {
        //apabila battery ditambah sampai satu tingkat sebelum level tertinggi
        if (battery.getDrawable().getLevel() + 1 <=4) {
            //volume air akan ditambah sebanyak 2 liter
            hitungl=hitungl+2;
            //set text view dengan ukuran yang sudah dihitung
            ukuran.setText(hitungl + "L");
            //maka set image battery dengan battery satu tingkat sebelum level tertinggi
            battery.setImageLevel(battery.getDrawable().getLevel() + 1);
        } else {
            //apabila level battery penuh
            battery.setImageLevel(4);
            //maka akan muncul toast yang memberi tahu bahwa air sudah penuh
            Toast.makeText(this, "Full!", Toast.LENGTH_LONG).show();
        }
    }
}
