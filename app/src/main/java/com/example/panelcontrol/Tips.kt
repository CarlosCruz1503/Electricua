package com.example.panelcontrol



import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.panelcontrol.ui.dashboard.DashboardFragment


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [Tips.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tips : Fragment() {

    private var month: String? = null
    private var zone: String? = null
    private var floors: String? = null
    private var cost: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cost = it.getString(COST_BUNDLE)
            month = it.getString(MONTH_BUNDLE)
            zone = it.getString(ZONE_BUNDLE)
            floors = it.getString(FLOORS_BUNDLE)

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root =inflater.inflate(R.layout.fragment_tips, container, false)
        val zoneE = root.findViewById<TextView>(R.id.zoneT)
        val monthE = root.findViewById<TextView>(R.id.monthT)
        val costE = root.findViewById<TextView>(R.id.costT)
        val floorsE = root.findViewById<TextView>(R.id.floorsT)
//        val packageName = this.packageName
        // Asignar el valor del prompt al TextView

//        val textView = root.findViewById<TextView>(R.id.textView10)
//        val imageView = root.findViewById<ImageView>(R.id.imageView8)
        zoneE.text = "Zona: $zone"
        monthE.text = "Mes: $month"
        costE.text = "Costo: $cost"
        floorsE.text = "C. Plantas: $floors"
//        textView.text = descripcion
//        val tableRow: TableRow = root.findViewById(R.id.tableRow)
//
//        tableRow.isClickable = true;
//        tableRow.setOnClickListener {
//            val intent = Intent(requireActivity(), MainActivity2::class.java)
//            intent.putExtra("title", text)
//            intent.putExtra("description", descripcion)
//            startActivity(intent)
//        }

        return root
    }

//    fun onClickRow(view: View?) {
//        print("hola")
//    }

    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Tips.
//         */
//
        const val MONTH_BUNDLE = "FOTO"
        const val ZONE_BUNDLE = "TEXT"
        const val FLOORS_BUNDLE = "DESC"
        const val COST_BUNDLE = "DESC"
        @JvmStatic
        fun newInstance(cost: String, month: String, zone:String, floors:String) =
            Tips().apply {
                arguments = Bundle().apply {
                    putString(MONTH_BUNDLE, month)
                    putString(ZONE_BUNDLE, zone)
                    putString(FLOORS_BUNDLE, floors)
                    putString(COST_BUNDLE, cost)
                }
            }
    }

    fun onClickRow(view: View) {
        print("hola")
    }
}