package ru.oktemsec.kiparo_clean_code0722.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import ru.oktemsec.kiparo_clean_code0722.data.repository.UserRepositoryImpl
import ru.oktemsec.kiparo_clean_code0722.data.storage.sharedprefs.SharedPrefUserStorage
import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.GetUserNameUseCase
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    init {
        Log.e("AAA", "ViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "ViewModel cleared")
    }

    fun save(text:String):String {
        val params = SaveUserNameParam(name = text)
        val result:Boolean = saveUserNameUseCase.execute(params)
        return "Save result = $result"
    }

    fun load(): String {
        val userName: UserName = getUserNameUseCase.execute()
        return "${userName.firstName} ${userName.lastName}"
    }
}