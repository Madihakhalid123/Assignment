package com.example.customdilouge

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.customdilouge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.lgn.setOnClickListener() {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.signup)
            dialog.setCancelable(false)
            var m = dialog.findViewById<Button>(R.id.lgn)

            dialog.show()


        }


        binding.sign.setOnClickListener() {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.signup)
            dialog.setCancelable(false)
            dialog.show()
            var a = dialog.findViewById<Button>(R.id.lgn).setOnClickListener() {
                var email = dialog.findViewById<EditText>(R.id.email).text.toString()
                var pas = dialog.findViewById<EditText>(R.id.pass).text.toString()
                var cpas = dialog.findViewById<EditText>(R.id.cpass).text.toString()

                if (TextUtils.isEmpty(email) || !email.contains("@gmail.com")) {
                    dialog.findViewById<EditText>(R.id.email).setError("Enter valid email")
                } else if (TextUtils.isEmpty(pas)) {
                    dialog.findViewById<EditText>(R.id.pass).setError("Enter valid password")
                } else if (TextUtils.isEmpty(cpas)) {
                    dialog.findViewById<EditText>(R.id.cpass).setError("Enter same password")
                } else {
                    Toast.makeText(this, "Sigin up successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, home::class.java))
                    finish()
                }


            }

        }
    }
}

