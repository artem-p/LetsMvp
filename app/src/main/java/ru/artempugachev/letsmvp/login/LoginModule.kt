package ru.artempugachev.letsmvp.login

import dagger.Module
import dagger.Provides
import ru.artempugachev.letsmvp.login.repository.LoginMemoryRepositoryImpl
import ru.artempugachev.letsmvp.login.repository.LoginRepository

@Module
class LoginModule {
    @Provides
    fun provideLoginPresenter(model: LoginMvpContract.Model): LoginMvpContract.Presenter {
        return LoginPresenterImpl(model)
    }


    @Provides
    fun provideLoginModel(repository: LoginRepository): LoginMvpContract.Model {
        return LoginModelImpl(repository)
    }


    @Provides
    fun provideLoginRepository(): LoginRepository {
        return LoginMemoryRepositoryImpl()
    }
}