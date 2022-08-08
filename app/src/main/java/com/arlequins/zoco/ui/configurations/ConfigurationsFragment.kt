package com.arlequins.zoco.ui.configurations

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arlequins.zoco.R

class ConfigurationsFragment : Fragment() {

    companion object {
        fun newInstance() = ConfigurationsFragment()
    }

    private lateinit var viewModel: ConfigurationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_configurations, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfigurationsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}