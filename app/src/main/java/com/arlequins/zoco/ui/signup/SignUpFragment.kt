package com.arlequins.zoco.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arlequins.zoco.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        signUpViewModel.errorMsg.observe(viewLifecycleOwner){ msg ->
            showErrorMessage(msg)

        }

        with(signUpBinding){
            signUpButton.setOnClickListener{
                signUpViewModel.validateFields(
                    signUpNameEditText.text.toString(),
                    signUpEmailEditText.text.toString(),
                    signUpNumCelEditText.text.toString(),
                    signUpPasswordEditText.text.toString(),
                    signUpRePasswordEditText.text.toString()
                )
            }
        }

        return signUpBinding.root
    }

    private fun showErrorMessage(msg: String?) {
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_LONG).show()

    }

    fun goToLogin(){
        findNavController().navigate(SignUpFragmentDirections.actionNavSignUpToNavLogIn())
    }


}