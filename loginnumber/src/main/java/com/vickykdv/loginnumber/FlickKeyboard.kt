package com.vickykdv.loginnumber

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.IdRes
import com.chaos.view.PinView

class FlickKeyboard : LinearLayout, View.OnClickListener {
    var mPassword: PinView? = null
    private var txt_forgotpass: TextView? = null
    private var img_showpassword: ImageView? = null
    private var img_finger: ImageView? = null
    private var clickListener: OnListener? = null
    private var isHidePassword: Boolean = true
    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.keyboard, this)
        initViews()
    }

    private fun initViews() {
        mPassword = view<PinView>(R.id.passwordView)
        img_showpassword = view<ImageView>(R.id.img_showpassword)
        txt_forgotpass = view<TextView>(R.id.txt_forgotpass)
        img_finger = view<ImageView>(R.id.img_finger)
        view<View>(R.id.t9_key_0).setOnClickListener(this)
        view<View>(R.id.t9_key_1).setOnClickListener(this)
        view<View>(R.id.t9_key_2).setOnClickListener(this)
        view<View>(R.id.t9_key_3).setOnClickListener(this)
        view<View>(R.id.t9_key_4).setOnClickListener(this)
        view<View>(R.id.t9_key_5).setOnClickListener(this)
        view<View>(R.id.t9_key_6).setOnClickListener(this)
        view<View>(R.id.t9_key_7).setOnClickListener(this)
        view<View>(R.id.t9_key_8).setOnClickListener(this)
        view<View>(R.id.t9_key_9).setOnClickListener(this)
//        view<View>(R.id.img_showpassword).setOnClickListener(this)
        view<View>(R.id.txt_forgotpass).setOnClickListener(this)

        view<View>(R.id.img_backspace).setOnClickListener {
            val editable = mPassword!!.text as Editable
            val charCount = editable.length
            if (charCount > 0) {
                editable.delete(charCount - 1, charCount)
            }
        }


//        mPassword!!.transformationMethod = PasswordTransformationMethod()






        view<View>(R.id.img_showpassword).setOnClickListener {
            if(isHidePassword){
                isHidePassword = false
                mPassword!!.transformationMethod = PasswordTransformationMethod()
                img_showpassword!!.setImageDrawable(resources.getDrawable(R.drawable.ic_visibility_off_black_24dp))
            }else{
                isHidePassword = true
                mPassword!!.transformationMethod = HideReturnsTransformationMethod()
                img_showpassword!!.setImageDrawable(resources.getDrawable(R.drawable.ic_visibility_black_24dp))
            }
        }
    }

    fun clearPassword() {
        mPassword!!.text?.clear()
    }

    fun setClickListener(clickListener: OnListener? = null) {
        this.clickListener = clickListener
    }

    override fun onClick(v: View) {
        if (v.tag != null && "number_button" == v.tag) {
            mPassword!!.append((v as TextView).text)
            return
        }
    }
    fun Builder(
            forgotText: String = "Lupa kata sandi?",
            showForgot: Boolean = false,
            showFinger: Boolean = false,
            showTogglePassword: Boolean = false,
            maxLenght: Int = 6,
    ) {
        val fArray = arrayOfNulls<InputFilter>(1)
        fArray[0] = LengthFilter(maxLenght)
        mPassword!!.filters = fArray
        for (i in 0 until maxLenght) {

        }
        clearPassword()
        mPassword!!.itemCount = maxLenght
        mPassword!!.setSingleLine()
        txt_forgotpass!!.text = forgotText

//        mPassword!!.setItemBackground(resources.getDrawable(R.drawable.circle_view_keyboard_login))

        if (showForgot) txt_forgotpass!!.visibility = VISIBLE else txt_forgotpass!!.visibility = GONE

        if(showTogglePassword) img_showpassword!!.visibility = View.VISIBLE else img_showpassword!!.visibility = View.GONE

        if (showFinger) {
            img_finger!!.setImageDrawable(resources.getDrawable(R.drawable.ic_fingerprint_black_24dp))
            img_finger!!.setOnClickListener(this)
            img_finger!!.isEnabled = true
        } else {
            img_finger!!.setImageDrawable(null)
            img_finger!!.setOnClickListener(null)
            img_finger!!.isEnabled = false
        }

        img_finger!!.setOnClickListener {
            try {
                clickListener!!.onFingerClick()
            } catch (e: Exception) {
                Log.d("KeyboardCashit", "onClick: " + e.message)
            }
        }

        txt_forgotpass!!.setOnClickListener {
            try {
                clickListener!!.onForgotClick()
            } catch (e: Exception) {
                Log.d("KeyboardCashit", "onClick: " + e.message)
            }
        }

        mPassword!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (mPassword!!.length() == maxLenght) {
                    Log.d("mPassword", "afterTextChanged: ${mPassword!!.text.toString()}")
                    clickListener!!.onCompleted(mPassword!!.text.toString())
                }
            }
        })

        if(isHidePassword){
            isHidePassword = false
            mPassword!!.transformationMethod = PasswordTransformationMethod()
            img_showpassword!!.setImageDrawable(resources.getDrawable(R.drawable.ic_visibility_off_black_24dp))
        }else{
            isHidePassword = true
            mPassword!!.transformationMethod = HideReturnsTransformationMethod()
            img_showpassword!!.setImageDrawable(resources.getDrawable(R.drawable.ic_visibility_black_24dp))
        }
    }


    protected fun <T : View?> view(@IdRes id: Int): T {
        return super.findViewById<View>(id) as T
    }
}