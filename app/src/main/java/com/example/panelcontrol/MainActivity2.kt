package com.example.panelcontrol

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.panelcontrol.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

//    private lateinit var appBarConfiguration: AppBarConfiguration
private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMain2Binding.inflate(layoutInflater)
     setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        binding.textView6.text = title
        binding.textView7.text = description
////        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->

            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//    val navController = findNavController(R.id.nav_host_fragment_content_main)
//    return navController.navigateUp(appBarConfiguration)
//            || super.onSupportNavigateUp()
//    }
}