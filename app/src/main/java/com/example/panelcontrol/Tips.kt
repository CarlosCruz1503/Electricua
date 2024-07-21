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

    private var foto: String? = null
    private var text: String? = null
    private var descripcion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            foto = it.getString(FOTO_BUNDLE)
            text = it.getString(TEXT_BUNDLE)
            descripcion = it.getString(DESC_BUNDLE)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root =inflater.inflate(R.layout.fragment_tips, container, false)
        val titleView = root.findViewById<TextView>(R.id.textView9)
//        val packageName = this.packageName
        // Asignar el valor del prompt al TextView

//        val textView = root.findViewById<TextView>(R.id.textView10)
//        val imageView = root.findViewById<ImageView>(R.id.imageView8)
        titleView.text = text
//        textView.text = descripcion
        val tableRow: TableRow = root.findViewById(R.id.tableRow)

        tableRow.isClickable = true;
        tableRow.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity2::class.java)
            intent.putExtra("title", text)
            intent.putExtra("description", descripcion)
            startActivity(intent)
        }

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
        const val FOTO_BUNDLE = "FOTO"
        const val TEXT_BUNDLE = "TEXT"
        const val DESC_BUNDLE = "DESC"
        @JvmStatic
        fun newInstance(foto: String, text: String, descripcion:String) =
            Tips().apply {
                arguments = Bundle().apply {
                    putString(FOTO_BUNDLE, foto)
                    putString(TEXT_BUNDLE, text)
                    putString(DESC_BUNDLE, descripcion)
                }
            }
    }

    fun onClickRow(view: View) {
        print("hola")
    }
}