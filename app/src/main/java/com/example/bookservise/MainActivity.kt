package com.example.bookservise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        val addBtn = findViewById<Button>(R.id.addBookButton)
        val favBtn = findViewById<Button>(R.id.favoriteBookButton)
        val authorBtn = findViewById<Button>(R.id.authorButton)

        addBtn.setOnClickListener(addBtnListener)
        favBtn.setOnClickListener(favBtnListener)
        authorBtn.setOnClickListener(authorBtnListener)
    }

    private val addBtnListener = View.OnClickListener { callPillAddActivity() }
    private val favBtnListener = View.OnClickListener { callAboutAppActivity() }
    private val authorBtnListener = View.OnClickListener { callAboutAuthorActivity() }

    private fun callPillAddActivity() {
        val runAuthorIntent = Intent(this, AddBook::class.java)
        startActivity(runAuthorIntent)
    }
    private fun callAboutAppActivity() {
        val runAuthorIntent = Intent(this, FavoriteBook::class.java)
        startActivity(runAuthorIntent)
    }
    private fun callAboutAuthorActivity() {
        val runAuthorIntent = Intent(this, Author::class.java)
        startActivity(runAuthorIntent)
    }
}