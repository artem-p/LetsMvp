package ru.artempugachev.letsmvp.topmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_top_movies.*
import ru.artempugachev.letsmvp.R

class TopMoviesActivity : AppCompatActivity() {
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movies)

        setUpViews()
    }


    private fun setUpViews() {
        adapter = MoviesAdapter()
        moviesRecycler.adapter = adapter
        moviesRecycler.itemAnimator = DefaultItemAnimator()
        moviesRecycler.setHasFixedSize(true)
        moviesRecycler.layoutManager = LinearLayoutManager(this)
    }
}
