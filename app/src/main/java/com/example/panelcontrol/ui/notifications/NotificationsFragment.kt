package com.example.panelcontrol.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.panelcontrol.R
import com.example.panelcontrol.databinding.FragmentNotificationsBinding
import kotlin.random.Random
data class ConsejoReforestacion(
    val titulo: String,
    val descripcion: String
)

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val titleNotification = root.findViewById<TextView>(R.id.textView3)
        val textNotification = root.findViewById<TextView>(R.id.textView4)
        val consejosReforestacion = arrayOf(
            ConsejoReforestacion(
                titulo = "Selecciona Especies Nativas",
                descripcion = "Planta árboles que sean nativos de la región para asegurar que prosperen en el clima y suelo local."
            ),
            ConsejoReforestacion(
                titulo = "Promueve la Biodiversidad",
                descripcion = "Planta una variedad de especies de árboles para crear un ecosistema diverso que apoye a la vida silvestre y sea resistente a enfermedades."
            ),
            ConsejoReforestacion(
                titulo = "Involucra a la Comunidad",
                descripcion = "Organiza eventos y actividades de plantación de árboles con la participación de la comunidad para fomentar un sentido de responsabilidad y compromiso."
            ),
            ConsejoReforestacion(
                titulo = "Cuida el Suelo",
                descripcion = "Asegúrate de preparar adecuadamente el suelo antes de plantar, y considera la implementación de técnicas de conservación del suelo para mantener su fertilidad."
            ),
            ConsejoReforestacion(
                titulo = "Monitorea y Mantén",
                descripcion = "Realiza seguimientos periódicos y ofrece cuidados continuos a los árboles plantados, como riego y control de plagas."
            )
        )
        val numeroAleatorio = Random.nextInt(consejosReforestacion.size)
        titleNotification.text = consejosReforestacion[numeroAleatorio].titulo
        textNotification.text = consejosReforestacion[numeroAleatorio].descripcion
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}