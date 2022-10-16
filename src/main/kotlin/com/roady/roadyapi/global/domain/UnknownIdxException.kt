package com.roady.roadyapi.global.domain

import java.lang.RuntimeException

class UnknownIdxException(message: String, idx: Long): RuntimeException("$message | account id: $idx")