package com.vickykdv.loginnumber;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

public class KeyboardCashit extends FrameLayout implements View.OnClickListener {

    private TextView mPasswordField;
    private TextView txt_forgotpass;
    private ImageView img_showpassword,img_finger;
    private OnClickListener clickListener;
    private CompleteListener completeListener;

    public KeyboardCashit(Context context) {
        super(context);
        init();
    }

    public KeyboardCashit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyboardCashit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.keyboard, this);
        initViews();
    }

    private void initViews() {
        mPasswordField = $(R.id.password_field);
        img_showpassword = $(R.id.img_showpassword);
        txt_forgotpass = $(R.id.txt_forgotpass);
        img_finger = $(R.id.img_finger);
        $(R.id.t9_key_0).setOnClickListener(this);
        $(R.id.t9_key_1).setOnClickListener(this);
        $(R.id.t9_key_2).setOnClickListener(this);
        $(R.id.t9_key_3).setOnClickListener(this);
        $(R.id.t9_key_4).setOnClickListener(this);
        $(R.id.t9_key_5).setOnClickListener(this);
        $(R.id.t9_key_6).setOnClickListener(this);
        $(R.id.t9_key_7).setOnClickListener(this);
        $(R.id.t9_key_8).setOnClickListener(this);
        $(R.id.t9_key_9).setOnClickListener(this);
        $(R.id.img_showpassword).setOnClickListener(this);
        $(R.id.txt_forgotpass).setOnClickListener(this);
        $(R.id.img_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable editable = (Editable) mPasswordField.getText();
                int charCount = editable.length();
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount);
                }
            }
        });


    }

    public void clearPassword(){
        if(mPasswordField.length()>0){
            mPasswordField.setText("");
        }
    }

    public void setClickListener(final OnClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public void onCompletePIN(final CompleteListener changedListener){
        this.completeListener = changedListener;
    }


    public interface OnClickListener {
        void onFingerClick();
        void onForgotClick();

    }

    public interface CompleteListener{
        void ComlpletePIN();
    }


    @Override
    public void onClick(View v) {
        if (v.getTag() != null && "number_button".equals(v.getTag())) {
            mPasswordField.append(((TextView) v).getText());
            return;
        }
    }

    public String getInputText() {
        return mPasswordField.getText().toString();
    }


    public void KeyboardBuilder(String forgotText,boolean showForgot,int maxLenght,boolean showFinger){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLenght);
        mPasswordField.setFilters(fArray);

        txt_forgotpass.setText(forgotText);
        if(showForgot){
            txt_forgotpass.setVisibility(VISIBLE);
        }else{
            txt_forgotpass.setVisibility(GONE);
        }

        if(showFinger){
            img_finger.setImageDrawable(getResources().getDrawable(R.drawable.ic_fingerprint_black_24dp));
            img_finger.setOnClickListener(this);
            img_finger.setEnabled(true);
        }else{
            img_finger.setImageDrawable(null);
            img_finger.setOnClickListener(null);
            img_finger.setEnabled(false);
        }

        BuilderKeyboard(maxLenght);

    }

    public void KeyboardBuilder(String forgotText,boolean showForgot,int maxLenght){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLenght);
        mPasswordField.setFilters(fArray);

        txt_forgotpass.setText(forgotText);
        if(showForgot){
            txt_forgotpass.setVisibility(VISIBLE);
        }else{
            txt_forgotpass.setVisibility(GONE);
        }

        BuilderKeyboard(maxLenght);

    }

    public void KeyboardBuilder(String forgotText,boolean showForgot){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(255);
        mPasswordField.setFilters(fArray);

        txt_forgotpass.setText(forgotText);
        if(showForgot){
            txt_forgotpass.setVisibility(VISIBLE);
        }else{
            txt_forgotpass.setVisibility(GONE);
        }
        BuilderKeyboard(255);
    }


    public void KeyboardBuilder(boolean showForgot,int maxLenght){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLenght);
        mPasswordField.setFilters(fArray);

        txt_forgotpass.setText("Lupa kata sandi?");
        if(showForgot){
            txt_forgotpass.setVisibility(VISIBLE);
        }else{
            txt_forgotpass.setVisibility(GONE);
        }

        BuilderKeyboard(maxLenght);

    }


    public void KeyboardBuilder(int maxLenght){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLenght);
        mPasswordField.setFilters(fArray);

        txt_forgotpass.setText("Lupa kata sandi?");
        txt_forgotpass.setVisibility(VISIBLE);
        BuilderKeyboard(maxLenght);

    }

    public void KeyboardBuilder(){
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(255);
        mPasswordField.setFilters(fArray);
        txt_forgotpass.setText("Lupa kata sandi?");
        txt_forgotpass.setVisibility(VISIBLE);

        BuilderKeyboard(255);

    }


    private void BuilderKeyboard(final int lenght){

            img_finger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        clickListener.onFingerClick();
                    } catch (Exception e) {
                        Log.d("KeyboardCashit", "onClick: " + e.getMessage());
                    }
                }
            });


        txt_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    clickListener.onForgotClick();
                }catch (Exception e){
                    Log.d("KeyboardCashit", "onClick: "+e.getMessage());
                }
            }
        });

        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(mPasswordField.length() > 0){
                    mPasswordField.setBackground(getResources().getDrawable(R.drawable.edittext_style_selected));
                }else{
                    mPasswordField.setBackground(getResources().getDrawable(R.drawable.edittext_style_default));
                }
                if(lenght == mPasswordField.length())
                    completeListener.ComlpletePIN();
            }
        });

        img_showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPasswordField.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    img_showpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                    mPasswordField.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    img_showpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                    mPasswordField.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }




    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }


}
