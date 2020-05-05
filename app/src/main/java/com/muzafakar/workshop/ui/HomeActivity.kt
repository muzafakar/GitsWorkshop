package com.muzafakar.workshop.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muzafakar.workshop.util.Data
import com.muzafakar.workshop.R
import com.muzafakar.workshop.adapter.AdapterMahasiswa
import com.muzafakar.workshop.model.Mahasiswa
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    // access modifier
    private lateinit var adapterMahasiswa: AdapterMahasiswa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // inisialisasi adapter
        adapterMahasiswa = AdapterMahasiswa() {
            Toast.makeText(this, it.nama, Toast.LENGTH_SHORT).show()

            val intent = Intent(Intent.ACTION_DIAL)
            val phone = it.phone
            intent.data = (Uri.parse("tel:$phone"))
            startActivity(intent)
        }

        // memasangkan adapter ke listview
        listContact.adapter = adapterMahasiswa

        // isi adapter dengan data
        adapterMahasiswa.addData(Data.dataMahasiswa)
    }
}
