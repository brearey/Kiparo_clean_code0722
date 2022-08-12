package ru.oktemsec.kiparo_clean_code0722.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.oktemsec.kiparo_clean_code0722.data.repository.UserRepositoryImpl
import ru.oktemsec.kiparo_clean_code0722.data.storage.sharedprefs.SharedPrefUserStorage
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.GetUserNameUseCase
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    // user repo
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefUserStorage(context = context)
        )
    }

    //Init use cases
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}