package com.example.panelcontrol.ui.dashboard



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableRow
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.panelcontrol.R
import com.example.panelcontrol.Tips
import com.example.panelcontrol.Tips.Companion.DESC_BUNDLE
import com.example.panelcontrol.Tips.Companion.FOTO_BUNDLE
import com.example.panelcontrol.Tips.Companion.TEXT_BUNDLE
import com.example.panelcontrol.databinding.FragmentDashboardBinding


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

        var arrayOfTips = ArrayList<Map<String, Any>>()
        var tip1 : Map<String, Any> = mapOf()
        var tip2 : Map<String, Any> = mapOf()
        var tip3 : Map<String, Any> = mapOf()
        var tip4 : Map<String, Any> = mapOf()
        var tip5 : Map<String, Any> = mapOf()
        var tip6 : Map<String, Any> = mapOf()
        tip1 = mutableMapOf("Title" to "Bombillas, mejor LED", "Text" to "Las bombillas led tienen una vida útil de entre 20.000 y 50.000 horas. Mientras que, las bombillas tradicionales unas 2.000 horas por lo que son cambiadas con menor frecuencia lo cual se traduce en ahorro económico y energético. No emiten rayos ultravioleta ni rayos infrarrojos, y apenas producen pérdida de calor. No contaminan pues no contienen mercurio ni tungsteno y además son reciclables.\n" +
                "\n" +
                "Esto representa otro aspecto a mediano plazo, ya que el mantenimiento de estas bombillas led es mínimo. Aunque es probable que el precio inicial del proyecto de iluminación sea más alto que en la iluminación tradicional, a largo plazo, el beneficio es inminente y para el medio ambiente lo es aún más. Existen infinidad de diseños de luces led, apliques de pared, focos led, lámparas de techo y demás aplicaciones led, para crear todo tipo de ambientes. Pueden aplicarse en la iluminación de cualquier espacio bien sea interior o exterior y además con los estilos de preferencia.\n" +
                "\n"
               , "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip2 = mutableMapOf("Title" to "Cuidado con que dejas prendido", "Text" to "Sitios web especializados en tecnología como CNET y TechRadar sugieren esta práctica como una forma efectiva de reducir el consumo de energía. Según sus análisis, desconectar la nevera durante períodos de ausencia prolongada puede disminuir significativamente el gasto energético.\n" +
                "\n" +
                "Un estudio reciente realizado por el Instituto de Investigación en Energía de la Universidad Nacional Autónoma de México respalda esta idea. Encontró que desconectar la nevera durante ocho horas al día, puede reducir el consumo de energía en un 20%. Esto se traduce en un ahorro notable en la factura eléctrica a lo largo del tiempo.\n" +
                "\n" +
                "Cómo afecta esta práctica a la conservación de los alimentos en el refrigerador\n" +
                "Contrariamente a lo que se podría pensar, los expertos aseguran que desconectar la nevera durante cortos períodos de tiempo no afecta significativamente la calidad ni la frescura de los alimentos almacenados.", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip3 = mutableMapOf("Title" to "Tu refri", "Text" to "Antes de comenzar a explicar el nuevo etiquetado energético europeo, es fundamental que comprendamos qué es y por qué es tan importante para nuestro hogar escoger los electrodomésticos, en este caso neveras, más eficientes. \n" +
                "\n" +
                "\n" +
                "Atendiendo a la información publicada por la Organización de Consumidores y Usuarios (OCU) sobre las nuevas etiquetas de eficiencia energética: desde marzo de 2021 entra en vigor una nueva calificación energética más simple para electrodomésticos como lavadoras, lavasecadoras, frigoríficos o todo tipo de pantallas. En 2022 se incorporaron a este nuevo etiquetado aires acondicionados y también las secadoras. \n" +
                "\n" +
                "\n" +
                "Las etiquetas energéticas son pegatinas o adhesivos que te indican la clasificación energética del electrodoméstico según una escala de consumo. Estas etiquetas aportan una información fundamental a los consumidores, ya que gracias a ellas podemos conocer cuáles son los modelos que menos energía consumen y por tanto, son más eficientes energéticamente. ", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip4 = mutableMapOf("Title" to "No queremos fugas", "Text" to "La electricidad es una parte esencial de nuestras vidas modernas. Sin embargo, el manejo de la electricidad requiere cuidado y precaución. Una fuga de energía eléctrica puede ser peligrosa, causar daños a los aparatos eléctricos o incluso provocar un incendio. Por lo tanto, es importante que todos aprendamos a identificar una fuga de energía eléctrica. \n" +
                "Uno de los signos más obvios de una fuga de energía eléctrica es un chispazo o arco eléctrico. Otros signos incluyen un sonido sibilante o zumbido, un calentamiento anormal de los enchufes o interruptores, o un fuerte olor a quemado. Si experimenta cualquiera de estos síntomas, desconecte inmediatamente los aparatos eléctricos de la toma de corriente y llame a un Electricista profesional para revisar los circuitos. ", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip5 = mutableMapOf("Title" to "Revisa las luces", "Text" to "En Brasil, quienes tienen un poco más de edad recuerdan la irónica pregunta que se ha convertido en un refrán en los hogares del país: \"¿Eres miembro de Light?\" Esta referencia a la compañía eléctrica se hacía a quienes olvidaban apagar las luces. Expresiones similares se repiten en toda América Latina.\n" +
                "\n" +
                "Esta sencilla frase contiene uno de los consejos de oro para ahorrar energía en casa: apagar las luces al salir de la habitación. ", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip6 = mutableMapOf("Title" to "Realizar duchas más rápidas ", "Text" to "Cuanto menos tiempo esté encendida una ducha eléctrica, menos energía consume. Para ahorrar energía, lo ideal son las duchas más rápidas y menos calientes. \n" +
                "\n" +
                "Otra posibilidad es instalar un sistema de calentamiento del agua mediante luz solar. Según el Atlas de la EPE, el uso de la energía solar en este aspecto, además de poder reducir el gasto total con energía, también ayuda a la reducción de las emisiones de gases de efecto invernadero por ser una fuente de energía limpia.  ", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        arrayOfTips.add(tip1)

        arrayOfTips.add(tip2)
        arrayOfTips.add(tip3)
        arrayOfTips.add(tip4)
        arrayOfTips.add(tip5)
//        arrayOfTips.add(tip6)
        val fragments = childFragmentManager.fragments
        if (fragments.isNotEmpty()) {
            val fragmentTransaction = childFragmentManager.beginTransaction()
            for (fragment in fragments) {
                fragmentTransaction.remove(fragment)
            }
            fragmentTransaction.commit()
        }
        val containerLayout: LinearLayout = root.findViewById(R.id.fragment_container)
        arrayOfTips.forEach { tip ->
            val title = tip["Title"] as String
            val text = tip["Text"] as String
            val image = tip["Image"] as String

            val fragment = Tips.newInstance(image, title, text )
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
}