package com.muzafakar.workshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var email = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // handle button click
        btnLogin.setOnClickListener {

            // grab text email
            email = etEmail.text.toString()

            // grab text password
            password = etPassword.text.toString()

            // validate
            if(email == "aku@amikom.ac.id" && password == "1234"){
                // show success message
                Toast.makeText(this, "Login sukses", Toast.LENGTH_SHORT).show()
            }else{
                // show error message
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
