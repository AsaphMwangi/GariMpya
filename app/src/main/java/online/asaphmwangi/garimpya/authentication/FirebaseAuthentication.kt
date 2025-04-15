package online.asaphmwangi.garimpya.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GetTokenResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class FirebaseAuthentication {
    private val auth: FirebaseAuth = Firebase.auth

    //Login using email and password

    fun login(email: String, password: String, onResult: (Boolean, FirebaseUser?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("Auth", "Login successful: ${user?.email}")
                    onResult(true, user)
                } else {
                    Log.w("Auth", "Login failed", task.exception)
                    onResult(false, null)
                }
            }
    }
    fun signUp(email: String, password: String, onResult: (Boolean, FirebaseUser?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("Auth", "Sign-up successful: ${user?.email}")
                    onResult(true, user)
                } else {
                    Log.w("Auth", "Sign-up failed", task.exception)
                    onResult(false, null)
                }
            }
    }
    fun signOut() {
        auth.signOut()
    }

    fun isLoggedIn(): Boolean {
        return auth.currentUser != null
    }
    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }
}