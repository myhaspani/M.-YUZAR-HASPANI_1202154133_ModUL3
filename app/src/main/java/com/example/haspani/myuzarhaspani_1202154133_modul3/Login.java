package com.example.haspani.myuzarhaspani_1202154133_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //    Deklarasi variabel
    private EditText Username, Pass;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

//      Inisiasi dengan id
        Username = (EditText)findViewById(R.id.userForm);
        Pass = (EditText)findViewById(R.id.passForm);
        Login = (Button) findViewById(R.id.btnLogin);

//      Membuat tombol dapat di klik
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString().trim();
                String pass = Pass.getText().toString().trim();

                if(user.equals("EAD") && pass.equals("MOBILE")){
                    Intent intent = new Intent(Login.this, Daftarmenu.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "Username and Password are incorect. Try Again", Toast.LENGTH_SHORT).show();
                }
                if(user.isEmpty()){
                    Toast.makeText(Login.this, "Please Input Username", Toast.LENGTH_SHORT).show();
                }if(pass.isEmpty()){
                    Toast.makeText(Login.this, "Please Input Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
