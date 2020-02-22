# Keyboard Login
Library for login, set pin , forgot password and layout with keyboard number

### How To Use
     implementation "com.github.CASH-IT-Developer:CashitKeyboard:1.0.0"

### Implementation in XML

      <?xml version="1.0" encoding="utf-8"?>
      <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".MainActivity">

        <com.vickykdv.loginnumber.KeyboardCashit
          android:id="@+id/keyboard"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_centerInParent="true">
        </com.vickykdv.loginnumber.KeyboardCashit>
      
      </RelativeLayout>


### Implementation in Programatically
      
     //Initial View ID
     final KeyboardCashit keyboardCashit = findViewById(R.id.keyboard);
        
        //Custom value
        keyboardCashit.KeyboardBuilder("Lupa kata sandi?",true,6);
        
        //Listener Clicked finger Icon (if Visibility ) and forgot password (if Visibility)
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


        //Listen value PIN (check validasi with lenght PIN)
        keyboardCashit.onTextWatcher(new KeyboardCashit.ValueListener() {
            @Override
            public void CheckListen() {
                Toast.makeText(MainActivity.this,keyboardCashit.getInputText(),Toast.LENGTH_LONG).show();
            }
        });
        
        
   ### Code by vickykdv (https://github.com/vickyKDV) 
