package com.example.airbnb.common

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val notificationId = 101

fun showNotification(context: Context , builder : NotificationCompat.Builder) {
    createNotificationChannel(context)
    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, builder.build())
    }
}
private fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "any Name"
        val descriptionText = "any description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}