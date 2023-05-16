package com.santiagotorres.clothify.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.santiagotorres.clothify.R
import com.santiagotorres.clothify.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        val view = signUpBinding.root
        setContentView(view)

        signUpViewModel.errorMsg.observe(this){errorMsg ->
            Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
        }

        signUpViewModel.isSuccessSignUp.observe(this){

            val dialog = AlertDialog.Builder(this)
                .setTitle(R.string.dialog_one_style_title)
                .setMessage(R.string.dialog_one_style_message)
                .setPositiveButton(R.string.dialog_one_style_positive_btn) { view, _ ->
                    //val intent = Intent(this, SignInActivity::class.java)
                    //startActivity(intent)
                    //.dismiss()
                    //signUpBinding.emailEditText.setText("")
                    //signUpBinding.nameEditText.setText("")
                    //signUpBinding.passwordEditText.setText("")
                    //signUpBinding.repPasswordEditText.setText("")
                    onBackPressedDispatcher.onBackPressed()
                }
                .setCancelable(false)
                .create()

            dialog.show()


        }


        signUpBinding.registerButton.setOnClickListener {

            val user = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repPassword= signUpBinding.repPasswordEditText.text.toString()

            signUpViewModel.validateFields(user,email,password,repPassword,user)


        }
    }

}
