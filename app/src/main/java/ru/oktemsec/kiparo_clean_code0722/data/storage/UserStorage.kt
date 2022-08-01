package ru.oktemsec.kiparo_clean_code0722.data.storage

import ru.oktemsec.kiparo_clean_code0722.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}