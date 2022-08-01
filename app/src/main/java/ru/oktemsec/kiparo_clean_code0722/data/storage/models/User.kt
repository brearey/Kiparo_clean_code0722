package ru.oktemsec.kiparo_clean_code0722.data.storage.models

private const val DEFAULT_LAST_NAME = "Default_last_name"
class User(val firstName: String, val lastName: String = DEFAULT_LAST_NAME)