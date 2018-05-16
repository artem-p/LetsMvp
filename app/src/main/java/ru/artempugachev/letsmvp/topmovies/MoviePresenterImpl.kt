package ru.artempugachev.letsmvp.topmovies

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MoviePresenterImpl(private val model: TopMoviesMvpContract.Model) : TopMoviesMvpContract.Presenter {
    private var subscription: Disposable? = null
    private var view: TopMoviesMvpContract.View? = null

    override fun loadData() {
        subscription = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<MovieViewModel>(){
                    override fun onNext(viewModel: MovieViewModel) {
                        view?.updateData(viewModel)
                    }


                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        view?.showSnackbar("Error while getting movies")
                    }


                    override fun onComplete() {

                    }
                })
    }


    override fun unsubscribeRx() {
        if (subscription?.isDisposed == false) {
            subscription?.dispose()
        }
    }


    override fun bindView(view: TopMoviesMvpContract.View) {
        this.view = view
    }
}