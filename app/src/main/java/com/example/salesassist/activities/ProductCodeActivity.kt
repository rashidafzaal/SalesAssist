package com.example.salesassist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.salesassist.Constants
import com.example.salesassist.MyPrefKeys
import com.example.salesassist.R
import com.example.salesassist.Utils
import com.tramsun.libs.prefcompat.Pref
import kotlinx.android.synthetic.main.activity_product_code.*

class ProductCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_product_code)

        btnProceed.setOnClickListener {
            if (etProductCode.text.isNotEmpty()) {
                val finalURL = Constants.BASE_URL + etProductCode.text
                Utils.showToast(this, finalURL)

                //save in SharedPref
                Pref.putString(MyPrefKeys.FINAL_URL, finalURL)

                //move to next activity
                val intent = Intent(this@ProductCodeActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Utils.showToast(this, "Please Fill All Fields")
            }
        }
    }
}