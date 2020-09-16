package com.example.recyclerviewmvvm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

object Coroutines {
    fun<T: Any> ioThenMain(work: suspend(() -> T), callback: ((T?)->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope((Dispatchers.IO)).async rt@{
                return@rt work()
            }.await()
            callback(data)
    }
}