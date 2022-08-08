package com.arlequins.zoco.ui.allproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arlequins.zoco.databinding.FragmentAllProductsBinding


class AllProductsFragment : Fragment() {

    private var _binding: FragmentAllProductsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val allProductsViewModel =
            ViewModelProvider(this)[AllProductsViewModel::class.java]

        _binding = FragmentAllProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAllProducts
        allProductsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


}