package ru.oktemsec.kiparo_clean_code0722.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import ru.oktemsec.kiparo_clean_code0722.R
import ru.oktemsec.kiparo_clean_code0722.data.repository.UserRepositoryImpl
import ru.oktemsec.kiparo_clean_code0722.data.storage.sharedprefs.SharedPrefUserStorage
import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.GetUserNameUseCase
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.SaveUserNameUseCase

class MainActivity : Activity() {

    // user repo
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(SharedPrefUserStorage(context = applicationContext)) }

    //Init use cases
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView:TextView = findViewById(R.id.dataTextView)
        val dataEditView:EditText = findViewById(R.id.dataEditText)
        val sendButton: Button = findViewById(R.id.sendButton)
        val receiveButton: Button = findViewById(R.id.receiveButton)

        sendButton.setOnClickListener {
            // Клик по кнопке Save data
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result:Boolean = saveUserNameUseCase.execute(params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            // Клик по кнопке Get data
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}