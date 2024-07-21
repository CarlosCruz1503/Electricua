package com.example.panelcontrol

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.panelcontrol.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        variablesYConstantes()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        maps()
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun variablesYConstantes() {
        // Variables
        var noticias = "Hello World"
        noticias = "xd"
    }

    fun maps() {
        val arrayOfTips = ArrayList<Map<String, Any>>()
        val tip1: MutableMap<String, Any> = mutableMapOf(
            "Title" to "Bombillas, mejor LED",
            "Text" to "Reemplaza tus bombillas halógenas por unas bombillas LED de bajo consumo. Las bombillas LED, aunque son un poco más caras que las normales, pueden ayudarte a ahorrar hasta un 80 % en la factura de la luz. Entre sus ventajas destaca su eficiencia, no producen calor y son ecológicas. Además, duran mucho más que las convencionales y su bajo consumo, permite un importante ahorro energético.",
            "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD"
        )
        arrayOfTips.add(tip1)

        tip1.forEach { (key, value) ->
            println("$key: $value")
        }
    }
}
