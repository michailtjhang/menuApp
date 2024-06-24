package com.example.menuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                Toast.makeText(applicationContext, "Halaman About", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, About::class.java))
            }
            R.id.help -> {
                Toast.makeText(applicationContext, "Halaman Help", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Help::class.java))
            }
            R.id.setting -> {
                Toast.makeText(applicationContext, "Halaman Setting", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Setting::class.java))
            }
            R.id.exit -> {
                showExitDialog()
            }
        }
        return true
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("Keluar dari Aplikasi?")
            setMessage("Klik Ya untuk keluar")
            setIcon(R.mipmap.ic_launcher)
            setCancelable(false)
            setPositiveButton("Ya") { _, _ ->
                finish()
                exitProcess(0)
            }
            setNegativeButton("Tidak") { dialog, _ ->
                dialog.cancel()
            }
            show()
        }
    }
}