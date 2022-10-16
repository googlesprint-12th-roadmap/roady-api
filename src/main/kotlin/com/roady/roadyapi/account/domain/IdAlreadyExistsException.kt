package com.roady.roadyapi.account.domain

class IdAlreadyExistsException(message: String, val id: String) : RuntimeException("$message | account id: $id")