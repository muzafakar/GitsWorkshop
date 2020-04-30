package com.muzafakar.workshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var username = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // handle button click
        btnLogin.setOnClickListener {

            // grab text email
            username = etUsername.text.toString()

            // grab text password
            password = etPassword.text.toString()

            // validate
            if (password == "1234") {
                // show success message
                Toast.makeText(this, "Login sukses: $username", Toast.LENGTH_SHORT).show()

                // Create an explicit Intent        Dari mana?                   Kemana?
                val homeIntent = Intent(this@MainActivity, HomeActivity::class.java)
                homeIntent.putExtra("USERNAME", username)

                // clear input
                etUsername.text.clear()
                etPassword.text.clear()

                // Use the Intent
                startActivity(homeIntent)
            } else {
                // show error message
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
