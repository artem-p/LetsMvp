package ru.artempugachev.letsmvp.github

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.artempugachev.letsmvp.R
import ru.artempugachev.letsmvp.app.LetsMvpApp
import ru.artempugachev.letsmvp.github.api.GithubInterface
import ru.artempugachev.letsmvp.github.api.UserResponse
import javax.inject.Inject

class GithubUsersActivity : AppCompatActivity() {
    @Inject
    lateinit var githubInterface: GithubInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_users)

        (application as LetsMvpApp).getGithubComponent().inject(this)

        queryGithub()
    }

    /**
     * Make call to github api
     * */
    private fun queryGithub() {
        // without rx
        val call = githubInterface.getUsers(USER_PER_PAGE)

        call.enqueue(object : Callback<List<UserResponse>>{
            override fun onResponse(call: Call<List<UserResponse>>, response: Response<List<UserResponse>>) {
                val users = response.body()

                users?.let {
                    for (user in it) {
                        System.out.println(user.login)
                    }
                }
            }


            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        })

        // with rx
        val usersObservable = githubInterface.getUsersObservable(USER_PER_PAGE)

        val usersLoginObservable = usersObservable.flatMap{userResponse -> Observable.fromIterable(userResponse)}

        usersLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({userResponse -> System.out.println("With Rx: ${userResponse.login}")})
    }
}

const val USER_PER_PAGE = 100
