package eu.ase.ro.otpverification;

//SCRIU EXACT CODUL DIN VIDEO - https://www.youtube.com/watch?v=ebZfTX_tQAU

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);

        //final EditText usernameET = findViewById(R.id.usernameET);
        final TextInputEditText phoneNumberTIET = findViewById(R.id.phoneNumber_edit_text);

        //final EditText passwordET = findViewById(R.id.passwordET);
        final TextInputEditText passwordTIET = findViewById(R.id.password_edit_text);


        //final TextView signUpBtn = findViewById(R.id.signUpBtn);
        final ImageButton loginBtn = findViewById(R.id.loginBtn);

        //final ImageView passwordIcon = findViewById(R.id.passwordIcon)
        //DE PUS IMAGINEA CU OCHISORUL! - ca noi n-avem

/* SWITCH-UL PENTRU OCHI - VIZIBIL/INVIZIBIL

"checking if password is showing or not"

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordShowing){
                    passwordShowing = false;

                    passwordTIET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_show);
                }
                else{
                    passwordShowing = true;

                    passwordTIET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_hide);
                }
                // move the cursor at last of the text
                passwordTIET.setSelection(passwordTIET.length());
            }
        });
*/
        /*
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(Login.this, OTPVerification.class));
            }
        });
        */

        //                  SAU

        /*
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String getPhoneNumberTxt = phoneNumberTIET.getText().toString();
                final String getPasswordTxt = passwordTIET.getText().toString();

                //opening OTP Verification Activity along with mobile and password
                Intent intent = new Intent(Login.this, OTPVerification.class);

                intent.putExtra("mobile", getPhoneNumberTxt);
                intent.putExtra("password", getPasswordTxt);

                startActivity.intent();

            }
        });
        */

        //PENTRU NUMARUL DE TELEFON ?

        //SA VAD CE A SCRIS SI ALEXANDRA LA PARTEA DE LOGIN

        // + TREBUIE O VALIDARE SAU CEVA LA PAROLA ???

    }
}
