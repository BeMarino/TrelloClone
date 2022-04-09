package com.benny.trelloclone.firebase

import android.util.Log
import com.benny.trelloclone.activities.SignInActivity
import com.benny.trelloclone.activities.SignUpActivity
import com.benny.trelloclone.models.User
import com.benny.trelloclone.utils.Constants
import com.google.firebase.FirebaseApiNotAvailableException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions


class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS).document(getCurrentUserId()).set(
            userInfo,
            SetOptions.merge()
        ).addOnSuccessListener {
            activity.userRegisteredSuccess()
        }.addOnFailureListener { e ->
            Log.e(activity.javaClass.simpleName, "error dring user registration")
        }
    }

    fun getCurrentUserId(): String {
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun signInUser(activity: SignInActivity) {
        mFireStore.collection(Constants.USERS).document(getCurrentUserId()).get()
            .addOnSuccessListener { document ->
                val loggedUser = document.toObject(User::class.java)
                if(loggedUser!=null)
                    activity.signInSuccess(loggedUser)
            }.addOnFailureListener { e ->
            Log.e("SignInUser ", "error during user login")
        }
    }
}