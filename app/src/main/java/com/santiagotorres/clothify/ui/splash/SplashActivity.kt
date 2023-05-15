package com.santiagotorres.clothify.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.santiagotorres.clothify.databinding.ActivitySplashBinding
import com.santiagotorres.clothify.ui.BottomNavigationActivity
import com.santiagotorres.clothify.ui.main.MainActivity
import com.santiagotorres.clothify.ui.signin.SignInActivity
import com.santiagotorres.clothify.ui.signup.SignUpActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding:ActivitySplashBinding
    private lateinit var splashViewModel: SplashViewModel

    private var auth: FirebaseAuth = Firebase.auth

    private var isSessionActive = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        val view = splashBinding.root
        setContentView(view)

        splashViewModel.validateSessionActive()

        splashViewModel.isSessionActive.observe(this){_isSessionActive ->
            this.isSessionActive = _isSessionActive
        }

        val timer = Timer()
        timer.schedule(
            timerTask {

                if (!isSessionActive){
                    val intent = Intent(this@SplashActivity, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this@SplashActivity, BottomNavigationActivity::class.java)
                    startActivity(intent)
                    finish()
                }



            }, 2000
        )

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "OK")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "OK")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause", "OK")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop", "OK")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart", "OK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy", "OK")
    }
}