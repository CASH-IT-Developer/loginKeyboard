package com.vickykdv.keyboardcashit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        keyboardCashit.KeyboardBuilder("Lupa kata sandi?",true,true);
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

        keyboardCashit.mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() == 6){
                    if(!keyboardCashit.getInputText().matches("123456")){
                        keyboardCashit.clearPassword();
                        Toast.makeText(MainActivity.this,"Password salah",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Password benar",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

//        keyboardCashit.onCompletePIN(new KeyboardCashit.CompleteListener() {
//            @Override
//            public void CompletePIN() {
//                //                Toast.makeText(MainActivity.this,keyboardCashit.getInputText(),Toast.LENGTH_LONG).show();
//                Log.d("MainActivity", "ComlpletePIN: " + keyboardCashit.getInputText());
//
//                if(!keyboardCashit.getInputText().matches("123456")){
//                  keyboardCashit.clearPassword();
//                    Toast.makeText(MainActivity.this,"Password salah",Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(MainActivity.this,"Password benar",Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//        });





    }
}
