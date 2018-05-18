package ru.artempugachev.letsmvp.topmovies

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_top_movies.*
import ru.artempugachev.letsmvp.R
import ru.artempugachev.letsmvp.app.LetsMvpApp
import javax.inject.Inject

class TopMoviesActivity : AppCompatActivity(), TopMoviesMvpContract.View {


    private lateinit var adapter: MoviesAdapter

    @Inject
    lateinit var presenter: TopMoviesMvpContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movies)

        (application as LetsMvpApp).getTopMoviesComponent().inject(this)


        setUpViews()
    }


    private fun setUpViews() {
        adapter = MoviesAdapter()
        moviesRecycler.adapter = adapter
        moviesRecycler.itemAnimator = DefaultItemAnimator()
        moviesRecycler.setHasFixedSize(true)
        moviesRecycler.layoutManager = LinearLayoutManager(this)
    }


    override fun onResume() {
        super.onResume()
        presenter.bindView(this)
        presenter.loadData()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribeRx()
    }


    // view methods
    override fun updateData(viewModel: MovieViewModel) {
        adapter.addItem(viewModel)
    }


    override fun showSnackbar(message: String) {
        Snackbar.make(topMoviesRootLayout, message, Snackbar.LENGTH_SHORT).show()
    }
}
