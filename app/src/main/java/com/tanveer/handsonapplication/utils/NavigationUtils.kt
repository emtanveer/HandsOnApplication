package com.tanveer.handsonapplication.utils

import android.content.Context
import android.content.Intent
import android.util.Log

object NavigationUtils {
    private const val TAG = "NavigationUtils.class"

    fun simpleNavigateTo(context: Context?, destination: Class<Any>) {
        val intent = Intent(context, destination)
        context?.let {
            context.startActivity(intent);
        } ?: run { Log.e(TAG, "Something wrong with the context for navigation action"); }
    }
}