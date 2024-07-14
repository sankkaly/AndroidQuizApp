package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.ui.QuestionsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputText: EditText = findViewById(R.id.edit_Text)
        val button: Button = findViewById(R.id.button_start)

        button.setOnClickListener {
            if (inputText.text.isNotEmpty()){
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }else{
                Toast.makeText(this@MainActivity, "Please enter your name",Toast.LENGTH_SHORT).show()
            }

        }
    }
}