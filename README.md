# Keyboard Login
Library for login, set pin , forgot password and layout with keyboard number

[![](https://jitpack.io/v/CASH-IT-Developer/loginKeyboard.svg)](https://jitpack.io/#CASH-IT-Developer/loginKeyboard)


Hide Password              |  Show Password
:-------------------------:|:-------------------------:
![alt text](https://raw.githubusercontent.com/CASH-IT-Developer/loginKeyboard/master/ck1.jpeg)  |  ![alt text](https://raw.githubusercontent.com/CASH-IT-Developer/loginKeyboard/master/ck2.jpeg)



### How To Use
     dependencies {
     	        implementation 'com.github.CASH-IT-Developer:loginKeyboard:Tag'
     	}
     
     
### `and` 
     
     allprojects {
     		repositories {
     			...
     			maven { url 'https://jitpack.io' }
     		}
     	}

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
            private var flickKeyboard: FlickKeyboard? = null
        
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
# CashitKeyboard
# loginKeyboard
