package ru.artempugachev.letsmvp.topmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.top_movies_list_item.view.*
import ru.artempugachev.letsmvp.R

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var movies: MutableList<MovieViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val context = parent.context
        val categoryItemLayoutId = R.layout.top_movies_list_item
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(categoryItemLayoutId, parent, shouldAttachToParentImmediately)

        return MoviesViewHolder(view)
    }


    override fun getItemCount(): Int {
        return movies.size
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        if (!movies.isEmpty()) {
            val movie = movies[position]
            holder.movieName.text = movie.name
            holder.countryName.text = movie.country
        }
    }

    /**
     * Add single item to the list
     * */
    fun addItem(viewModel: MovieViewModel) {
        movies.add(viewModel)
        notifyItemInserted(movies.size - 1)
    }


    inner class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val movieName: TextView = itemView.movieName
        val countryName: TextView = itemView.countryName
    }
}
