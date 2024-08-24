package com.example.panelcontrol.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.panelcontrol.Modelos.Plantation
import com.example.panelcontrol.R
import com.example.panelcontrol.databinding.FragmentHomeBinding
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.Locale
import java.io.BufferedReader;
import java.io.BufferedWriter;
import android.util.Log
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val buttonControl: Button = root.findViewById(R.id.button)
        val zone = root.findViewById<TextView>(R.id.zone)
        val month = root.findViewById<TextView>(R.id.month)
        val floors = root.findViewById<TextView>(R.id.floors)
        val cost = root.findViewById<TextView>(R.id.cost)

        buttonControl.setOnClickListener {
            val datosGuardados = guardarDatos(
                zone.text.toString(),
                month.text.toString(),
                floors.text.toString(),
                cost.text.toString()
            )
            if (datosGuardados) {
                // Se cambia de actividad
                Toast.makeText(requireContext(), "Datos Guardados con exito",
                    Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Error al guardar el archivo",
                    Toast.LENGTH_SHORT).show();
            }

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun guardarDatos(zone: String, month: String, floors: String, cost: String): Boolean {
        return try {
            val file = File(requireContext().filesDir, "plantation.txt")
            val writer = FileWriter(file, true) // Append mode
            val bufferedWriter = BufferedWriter(writer) // Initialize BufferedWriter

            val plantation = Plantation(cost.toFloat(), month, zone, floors.toInt())

            val linea = String.format(
                Locale.getDefault(),
                "%.2f,%s,%s,%d",
                plantation.getCost(),
                plantation.getMonth(),
                plantation.getZone(),
                plantation.getFloors()
            )

            bufferedWriter.write(linea)
            bufferedWriter.newLine()
            bufferedWriter.close()
            true
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("HomeFragment", "Error saving data", e)
            false
        }
    }

}



