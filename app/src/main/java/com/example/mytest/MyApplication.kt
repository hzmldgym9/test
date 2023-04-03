package com.example.mytest

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
//import com.tencent.matrix.Matrix
//import com.tencent.matrix.batterycanary.BatteryMonitorPlugin
//import com.tencent.matrix.hook.HookManager
//import com.tencent.matrix.hook.HookManager.HookFailedException
//import com.tencent.matrix.hook.pthread.PthreadHook
//import com.tencent.matrix.hook.pthread.PthreadHook.ThreadStackShrinkConfig
//import com.tencent.matrix.iocanary.IOCanaryPlugin
//import com.tencent.matrix.iocanary.config.IOConfig
//import com.tencent.matrix.lifecycle.LifecycleThreadConfig
//import com.tencent.matrix.lifecycle.MatrixLifecycleConfig
//import com.tencent.matrix.lifecycle.MatrixLifecycleLogger
//import com.tencent.matrix.lifecycle.supervisor.SupervisorConfig
//import com.tencent.matrix.resource.ResourcePlugin
//import com.tencent.matrix.trace.TracePlugin
//import com.tencent.matrix.trace.config.TraceConfig
//import com.tencent.matrix.trace.tracer.SignalAnrTracer
//import com.tencent.matrix.trace.tracer.SignalAnrTracer.SignalAnrDetectedListener
//import com.tencent.matrix.util.MatrixLog
//import com.tencent.sqlitelint.SQLiteLint
//import com.tencent.sqlitelint.SQLiteLintPlugin
//import com.tencent.sqlitelint.config.SQLiteLintConfig
import java.io.File

/**
 * @Author : Gym
 * @Date : 2023/3/29 6:30 PM
 * @Description :
 */
class MyApplication : Application() {
    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }

    fun is64BitRuntime(): Boolean {
        val currRuntimeABI = Build.CPU_ABI
        return ("arm64-v8a".equals(currRuntimeABI, ignoreCase = true)
                || "x86_64".equals(currRuntimeABI, ignoreCase = true)
                || "mips64".equals(currRuntimeABI, ignoreCase = true))
    }

    override fun onCreate() {
        super.onCreate()
//        initMatrix()

//        if (!is64BitRuntime()) {
//            try {
//                val config = ThreadStackShrinkConfig()
//                    .setEnabled(true)
//                    .addIgnoreCreatorSoPatterns(".*/app_tbs/.*")
//                    .addIgnoreCreatorSoPatterns(".*/libany\\.so$")
//                HookManager.INSTANCE.addHook(PthreadHook.INSTANCE.setThreadStackShrinkConfig(config))
//                    .commitHooks()
//            } catch (e: HookFailedException) {
//                e.printStackTrace()
//            }
//        }
//
//        try {
//            val services = packageManager.getPackageInfo(
//                packageName, PackageManager.GET_SERVICES
//            ).services
//            for (service in services) {
//                MatrixLog.d(
//                    "matrix",
//                    "name = %s, processName = %s",
//                    service.name,
//                    service.processName
//                )
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        }
//
//        // Switch.
//        val dynamicConfig = DynamicConfigImplDemo()
//        MatrixLog.i("matrix", "Start Matrix configurations.")
//
//        // Builder. Not necessary while some plugins can be configured separately.
//        val builder = Matrix.Builder(this)
//
//        // Reporter. Matrix will callback this listener when found issue then emitting it.
//        builder.pluginListener(TestPluginListener(this))
//
////        val memoryCanaryPlugin = MemoryCanaryPlugin(MemoryCanaryBoot.configure(this))
////        builder.plugin(memoryCanaryPlugin)
//
//        // Configure trace canary.
//        val tracePlugin = configureTracePlugin(dynamicConfig)
//        builder.plugin(tracePlugin)
//
//        // Configure resource canary.
////        val resourcePlugin: ResourcePlugin = configureResourcePlugin(dynamicConfig)
////        builder.plugin(resourcePlugin)
//
//        // Configure io canary.
//        val ioCanaryPlugin = configureIOCanaryPlugin(dynamicConfig)
//        builder.plugin(ioCanaryPlugin)
//
//        // Configure SQLite lint plugin.
//        val sqLiteLintPlugin = configureSQLiteLintPlugin()
//        builder.plugin(sqLiteLintPlugin)
//
//        // Configure battery canary.
////        val batteryMonitorPlugin: BatteryMonitorPlugin = configureBatteryCanary(this)
////        builder.plugin(batteryMonitorPlugin)
//
//        builder.matrixLifecycleConfig(configureMatrixLifecycle())
//        Matrix.init(builder.build())
//
//        // Trace Plugin need call start() at the beginning.
////        tracePlugin.start();
////        memoryCanaryPlugin.start();
//
//        // Trace Plugin need call start() at the beginning.
//        tracePlugin?.start();
////        memoryCanaryPlugin.start();
////        Matrix.with().startAllPlugins()
////        MatrixLifecycleLogger.init()
////        TrimMemoryNotifier.INSTANCE.addProcessBackgroundTrimCallback(object : TrimCallback() {
////            fun systemTrim(i: Int) {
////                MatrixLog.d("matrix", "systemTrim: ")
////            }
////
////            fun backgroundTrim() {
////                MatrixLog.d("matrix", "backgroundTrim: ")
////            }
////        })
//
//        MatrixLog.i("matrix", "Matrix configurations done.")
    }

