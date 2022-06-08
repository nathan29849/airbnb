package com.example.airbnb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.airbnb.common.CHANNEL_ID
import com.example.airbnb.common.isAppInForegrounded
import com.example.airbnb.common.showNotification

class DownloadBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (isAppInForegrounded()) {
            Toast.makeText(
                context,
                context.getString(R.string.notification_download_completed),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_hotel_24)
                .setContentTitle(context.getString(R.string.notification_down_completed_title))
                .setContentText(context.getString(R.string.notification_download_completed))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            showNotification(context, builder)
        }
    }
}
