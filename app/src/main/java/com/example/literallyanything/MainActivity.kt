package com.example.literallyanything

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_take_picture -> Toast.makeText(this, "Taking picture", Toast.LENGTH_SHORT)
                .show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://temple.edu")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this).setTitle("Confirmation")
                    .setMessage("Are you sure you want to delete?")
                    .setPositiveButton("Yes") { _, _ ->
                        Toast.makeText(this, "Picture deleted", Toast.LENGTH_SHORT).show()
                    }.setNegativeButton("Nevermind") { _, _ ->
                    Toast.makeText(
                        this,
                        "Picture not deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                }.create().show()
            }
            else -> return false
        }
        return true
    }
}