package com.arlequins.zoco.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arlequins.zoco.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private lateinit var logInBinding: FragmentLogInBinding
    private lateinit var logInViewModel: LogInViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        logInViewModel = ViewModelProvider(this)[LogInViewModel::class.java]


        logInBinding.logInButton.setOnClickListener {
            findNavController().navigate(LogInFragmentDirections.actionNavLogInToNavAllProducts())
        }

        logInBinding.logInToSignUpTextView.setOnClickListener{
            findNavController().navigate(LogInFragmentDirections.actionNavLogInToNavSignUp())
        }
        return logInBinding.root
    }

}