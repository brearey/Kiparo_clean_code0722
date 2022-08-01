package ru.oktemsec.kiparo_clean_code0722.data.repository

import ru.oktemsec.kiparo_clean_code0722.data.storage.UserStorage
import ru.oktemsec.kiparo_clean_code0722.data.storage.models.User
import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName
import ru.oktemsec.kiparo_clean_code0722.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.save(mapToStorage(saveParam))
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}