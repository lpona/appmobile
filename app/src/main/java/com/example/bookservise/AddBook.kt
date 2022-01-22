package com.example.bookservise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddBook : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        initListeners()
    }

    private fun initListeners() {
        val addBookBtn = findViewById<Button>(R.id.addBookButton)
        addBookBtn.setOnClickListener(addBookBtnListener)
    }

    private val addBookBtnListener = View.OnClickListener { book() }

    private fun book() {
        val setTitle = findViewById<EditText>(R.id.titleSet)
        val setAuthor = findViewById<EditText>(R.id.authorSet)
        val setYear = findViewById<EditText>(R.id.yearSet)

        val title = setTitle.text.toString()
        val author = setAuthor.text.toString()
        val year = setYear.text.toString()

        if (year.toInt() == 0) {
            Toast.makeText(applicationContext, getString(R.string.zero_year), Toast.LENGTH_SHORT).show()
        } else if (setTitle.length() == 0 || setAuthor.length() == 0) {
            Toast.makeText(applicationContext, getString(R.string.value_null), Toast.LENGTH_SHORT).show()
        } else {
            returnBook("$title , \n$author , \n$year .")
            finish()
        }
    }

    private fun returnBook(value: String?) {
        val runSecondIntent = Intent(this, Book::class.java)
        runSecondIntent.putExtra("book", value)
        startActivity(runSecondIntent)
    }
}