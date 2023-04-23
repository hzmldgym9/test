package com.zuoyebang.iot.pad.launcher.matrix

import android.content.Context
import com.tencent.matrix.plugin.DefaultPluginListener
import com.tencent.matrix.report.Issue
import com.tencent.matrix.util.MatrixLog

/**
 * @Author : Gym
 * @Date : 2023/3/28 11:29 AM
 * @Description :
 */
class MatrixPluginListener(context: Context) : DefaultPluginListener(context) {
    private val TAG = "MatrixPluginListener"

    override fun onReportIssue(issue: Issue?) {
        super.onReportIssue(issue)
    }
}