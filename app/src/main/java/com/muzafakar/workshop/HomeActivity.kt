package com.muzafakar.workshop

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("USERNAME")

        tvWelcome.text = "Hi, Selamat datang $username"

        // add an onClickListener for btnDial
        btnDial.setOnClickListener {
            // grab phone number
            val phoneNumber = etPhoneNumber.text.toString()

            // validate phone number
            if (phoneNumber.isEmpty()) {
                // show warning
                Toast.makeText(this@HomeActivity, "Phone Number mustn't empty!", Toast.LENGTH_SHORT)
                    .show()
                etPhoneNumber.error = "Gak boleh kosong!"
                return@setOnClickListener
            }

            // create implicit Intent
            val dialIntent = Intent(Intent.ACTION_DIAL) // ACTION

            // insert phone number to the Intent
            dialIntent.data = Uri.parse("tel:$phoneNumber")

            // use the Intent
            startActivity(dialIntent)
        }
    }
}
