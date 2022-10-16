package com.roady.roadyapi.account.domain

class WrongPasswordException(override val message: String) : RuntimeException(message)