package com.example.haspani.myuzarhaspani_1202154133_modul3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Daftarmenu extends AppCompatActivity {
    RecyclerView recv;
    Adaptermenu adptr;
    List<menulist> daftarmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarmenu);
        //set title bar menjadi Dafter Air Mineral
        setTitle("Daftar Air Mineral");

        //membuat array list baru dengan nama daftarmenu
        daftarmenu = new ArrayList<>();
        //mendapat penanganan recycler view
        recv = findViewById(R.id.rvmenu);
        recv.setHasFixedSize(true);
        //kondisi ketika orientasi menjadi landscape
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            //maka akan menampilkan 2 grid
            recv.setLayoutManager(new GridLayoutManager(Daftarmenu.this, 2));
            //jika orientasi menjadi portrait
        }else {
            //maka akan menampilkan satu grid saja
            recv.setLayoutManager(new GridLayoutManager(Daftarmenu.this, 1));
        }
        //menjalankan fungsi input data
        inputdata();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){
            recv.setLayoutManager(new GridLayoutManager(Daftarmenu.this, 2));
        }else {
            recv.setLayoutManager(new GridLayoutManager(Daftarmenu.this, 1));
        }
    }

    public void inputdata(){
        //memasukkan data ke dalam array
        daftarmenu.add(new menulist(R.drawable.ades, "Ades", "Ini adalah air mineral merk Ades. \nAdes (sebelumnya pernah disebut AdeS) adalah merek air mineral atau air minum dalam kemasan (AMDK) yang diproduksi oleh PT. Coca-Cola Bottling Indonesia, Bekasi"));
        daftarmenu.add(new menulist(R.drawable.amidis,"Amidis", "Ini adalah air mineral merk Amidis. \nAMIDIS adalah air minum kesehatan yang diproses melalui sistem distilasi atau penyulingan atau penguapan,melalui proses pemanasan hingga 180 derajat celcius sehingga menghasilkan air minum yang murni (NON-MINERAL) tanpa kandungan polutan, mineral anorganik maupun bahan kontaminasi lain seperti bahan kimia maupun bahan pestisida."));
        daftarmenu.add(new menulist(R.drawable.aqua, "Aqua", "Ini adalah air mineral merk Aqua. \nAqua adalah sebuah merek air minum dalam kemasan (AMDK) yang diproduksi oleh PT Aqua Golden Mississippi Tbk di Indonesia sejak tahun 1973"));
        daftarmenu.add(new menulist(R.drawable.cleo, "Cleo", "Ini adalah air mineral merk Cleo. \nAir Murni Cleo diambil dari mata air pegunungan dan diproses melalui hyper membrane filter 0,0001 mikron sehingga tidak mengandung mikroorganisme dan mineral anorganik"));
        daftarmenu.add(new menulist(R.drawable.club, "Club", "Ini adalah air mineral merk Club. \nClub adalah merek air minum dalam kemasan atau air mineral di Indonesia. Merek ini berasal dari Surabaya dan Pandaan, Pasuruan, Jawa Timur. Club diproduksi oleh PT Tirta Sukses Perkasa (dahulu PT Tirta Bahagia) sejak tahun 1986"));
        daftarmenu.add(new menulist(R.drawable.equil, "Equil", "Ini adalah air mineral merk Equil. \nEquil adalah air mineral anorganik yang di produksi oleh PT Equilindo Asri. Sedang pemilik PT Equilindo Asri adalah Morgen Sutanto"));
        daftarmenu.add(new menulist(R.drawable.evian, "Evian", "Ini adalah air mineral merk Evian. \nEvian adalah air mineral alami berasal dari satu sumber di puncak pegunungan Alpen, Perancis. Setiap tetesnya melewati perjalanan dan proses alam selama 15 tahun sebelum muncul di mata air"));
        daftarmenu.add(new menulist(R.drawable.leminerale, "leMinerale", "Ini adalah air mineral merk leMinerale. \nLe Minerale adalah air mineral baru dari Mayora, berupa air mineral pegunungan yang mengandung mineral alami yang dibutuhkan tubuh sehari-hari. Le Minerale, diolah dari sumber mata air pegunungan terpilih, sehingga memiliki kesegaran khas yang ditandai dengan sedikit rasa manis."));
        daftarmenu.add(new menulist(R.drawable.nestle, "Nestle", "Ini adalah air mineral merk Nestle. \nKesegaran tak tergantikan dari Nestlé Pure Life Mineral Water yang berasal dari segala kemurnian mata air pilihan dan diproses secara higienis"));
        daftarmenu.add(new menulist(R.drawable.pristine, "Pristine", "Ini adalah air mineral merk Pristine. \nAir minum yang bersih adalah air minum beralkali yang di proses ionisasi, air minum pristine adalah air alkali dengan ph 8 yang bermanfaat untuk kesehatan, air minum kemasan praktis dan ekonomis."));
        daftarmenu.add(new menulist(R.drawable.vit, "Vit", "Ini adalah air mineral merk Vit. \nVIT adalah sebuah merek air minum dalam kemasan (AMDK) yang diproduksi oleh PT Tirta Investama di Indonesia. Mulai diproduksi sejak tanggal 16 November 1982 dan awalnya dimiliki oleh PT Varia Industri Tirta"));
        //membuat adapter baru yang menghubungkan kelas ini dengan data yang ingin ditampilkan
        adptr = new Adaptermenu(this,daftarmenu);
        //menguhubungkan recycler view dengan adapter
        recv.setAdapter(adptr);
    }
}
