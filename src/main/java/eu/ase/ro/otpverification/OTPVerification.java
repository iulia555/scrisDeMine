package eu.ase.ro.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTPVerification extends AppCompatActivity {

    private EditText otpET1, otpET2, otpET3, otpET4, otpET5, otpET6;
    private TextView resendBtn;

    //true after every 60 seconds
    private boolean resendEnabled = false;

    //resend time in seconds
    private int resendTime = 60;

    private int selectedETPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        otpET1 = findViewById(R.id.optET1);
        otpET2 = findViewById(R.id.optET2);
        otpET3 = findViewById(R.id.optET3);
        otpET4 = findViewById(R.id.optET4);
        otpET5 = findViewById(R.id.optET5);
        otpET6 = findViewById(R.id.optET6);

        resendBtn = findViewById(R.id.tv_retrimite);
        final Button continueBtn =  findViewById(R.id.continueBtn);

        //final TextView otpEmail = findViewById(R.id.otpEmail);
        //final TextView otpMobile = findViewById(R.id.otpMobile);

        //getting email and mobile from Register activity through intent
        //final String getEmail = getIntent().getStringExtra("email");
        //final String getMobile = getIntent().getStringExtra("mobile");

        //setting email and mobile to TextView
        //otpEmail.setText(getEmail);
        //otpMobile.setText(getMobile);

        //otpET1.addTextChangedListener(textWatcher);
        //otpET2.addTextChangedListener(textWatcher);
        //otpET3.addTextChangedListener(textWatcher);
        //otpET4.addTextChangedListener(textWatcher);
        //otpET5.addTextChangedListener(textWatcher);
        //otpET6.addTextChangedListener(textWatcher);

        // by default open keyboard at otpET1
        showKeyboard(otpET1);

        // start resend count down timer
        startCountDownTimer();

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resendEnabled){

                    // handle your resend code here

                    // start new resend count down timer
                    startCountDownTimer();
                }
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String generateOTP = otpET1.getText().toString()+ otpET2.getText().toString() + otpET3.getText().toString() + otpET4.getText().toString() + otpET5.getText().toString() + otpET6.getText().toString();

                if(generateOTP.length() == 6){

                    //handle your otp verification here

                }
            }
        });

    }

    private void showKeyboard(EditText otpET){

        otpET.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);

    }

    private void startCountDownTimer(){
        resendEnabled = false;
        resendBtn.setTextColor(Color.parseColor("#089cd4"));

                new CountDownTimer(resendTime * 60, 100){

                    @Override
                    public void onTick(long millisUntilFinished) {
                        resendBtn.setText("Retrimite (" + (millisUntilFinished/60) + ")");
                    }

                    @Override
                    public void onFinish() {
                        resendEnabled = true;
                        resendBtn.setText("Retrimite");
                        resendBtn.setTextColor(getResources().getColor(R.color.black));
                        //aici era R.color.primary
                    }
                }.start();
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(editable.length() > 0){
                if(selectedETPosition == 0){
                    selectedETPosition = 1;
                    showKeyboard(otpET2);
                }
                else if(selectedETPosition == 1){
                    selectedETPosition = 2;
                    showKeyboard(otpET3);
                }
                else if(selectedETPosition == 2){
                    selectedETPosition = 3;
                    showKeyboard(otpET4);
                }
                else if(selectedETPosition == 3){
                    selectedETPosition = 4;
                    showKeyboard(otpET5);
                }
                else if(selectedETPosition == 4){
                    selectedETPosition = 5;
                    showKeyboard(otpET6);
                }
            }
        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_DEL){
            if(selectedETPosition == 5){
                selectedETPosition = 4;
                showKeyboard(otpET5);
            }
            else if(selectedETPosition == 4){
                selectedETPosition = 3;
                showKeyboard(otpET4);
            }
            else if(selectedETPosition == 3){
                selectedETPosition = 2;
                showKeyboard(otpET3);
            }
            else if(selectedETPosition == 2){
                selectedETPosition = 1;
                showKeyboard(otpET2);
            }
            else if(selectedETPosition == 1){
                selectedETPosition = 0;
                showKeyboard(otpET1);
            }

            return true;
        }
        else{
            return super.onKeyUp(keyCode, event);
        }
    }
}