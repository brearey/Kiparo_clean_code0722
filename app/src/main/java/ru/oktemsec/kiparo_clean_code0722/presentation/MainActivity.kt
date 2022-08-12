package ru.oktemsec.kiparo_clean_code0722.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.oktemsec.kiparo_clean_code0722.R
import ru.oktemsec.kiparo_clean_code0722.data.repository.UserRepositoryImpl
import ru.oktemsec.kiparo_clean_code0722.data.storage.sharedprefs.SharedPrefUserStorage
import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.GetUserNameUseCase
import ru.oktemsec.kiparo_clean_code0722.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewModel without activity-ktx
        val vm: MainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val dataTextView: TextView = findViewById(R.id.dataTextView)
        val dataEditView: EditText = findViewById(R.id.dataEditText)
        val sendButton: Button = findViewById(R.id.sendButton)
        val receiveButton: Button = findViewById(R.id.receiveButton)

        sendButton.setOnClickListener {
            // Клик по кнопке Save data
            dataTextView.text = vm.save(dataEditView.text.toString())
        }

        receiveButton.setOnClickListener {
            // Клик по кнопке Get data
            dataTextView.text = vm.load()
        }
    }
}