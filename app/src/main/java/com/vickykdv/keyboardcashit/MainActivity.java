package com.vickykdv.keyboardcashit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vickykdv.loginnumber.KeyboardCashit;


public class MainActivity extends AppCompatActivity {

    public KeyboardCashit keyboardCashit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         keyboardCashit= findViewById(R.id.keyboard);
        keyboardCashit.KeyboardBuilder("Lupa kata sandi?",true,6,true);
        keyboardCashit.setClickListener(new KeyboardCashit.OnClickListener() {
            @Override
            public void onFingerClick() {
                Toast.makeText(MainActivity.this,"Finger Click ?",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onForgotClick() {
                Toast.makeText(MainActivity.this,"Forgot Click ?",Toast.LENGTH_LONG).show();
            }

        });

        keyboardCashit.onCompletePIN(new KeyboardCashit.CompleteListener() {
            @Override
            public void ComlpletePIN() {
                //                Toast.makeText(MainActivity.this,keyboardCashit.getInputText(),Toast.LENGTH_LONG).show();
                Log.d("MainActivity", "ComlpletePIN: " + keyboardCashit.getInputText());

                if(!keyboardCashit.getInputText().matches("123456")){
                  keyboardCashit.clearPassword();
                    Toast.makeText(MainActivity.this,"Password salah",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Password benar",Toast.LENGTH_LONG).show();

                }
            }

        });





    }
}
