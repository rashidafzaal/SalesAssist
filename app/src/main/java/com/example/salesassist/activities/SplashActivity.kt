package com.example.salesassist.activities

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.salesassist.MyPrefKeys
import com.example.salesassist.R
import com.tbruyelle.rxpermissions3.RxPermissions
import com.tramsun.libs.prefcompat.Pref

class SplashActivity : AppCompatActivity() {

    private lateinit var rxPermissions: RxPermissions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)

        rxPermissions = RxPermissions(this)
        askPermission()
    }

    private fun askPermission() {
        rxPermissions
            .request(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) {
                    goToNextActivity()
                } else {
                    askPermission()
                }
            }
    }
    private fun goToNextActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (Pref.getString(MyPrefKeys.TOKEN).isNotEmpty()) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 20)

    }
}