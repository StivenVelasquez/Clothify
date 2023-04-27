package com.santiagotorres.clothify.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.santiagotorres.clothify.R
import com.santiagotorres.clothify.databinding.ActivitySignUpBinding
import com.santiagotorres.clothify.ui.signin.SignInActivity

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
            val builder = AlertDialog.Builder(this)
            val viewdialog = layoutInflater.inflate(R.layout.dialog1, null)

            builder.setView(viewdialog)

            val dialog = builder.create()
            dialog.show()

            val txtClave : EditText = view.findViewById(R.id.TxtClave)

            val intent = Intent(this, SignInActivity::class.java)

            viewdialog.setOnClickListener(){
                dialog.hi
                //startActivity(intent)

            }

        }


        signUpBinding.registerButton.setOnClickListener {

            val user = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repPassword= signUpBinding.repPasswordEditText.text.toString()

            signUpViewModel.validateFields(user,email,password,repPassword)


        }
    }
}