//    private fun configureTracePlugin(dynamicConfig: DynamicConfigImplDemo): TracePlugin? {
//        val fpsEnable: Boolean = dynamicConfig.isFPSEnable()
//        val traceEnable: Boolean = dynamicConfig.isTraceEnable()
//        val signalAnrTraceEnable: Boolean = dynamicConfig.isSignalAnrTraceEnable()
//        val traceFileDir = File(applicationContext.filesDir, "matrix_trace")
//        if (!traceFileDir.exists()) {
//            if (traceFileDir.mkdirs()) {
//                MatrixLog.e(
//                    "matrix",
//                    "failed to create traceFileDir"
//                )
//            }
//        }
//        val anrTraceFile = File(
//            traceFileDir,
//            "anr_trace"
//        ) // path : /data/user/0/sample.tencent.matrix/files/matrix_trace/anr_trace
//        val printTraceFile = File(
//            traceFileDir,
//            "print_trace"
//        ) // path : /data/user/0/sample.tencent.matrix/files/matrix_trace/print_trace
//        val traceConfig = TraceConfig.Builder()
//            .dynamicConfig(dynamicConfig)
//            .enableFPS(fpsEnable)
//            .enableEvilMethodTrace(traceEnable)
//            .enableAnrTrace(traceEnable)
//            .enableStartup(traceEnable)
//            .enableIdleHandlerTrace(traceEnable) // Introduced in Matrix 2.0
//            .enableSignalAnrTrace(signalAnrTraceEnable) // Introduced in Matrix 2.0
//            .anrTracePath(anrTraceFile.absolutePath)
//            .printTracePath(printTraceFile.absolutePath)
//            .splashActivities("sample.tencent.matrix.SplashActivity;")
//            .isDebug(true)
//            .isDevEnv(false)
//            .build()
//
//        //Another way to use SignalAnrTracer separately
//        //useSignalAnrTraceAlone(anrTraceFile.getAbsolutePath(), printTraceFile.getAbsolutePath());
//        return TracePlugin(traceConfig)
//    }
//
//    private fun useSignalAnrTraceAlone(anrFilePath: String, printTraceFile: String) {
//        val signalAnrTracer = SignalAnrTracer(this, anrFilePath, printTraceFile)
//        signalAnrTracer.setSignalAnrDetectedListener(object : SignalAnrDetectedListener {
//            override fun onAnrDetected(
//                stackTrace: String,
//                mMessageString: String,
//                mMessageWhen: Long,
//                fromProcessErrorState: Boolean,
//                cgroup: String
//            ) {
//                // got an ANR
//            }
//
//            override fun onNativeBacktraceDetected(
//                backtrace: String,
//                mMessageString: String,
//                mMessageWhen: Long,
//                fromProcessErrorState: Boolean
//            ) {
//            }
//
//            override fun onDeadLockAnrDetected(
//                mainThreadStackTrace: String,
//                lockHeldThread1: String,
//                lockHeldThread2: String,
//                waitingList: Map.Entry<IntArray, Array<String>>
//            ) {
//            }
//
//            override fun onMainThreadStuckAtNativePollOnce(mainThreadStackTrace: String) {}
//        })
//        signalAnrTracer.onStartTrace()
//    }
//
////    private fun configureResourcePlugin(dynamicConfig: DynamicConfigImplDemo): ResourcePlugin? {
////        val intent = Intent()
////        val mode = DumpMode.MANUAL_DUMP
////        MatrixLog.i(sample.tencent.matrix.MatrixApplication.TAG, "Dump Activity Leak Mode=%s", mode)
////        intent.setClassName(this.packageName, "com.tencent.mm.ui.matrix.ManualDumpActivity")
////        val resourceConfig = ResourceConfig.Builder()
////            .dynamicConfig(dynamicConfig)
////            .setAutoDumpHprofMode(mode)
////            .setManualDumpTargetActivity(ManualDumpActivity::class.java.getName())
////            .setManufacture(Build.MANUFACTURER)
////            .build()
////        ResourcePlugin.activityLeakFixer(this)
////        return ResourcePlugin(resourceConfig)
////    }
//
//    private fun configureIOCanaryPlugin(dynamicConfig: DynamicConfigImplDemo): IOCanaryPlugin? {
//        return IOCanaryPlugin(
//            IOConfig.Builder()
//                .dynamicConfig(dynamicConfig)
//                .build()
//        )
//    }
//
//    private fun configureSQLiteLintPlugin(): SQLiteLintPlugin? {
//        val sqlLiteConfig: SQLiteLintConfig
//
//        /*
//         * HOOK模式下，SQLiteLint会自己去获取所有已执行的sql语句及其耗时(by hooking sqlite3_profile)
//         * @see 而另一个模式：SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY , 则需要调用 {@link SQLiteLint#notifySqlExecution(String, String, int)}来通知
//         * SQLiteLint 需要分析的、已执行的sql语句及其耗时
//         * @see TestSQLiteLintActivity#doTest()
//         */
//        // sqlLiteConfig = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.HOOK);
//        sqlLiteConfig = SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY)
//        return SQLiteLintPlugin(sqlLiteConfig)
//    }
//
////    private fun configureBatteryCanary(context: Context): BatteryMonitorPlugin? {
////        if (!BatteryEventDelegate.isInit()) {
////            BatteryEventDelegate.init(context.applicationContext as Application)
////        }
////        // Configuration of battery plugin is really complicated.
////        // See it in BatteryCanaryInitHelper.
////        // return BatteryCanarySimpleInitHelper.createMonitor(context);  // for simplified showcase
////        return BatteryCanaryInitHelper.createMonitor(context)
////    }
//
//    private fun configureMatrixLifecycle(): MatrixLifecycleConfig? {
//        return MatrixLifecycleConfig(
//            SupervisorConfig(true, true, ArrayList()),
//            true,
//            true,
//            LifecycleThreadConfig(),
//            true
//        )
//    }
//
//    fun getContext(): Context? {
//        return instance
//    }
}