package com.zuoyebang.iot.pad.launcher.matrix

import android.content.Context
import com.example.mytest.MyApplication
import com.tencent.matrix.Matrix
import com.tencent.matrix.iocanary.IOCanaryPlugin
import com.tencent.matrix.iocanary.config.IOConfig
import com.tencent.matrix.lifecycle.LifecycleThreadConfig
import com.tencent.matrix.lifecycle.MatrixLifecycleConfig
import com.tencent.matrix.lifecycle.MatrixLifecycleLogger
import com.tencent.matrix.lifecycle.supervisor.SupervisorConfig
import com.tencent.matrix.trace.TracePlugin
import com.tencent.matrix.trace.config.TraceConfig
import com.tencent.matrix.util.MatrixLog
import java.io.File

/**
 * @Author : Gym
 * @Date : 2023/3/29 10:39 AM
 * @Description :
 */

fun Context.initMatrix() {
    val builder: Matrix.Builder = Matrix.Builder(MyApplication.instance) // build matrix
    builder.pluginListener(MatrixPluginListener(this)) // add general pluginListener
    val dynamicConfig = DynamicConfigImpl() // dynamic config

    // init plugin and add to matrix
    // Configure trace canary.
    val tracePlugin = configureTracePlugin(dynamicConfig)
    builder.plugin(tracePlugin)

    // Configure io canary.
    val ioCanaryPlugin = configureIOCanaryPlugin(dynamicConfig)
    builder.plugin(ioCanaryPlugin)

    builder.matrixLifecycleConfig(configureMatrixLifecycle())
    //init matrix
    Matrix.init(builder.build())
    // start plugin
//    tracePlugin?.start()
    Matrix.with().startAllPlugins()
    MatrixLifecycleLogger.init(MyApplication.instance,true)
    MatrixLog.i("matrix", "Matrix configurations done.")
}

private fun Context.configureTracePlugin(dynamicConfig: DynamicConfigImpl): TracePlugin? {
    val fpsEnable: Boolean = dynamicConfig.isFPSEnable()
    val traceEnable: Boolean = dynamicConfig.isTraceEnable()
    val signalAnrTraceEnable: Boolean = dynamicConfig.isSignalAnrTraceEnable()
    val traceFileDir = File(applicationContext.filesDir, "matrix_trace")
    if (!traceFileDir.exists()) {
        if (traceFileDir.mkdirs()) {
            MatrixLog.d(
                "Matrix",
                "failed to create traceFileDir"
            )
        }
    }
    val anrTraceFile = File(
        traceFileDir,
        "anr_trace"
    ) // path : /data/user/0/sample.tencent.matrix/files/matrix_trace/anr_trace
    val printTraceFile = File(
        traceFileDir,
        "print_trace"
    ) // path : /data/user/0/sample.tencent.matrix/files/matrix_trace/print_trace
    val traceConfig = TraceConfig.Builder()
        .dynamicConfig(dynamicConfig)
        .enableFPS(fpsEnable)
        .enableEvilMethodTrace(traceEnable)
        .enableAnrTrace(traceEnable)
        .enableStartup(traceEnable)
        .enableIdleHandlerTrace(traceEnable) // Introduced in Matrix 2.0
        .enableSignalAnrTrace(signalAnrTraceEnable) // Introduced in Matrix 2.0
        .anrTracePath(anrTraceFile.absolutePath)
        .printTracePath(printTraceFile.absolutePath)
        .splashActivities("com.example.mytest.MainActivity;")
        .isDebug(true)
        .isDevEnv(false)
        .build()

    //Another way to use SignalAnrTracer separately
    //useSignalAnrTraceAlone(anrTraceFile.getAbsolutePath(), printTraceFile.getAbsolutePath());
    return TracePlugin(traceConfig)
}

private fun configureIOCanaryPlugin(dynamicConfig: DynamicConfigImpl): IOCanaryPlugin? {
    return IOCanaryPlugin(
        IOConfig.Builder()
            .dynamicConfig(dynamicConfig)
            .build()
    )
}

private fun configureMatrixLifecycle(): MatrixLifecycleConfig? {
    return MatrixLifecycleConfig(
        SupervisorConfig(true, true, ArrayList()),
        true,
        true,
        LifecycleThreadConfig(),
        true
    )
}