package com.arlequins.zoco.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arlequins.zoco.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private var userRepository = UserRepository()
    private var _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    fun validateFields(
        name: String,
        email: String,
        numCel: String,
        passwd: String,
        repasswd: String
    ) {
        if(name.isEmpty() ||
            email.isEmpty() ||
            numCel.isEmpty() ||
            passwd.isEmpty() ||
            repasswd.isEmpty()){
            _errorMsg.value = "Debe digitar todolos acampos"
        }
        else{
            if(passwd != repasswd || passwd.length < 6){
                _errorMsg.value = "Las contraseñas deben de ser iguales y mayores a 6 carácteres"
            }
            else{
                GlobalScope.launch(Dispatchers.IO) {
                    userRepository.registerUser(name, email, numCel, passwd)
                }

            }
        }
    }


}