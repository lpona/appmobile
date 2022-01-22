package com.example.bookservise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Book : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val bookTextView = findViewById<TextView>(R.id.book)
        val arguments = intent.extras

        if(arguments!=null) {
            val book = arguments.getString("book")
            bookTextView.text = "$book"
        }
    }
}