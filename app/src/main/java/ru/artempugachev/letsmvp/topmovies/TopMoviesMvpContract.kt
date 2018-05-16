package ru.artempugachev.letsmvp.topmovies

import io.reactivex.Observable

interface TopMoviesMvpContract {
    interface View {
        fun updateData(model: MovieViewModel)
        fun showSnackbar(message: String)
    }


    interface Presenter {
        fun loadData()
        fun unsubscribeRx()
        fun bindView(view: View)
    }


    interface Model {
        fun result(): Observable<MovieViewModel>
    }
}