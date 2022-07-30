package ru.oktemsec.kiparo_clean_code0722.domain.usecase

import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName
import ru.oktemsec.kiparo_clean_code0722.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}