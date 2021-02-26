package com.vickykdv.keyboardcashit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vickykdv.loginnumber.FlickKeyboard
import com.vickykdv.loginnumber.OnListener

class MainActivity : AppCompatActivity() {
    private var flickKeyboard: FlickKeyboard? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flickKeyboard = findViewById(R.id.keyboard)

        flickKeyboard!!.Builder(
                forgotText = "Lupa kata sandi?",
                showForgot = true,
                showFinger = true,
                showTogglePassword = true,
                maxLenght = 3
        )
        flickKeyboard!!.setClickListener(object : OnListener {
            override fun onCompleted(pin: String) {
                if (pin != "123") {
                    flickKeyboard!!.clearPassword()
                    Toast.makeText(this@MainActivity, "Password salah", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Password benar", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFingerClick() {
                Toast.makeText(this@MainActivity, "Finger Click ?", Toast.LENGTH_LONG).show()
            }

            override fun onForgotClick() {
                Toast.makeText(this@MainActivity, "Forgot Click ?", Toast.LENGTH_LONG).show()
            }
        })
    }
}