package com.roady.roadyapi.account.domain

class UnknownIdException(message: String, id: String) : RuntimeException("$message | account id: $id")