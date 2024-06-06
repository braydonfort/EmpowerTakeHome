package com.example.data.utils

import android.content.Context
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    return try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        ""
    }
}