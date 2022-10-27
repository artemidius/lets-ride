package com.s808.common.result


/**
 * This class is a universal wrapper to be used mostly with coroutines.
 * It is the way to perform an operation which has a potential to throw an exception.
 * Using this class we handle an exception as a specific result of operation whith it's
 * own status and message.
 */
@Suppress("UNUSED_PARAMETER")
sealed class OperationResult<out T>() {
    class Success<out T>(val data: T): OperationResult<T>()
    class Loading<out T>(val data: T, message: String? = null): OperationResult<T>()
    class Error<out T>(val error: Throwable? = null, val message: String? = null): OperationResult<T>()
}