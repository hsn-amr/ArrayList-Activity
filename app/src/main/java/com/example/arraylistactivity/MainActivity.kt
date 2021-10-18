package com.example.arraylistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)

        val etName = findViewById<EditText>(R.id.etName)
        val etIndex = findViewById<EditText>(R.id.etIndex)

        val add = findViewById<Button>(R.id.btnAdd)
        val find = findViewById<Button>(R.id.btnFind)

        val names = ArrayList<String>()

        add.setOnClickListener {
            if(etName.text.isNotEmpty()){
                names.add(etName.text.toString())
                etName.text.clear()
            }else{
                Toast.makeText(this, "Type Name", Toast.LENGTH_LONG).show()
            }
        }

        find.setOnClickListener {
            if(etIndex.text.isNotEmpty()){
                try {
                    tv.text = "${names[etIndex.text.toString().toInt()-1]}"
                }catch (e: Exception){
                    Toast.makeText(this, "this index out the range, try less than that", Toast.LENGTH_LONG).show()
                }
                etIndex.text.clear()
            }else{
                Toast.makeText(this, "Type Index", Toast.LENGTH_LONG).show()
            }
        }
    }
}