package com.example.airbnb

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Environment
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.StringBuilder
import java.net.URL
import java.util.*
import kotlin.math.absoluteValue


class CertificationWorker(private val appContext: Context, workerParameters: WorkerParameters) :
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        Log.d("myReceiver", "start")
        downloadCertification()
        Log.d("myReceiver", "wake")

        // 리시버 등록
        val receiver = DownloadBroadcastReceiver()
        val filter = IntentFilter("MyAction")
        appContext.registerReceiver(receiver, filter)
        Log.d("myReceiver", "register")

        // 브로드케스트 발송
        Intent().also {
            Log.d("myReceiver", "send")
            it.setAction("MyAction")
                .setPackage("com.example.airbnb")
            appContext.sendBroadcast(it)
        }
        return Result.success()
    }

    private fun downloadCertification() {
        //인증서(zip 파일) 다운 로드 로직

        val dwLink = DOWN_LOAD_URL

        try {
            // 파일 경로 및 이름 제작
            val folderDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            Log.d("_directory", "folder: $folderDir")
            val fileName = StringBuilder("${folderDir}/${FILE_NAME}${UUID.randomUUID()}")
            fileName.append(
                // 추후 pdf, jpg 등등 필요하다면 추가
                if (dwLink.contains(".zip")) {
                    ".zip"
                } else {
                    ""
                }
            )

            // 디렉토리 생성
            val fileIcon = File(fileName.toString())
            if (!fileIcon.exists()) {
                fileIcon.parentFile.mkdirs()
            }

            // 통신연결
            val url = URL(dwLink)
            val connection = url.openConnection()
            connection.connect()
            val fileLength = connection.contentLength

            // 데이터 읽어오기 + 데이터 쓰기
            val input = BufferedInputStream(url.openStream())
            val output = FileOutputStream(fileName.toString())
            val data = ByteArray(1024)
            Log.d("_progress_value", "size: $fileLength")

            var count = 0
            while (input.read(data).also { count = it } != -1) {
                Log.d(
                    "_count_progress",
                    "$count $fileLength ${((count.toDouble() / fileLength) * 100).absoluteValue}"
                )
                output.write(data, 0, count)
            }

            Log.d("_directory", "completed")
            output.flush()
            output.close()
            input.close()
        } catch (ex: Exception) {
            Log.d("_directory", ex.toString())
            ex.printStackTrace()
        }
        Result.success()
    }

    companion object {
        const val DOWN_LOAD_URL = "https://sidedish-06.s3.ap-northeast-2.amazonaws.com/dummy.zip"
        const val FILE_NAME = "airbnb Certification"
    }
}
