package com.example.airbnb

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


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
        //인증서 혹은 외부 파일을 다운 받는 것으로 수정 필요
        Thread.sleep(5000)
    }


}
