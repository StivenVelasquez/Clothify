package com.santiagotorres.clothify.ui.recovery

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.santiagotorres.clothify.R
import com.santiagotorres.clothify.databinding.ActivityRecoveryBinding
import com.santiagotorres.clothify.ui.signin.SignInActivity

class RecoveryActivity : AppCompatActivity() {


    private lateinit var recoveryBinding: ActivityRecoveryBinding
    private lateinit var recoveryViewModel: RecoveryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recoveryBinding = ActivityRecoveryBinding.inflate(layoutInflater)
        recoveryViewModel = ViewModelProvider(this)[RecoveryViewModel::class.java]

        val view = recoveryBinding.root
        setContentView(view)


        recoveryViewModel.errorMsg.observe(this){errorMsg ->
            Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
        }


        recoveryViewModel.isCorrect.observe(this){
            val dialog = AlertDialog.Builder(this)
                .setTitle(R.string.dialog_one_style_title_recovery)
                .setMessage(R.string.dialog_one_style_message_recovery)
                .setPositiveButton(R.string.dialog_one_style_positive_btn_recovery) { view, _ ->
                    //val intent = Intent(this, SignInActivity::class.java)
                    //startActivity(intent)
                    //view.dismiss()
                    //recoveryBinding.emailEditText.setText("")
                    onBackPressedDispatcher.onBackPressed()
                }
                .setCancelable(false)
                .create()

            dialog.show()

        }


        recoveryBinding.sendButton.setOnClickListener(){
            val email = recoveryBinding.emailEditText.text.toString()

            recoveryViewModel.validateFields(email)

        }
    }
}


