package com.arlequins.zoco.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserRepository {

    private var auth: FirebaseAuth = Firebase.auth
    suspend fun registerUser(name: String, email: String, faculty: String, passwd: String) {
        auth.createUserWithEmailAndPassword(email, passwd)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Register", "createUserWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Register", "createUserWithEmail:failure", task.exception)
                }
            }
    }
}