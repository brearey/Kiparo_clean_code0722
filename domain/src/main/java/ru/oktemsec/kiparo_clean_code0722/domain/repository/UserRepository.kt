package ru.oktemsec.kiparo_clean_code0722.domain.repository

import ru.oktemsec.kiparo_clean_code0722.domain.models.SaveUserNameParam
import ru.oktemsec.kiparo_clean_code0722.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}