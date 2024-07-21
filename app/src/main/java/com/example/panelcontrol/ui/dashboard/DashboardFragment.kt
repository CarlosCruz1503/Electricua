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
        tip1 = mutableMapOf("Title" to "Bombillas, mejor LED", "Text" to "Reemplaza tus bombillas halógenas por unas bombillas LED de bajo consumo.", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip2 = mutableMapOf("Title" to "Cuidado con que dejas prendido", "Text" to "Si tienes ventilador o aire acondicionado en tu colegio o en tu hogar apágalo cuando salgas.", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip3 = mutableMapOf("Title" to "Tu refri", "Text" to "Asegúrate que tu refrigerador tenga la etiqueta de eficiencia energética y sus empaques aíslen correctamente la temperatura.", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        tip4 = mutableMapOf("Title" to "No queremos fugas", "Text" to "Revisa que tu instalación eléctrica no tenga fugas: compruébalo apagando las luces y desconectando todos los aparatos, luego verifica que el medidor no gire.", "Image" to "https://www.google.com/url?sa=i&url=https%3A%2F%2Fas.com%2Fdiarioas%2F2021%2F11%2F07%2Factualidad%2F1636286127_006870.html&psig=AOvVaw37Lmd4UXyBmdAUunbNilU6&ust=1719864480259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLDKws2QhIcDFQAAAAAdAAAAABAD")
        arrayOfTips.add(tip1)
        arrayOfTips.add(tip2)
        arrayOfTips.add(tip3)
        arrayOfTips.add(tip4)
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