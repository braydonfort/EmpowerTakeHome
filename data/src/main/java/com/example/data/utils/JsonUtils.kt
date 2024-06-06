package com.example.data.utils

import android.content.Context
import java.io.IOException

/**
 * JsonUtils file
 * Kotlin file for functions to parsing json files
 */

/**
 * Function gets the json file from the assets folder and returns it as a string
 */
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