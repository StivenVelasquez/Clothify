package com.santiagotorres.clothify.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.santiagotorres.clothify.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var productBinding : ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productBinding =ActivityProductBinding.inflate(layoutInflater)
        val view = productBinding.root
        setContentView(view)

        // Agrega la flecha de devolver en el ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        productBinding.anadirButton.setOnClickListener{
            Snackbar.make(productBinding.LinearLayout,"Añadido al carrito", Snackbar.LENGTH_INDEFINITE).setAction("Aceptar"){
            }
                .show()
        }
    }

    // Agrega un método que maneje la acción de la flecha de devolver
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}