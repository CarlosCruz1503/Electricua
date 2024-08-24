package com.example.panelcontrol.ui.dashboard



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.panelcontrol.Modelos.Plantation
import com.example.panelcontrol.R
import com.example.panelcontrol.Tips
import com.example.panelcontrol.ui.Table
import com.example.panelcontrol.databinding.FragmentDashboardBinding
import java.io.File
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textFile: File = File(requireContext().filesDir, "plantation.txt")
        val listaAgua: kotlin.collections.List<Plantation> = leerArchivo(textFile)
        val arbolesPorZone = treesByZone(listaAgua)
        val costoPromedio = averageCost(listaAgua)
        val arbolesPorMes = treesByMonth(listaAgua)
        val arbolesPromedio = averageFloors(listaAgua)
        Log.d("DashboardFragment", "Esta es la lista: $listaAgua")
        Log.d("DashboardFragment", "arboles por mes: $arbolesPorMes")
        Log.d("DashboardFragment", "arboles por zona: $arbolesPorZone")
        Log.d("DashboardFragment", "Este es el promedio de costo: $costoPromedio")
        Log.d("DashboardFragment", "Este es el total de arboles: $arbolesPromedio")
        val containerLayout: LinearLayout = root.findViewById(R.id.fragment_container)
        val linearLayoutP: LinearLayout = root.findViewById(R.id.linearLayoutP)
//        val containerLayoutTable: LinearLayout = root.findViewById(R.id.fragment_container_table)
//        val fragment2 = Table.newInstance("aaa","xxxx")
//        childFragmentManager.beginTransaction()
//            .add(containerLayoutTable.id, fragment2)
//            .commit()
        val tableLayout = root.findViewById<TableLayout>(R.id.tableLayout)
        val tableLayoutZone = root.findViewById<TableLayout>(R.id.tableLayoutZone)

        addTableRow(tableLayout, "Mes", "Arboles Plantados", isHeader = true)
        addTableRow(tableLayoutZone, "Zona", "Arboles Plantados", isHeader = true)

        // Adding data rows
        arbolesPorMes.forEach { (city, treesPlanted) ->
            addTableRow(tableLayout, city, treesPlanted.toString())
        }

        arbolesPorZone.forEach { (city, treesPlanted) ->
            addTableRow(tableLayoutZone, city, treesPlanted.toString())
        }
        val text1 = TextView(context).apply {
            text = "Este es el promedio de costo: $costoPromedio"
            setPadding(10, 10, 10, 10)
            setBackgroundResource(R.color.white)

        }

        val text2 = TextView(context).apply {
            text = "Este es el total de arboles: $arbolesPromedio"
            setPadding(10, 10, 10, 10)
            setBackgroundResource(R.color.white)

        }

        linearLayoutP.addView(text1)
        linearLayoutP.addView(text2)
        linearLayoutP.requestLayout()



        listaAgua.forEach { tip ->
            Log.d("DashboardFragment","Elemento: ${tip.month}")
            val month = tip.month as String
            val zone = tip.zone as String
            val cost = tip.cost.toString()
            val floors = tip.floors.toString()

            val fragment = Tips.newInstance(cost, month, zone, floors )
            childFragmentManager.beginTransaction()
                .add(containerLayout.id, fragment)
                .commit()
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun leerArchivo(archivo: File): List<Plantation> {
        val listaPlantation = mutableListOf<Plantation>()

        try {
            BufferedReader(FileReader(archivo)).use { br ->
                var linea: String?
                while (br.readLine().also { linea = it } != null) {
                    val datos = linea!!.split(",")
                    val cost = datos[0].toFloat()
                    val month = datos[1].toString()
                    val zone = datos[2]
                    val floors = datos[3].toInt()
                    val plantation = Plantation(cost, month, zone, floors)
                    listaPlantation.add(plantation)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return listaPlantation
    }
    private fun treesByMonth(data: List<Plantation>): Map<String, Int> {
        val monthlyTrees = mutableMapOf<String, Int>()
        data.forEach { entry ->
            val month = entry.month
            val floors = entry.floors
            monthlyTrees[month] = monthlyTrees.getOrDefault(month, 0) + floors
        }
        return monthlyTrees
    }

    private fun treesByZone(data: List<Plantation>): Map<String, Int> {
        val zoneTrees = mutableMapOf<String, Int>()
        data.forEach { entry ->
            val zone = entry.zone
            val floors = entry.floors
            zoneTrees[zone] = zoneTrees.getOrDefault(zone, 0) + floors
        }
        return zoneTrees
    }

    private fun averageCost(data: List<Plantation>): Double {
        val totalCost = data.sumOf { it.cost.toDouble() } // Convert Float to Double
        return if (data.isNotEmpty()) totalCost / data.size else 0.0
    }

    private fun averageFloors(data: List<Plantation>): Double {
        val totalFloors = data.sumOf { it.floors.toDouble() } // Convert Int to Double
        return if (data.isNotEmpty()) totalFloors else 0.0
    }

    private fun addTableRow(tableLayout: TableLayout, cell1Text: String, cell2Text: String, isHeader: Boolean = false) {
        val row = TableRow(context)
        val cell1 = TextView(context).apply {
            text = cell1Text
            setPadding(10, 10, 10, 10)
            setBackgroundResource(R.color.white)
            if (isHeader) {
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
        }

        val cell2 = TextView(context).apply {
            text = cell2Text
            setPadding(10, 10, 10, 10)
            setBackgroundResource(R.color.white)
            if (isHeader) {
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
        }

        row.addView(cell1)
        row.addView(cell2)
        tableLayout.addView(row)
    }




}