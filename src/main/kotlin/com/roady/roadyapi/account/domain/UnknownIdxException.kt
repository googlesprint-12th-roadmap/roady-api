package com.roady.roadyapi.account.domain

import java.lang.RuntimeException

class UnknownIdxException(message: String, idx: Long): RuntimeException("$message | account id: $idx")