package com.example.bookservise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ChangeFavBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_fav_book)
        initListeners()
    }

    private fun initListeners() {
        val changeBookBtn = findViewById<Button>(R.id.changeBookButton)
        changeBookBtn.setOnClickListener(changeBookBtnListener)
    }

    private val changeBookBtnListener: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.changeBookButton -> {
                returnBook()
            }
        }
    }

    private fun returnBook() {
        val intent = Intent()
        val editTitle = findViewById<EditText>(R.id.titleSet)
        val editAuthor = findViewById<EditText>(R.id.authorSet)
        val editYear =  findViewById<EditText>(R.id.yearSet)

        if(editTitle.text.toString() == "" || editAuthor.toString() == "" || editYear.toString() == "" ) {
            setResult(RESULT_CANCELED, intent)
        } else {
            intent.putExtra("title", editTitle.text.toString())
            intent.putExtra("author", editAuthor.text.toString())
            intent.putExtra("year", editYear.text.toString())
            setResult(RESULT_OK, intent)
        }
        Toast.makeText(applicationContext, getString(R.string.changes_saved), Toast.LENGTH_LONG).show()
        finish()
    }
}