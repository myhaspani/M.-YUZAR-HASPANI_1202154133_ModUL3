package com.example.haspani.myuzarhaspani_1202154133_modul3;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class Splashscreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //mengatur splashscreen sehingga nanti setelah 3 detik pindah ke main activity
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {

                                          //mengatur intent SplashScreen ke Main Activity
                                          Intent i = new Intent(Splashscreen.this, Login.class);
                                          startActivity(i);
                                          //untuk menampilkan toast
                                          Toast.makeText(Splashscreen.this, "M. YUZAR HASPANI_1202154133", Toast.LENGTH_LONG).show();

                                          this.finish();
                                      }

                                      private void finish() {

                                      }
                                  },
                //mengatur time out dari splash screen
                3000);

    }

    ;
}