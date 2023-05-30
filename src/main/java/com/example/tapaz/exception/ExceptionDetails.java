package com.example.tapaz.exception;

import java.time.LocalDateTime;

public record ExceptionDetails(
LocalDateTime timeStamp,
String message,
String details
) {
}
