package com.santiagotorres.clothify.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.santiagotorres.clothify.databinding.ActivitySignInBinding
import com.santiagotorres.clothify.ui.BottomNavigationActivity
import com.santiagotorres.clothify.ui.recovery.RecoveryActivity
import com.santiagotorres.clothify.ui.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding
    private lateinit var signInViewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        signInViewModel = ViewModelProvider(this)[SignInViewModel::class.java]

        val view = signInBinding.root
        setContentView(view)

        signInViewModel.errorMsg.observe(this){errorMsg ->
            Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
        }

        signInBinding.registerTextView.setOnClickListener(){
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInBinding.recoveryTextView.setOnClickListener(){
            startActivity(Intent(this, RecoveryActivity::class.java))
        }

        signInViewModel.isSuccessSignIn.observe(this){
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
            finish()
        }

        signInBinding.loginButton.setOnClickListener(){
            val email = signInBinding.emailEditText.text.toString()
            val password = signInBinding.passwordEditText.text.toString()

            signInViewModel.validateFields (email, password)

        }
    }
}