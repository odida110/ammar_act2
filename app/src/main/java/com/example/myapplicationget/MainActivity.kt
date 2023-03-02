package com.example.myapplicationget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //savetoosama
        save.setOnClickListener {
            var name =name.text.toString()
            var id =id.text.toString()
            var age =age.text.toString()
            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )

            db.collection("person")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,"DocumentSnapshot added with ID: ${documentReference.id}",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this,"Error adding document",Toast.LENGTH_LONG).show()

                }
        }
    }
}


