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
    int hitungl = 0;
    int levelCurrent;

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
        levelCurrent = battery.getDrawable().getLevel();
        if (levelCurrent - 1 >= 0) {
            //set text view dengan ukuran yang didapatkan - 1
            ukuran.setText((levelCurrent - 1) + "L");
            //Set Image Battery
            battery.setImageLevel(levelCurrent - 1);
        } else {
            //minimum levelCurrent
            levelCurrent = 0;
            //maka akan muncul toast yang memberi tahu bahwa air sedikit
            Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show();
        }
    }

    //method yang akan dieksekusi ketika button plus di klik
    public void plus(View view) {
        levelCurrent = battery.getDrawable().getLevel();
        if (levelCurrent + 1 <= 6) {
            //set text view dengan ukuran yang sudah didapatkan + 1
            ukuran.setText((levelCurrent + 1) + "L");
            //maka set image battery dengan battery satu tingkat sebelum level tertinggi
            battery.setImageLevel(levelCurrent + 1);
        } else {
            //maksimum levelCurrent
            levelCurrent = 6;
            //maka akan muncul toast yang memberi tahu bahwa air sudah full
            Toast.makeText(this, "Air Sudah Full", Toast.LENGTH_SHORT).show();
        }
    }
}
