package com.theapache64.removebg.utils

import okhttp3.MediaType
import okio.Okio
import okio.BufferedSink
import okhttp3.RequestBody
import okhttp3.internal.Util
import okio.Source
import java.io.File
import java.io.IOException


class CountingFileRequestBody(
    private val file: File,
    private val contentType: String,
    private val listener: ProgressListener
) : RequestBody() {

    override fun contentLength(): Long {
        return file.length()
    }

    override fun contentType(): MediaType? {
        return MediaType.parse(contentType)
    }

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        var source: Source? = null
        try {
            source = Okio.source(file)
            var total: Long = 0
            var read: Long = -1
            while ({ read = source!!.read(sink.buffer(),
                    SEGMENT_SIZE
                ); read }() != -1L) {
                total += read
                sink.flush()
                val perc = (total * 100f) / contentLength()
                this.listener.transferred(perc)
            }

        } finally {
            Util.closeQuietly(source)
        }
    }

    interface ProgressListener {
        fun transferred(percentage: Float)
    }

    companion object {
        private const val SEGMENT_SIZE = 2048L // okio.Segment.SIZE
    }

}