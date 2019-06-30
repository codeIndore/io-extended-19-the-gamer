package com.example.android.helpinghand

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.android.helpinghand.R
import com.google.firebase.auth.FirebaseAuth
import com.example.android.helpinghand.PhoneAuthentication
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
        signOut.setOnClickListener {
            view: View? -> mAuth.signOut()
            startActivity(Intent(this, PhoneAuthentication::class.java))
            Toast.makeText(this, "Logged out Successfully :)", Toast.LENGTH_LONG).show()
        }
    }


    override fun onStart() {
        super.onStart()
        if (mAuth.currentUser == null) {
            startActivity(Intent(this, PhoneAuthentication::class.java))
        }else {
            Toast.makeText(this, "Already Signed in :)", Toast.LENGTH_LONG).show()
        }
    }

}
