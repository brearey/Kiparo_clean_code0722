package ru.oktemsec.kiparo_clean_code0722.domain.usecase

import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam):Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        val result:Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}