# Keyboard Login
Library for login, set pin , forgot password and layout with keyboard number

Hide Password              |  Show Password
:-------------------------:|:-------------------------:
![alt text](https://raw.githubusercontent.com/CASH-IT-Developer/CashitKeyboard/master/ck1.jpeg)  |  ![alt text](https://raw.githubusercontent.com/CASH-IT-Developer/CashitKeyboard/master/ck2.jpeg)



### How To Use
     implementation "com.github.CASH-IT-Developer:CashitKeyboard:1.0.7"

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
          keyboard.onCompletePIN(new KeyboardCashit.CompleteListener() {
                     @Override
                     public void ComlpletePIN() {
                    Toast.makeText(MainActivity.this,keyboardCashit.getInputText(),Toast.LENGTH_LONG).show();
                    }
               });
        
        
   ### Code by vickykdv (https://github.com/vickyKDV) 
   
   
   ### License
          
    Copyright 2020 PT. Kreigan Sentral Teknologi
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
          
    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
