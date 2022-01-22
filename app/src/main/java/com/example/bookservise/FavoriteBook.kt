package com.example.bookservise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FavoriteBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_book)
        initListeners()
    }

    private fun initListeners() {
        val changeBookBtn = findViewById<Button>(R.id.change)
        changeBookBtn.setOnClickListener(changeBookBtnListener)
    }

    private val changeBookBtnListener: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.change -> {
                val i = Intent(this, ChangeFavBook::class.java);
                startActivityForResult(i, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        var title = ""
        var author = ""
        var year = ""

        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                title = if (data!!.getStringExtra("title")!!.isNotEmpty()) {
                    data.getStringExtra("title")!!;
                } else {
                    getString(R.string.title_unknown)
                }
                author = if (data!!.getStringExtra("author")!!.isNotEmpty()) {
                    data.getStringExtra("author")!!;
                } else {
                    getString(R.string.author_unknown)
                }
                year = if (data!!.getStringExtra("year")!!.isNotEmpty()) {
                    data.getStringExtra("year")!!;
                } else {
                    getString(R.string.date_unknown)
                }
            }

            val titleBook = findViewById<TextView>(R.id.title)
            val authorBook = findViewById<TextView>(R.id.author)
            val yearBook = findViewById<TextView>(R.id.year)
            titleBook.text = title
            authorBook.text = author
            yearBook.text = year
        }
    }
}