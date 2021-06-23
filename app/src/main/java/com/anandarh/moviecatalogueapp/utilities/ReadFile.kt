package com.anandarh.moviecatalogueapp.utilities

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class ReadFile {
    fun getJsonFromAsset(context: Context, fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.defaultCharset())
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}