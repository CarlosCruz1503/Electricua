package com.example.panelcontrol.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.panelcontrol.R
import com.example.panelcontrol.databinding.FragmentHomeBinding
import android.widget.Button
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
        val editTextInput = root.findViewById<TextView>(R.id.editTextText)
        val textLog = root.findViewById<TextView>(R.id.textView4)
        buttonControl.setOnClickListener {
            val textTemp = '.'
            var textoCapturado = editTextInput.text.toString()
            val textoCapturadoTemp = textoCapturado.toInt()
            when {
                textoCapturadoTemp >= 289 ->   textLog.text = "Estas gastando demasiada energía ve a dashboard y ve algunos tips que pueden servirte"
                textoCapturadoTemp > 249 && textoCapturadoTemp < 289 -> textLog.text = "Estas gastando energía de forma normal, puedes mejorar y cuidar al planeta ve a dashboard a ver tips"
                textoCapturadoTemp <= 249  -> textLog.text = "Cuidas muy bien la energía que gastas, pero aún se puede mejorar más, ve a dashboard a ver algunos tips"
            }

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}