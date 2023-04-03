package com.zuoyebang.iot.pad.launcher.matrix

//import com.tencent.matrix.util.MatrixLog
//import com.tencent.mrs.plugin.IDynamicConfig
//import com.tencent.mrs.plugin.IDynamicConfig.ExptEnum
//
///**
// * @Author : Gym
// * @Date : 2023/3/28 11:50 AM
// * @Description :
// */
//class DynamicConfigImpl : IDynamicConfig {
//
//    fun isFPSEnable(): Boolean {
//        return true
//    }
//
//    fun isTraceEnable(): Boolean {
//        return true
//    }
//
//    fun isMatrixEnable(): Boolean {
//        return true
//    }
//
//    fun isDumpHprof(): Boolean {
//        return false
//    }
//
//    fun isSignalAnrTraceEnable(): Boolean {
//        return true
//    }
//
//    override fun get(key: String?, defStr: String?): String {
//        return defStr?:""
//    }
//
//    override fun get(key: String?, defInt: Int): Int {
//        if (ExptEnum.clicfg_matrix_trace_evil_method_threshold.name == key) {
//            // 改变慢方法检测阙值
//            MatrixLog.i(
//                "matrix",
//                "key:$key, before change:$defInt, after change, value:50"
//            )
//            return 50 //new value
//        }
//        return defInt
//    }
//
//    override fun get(key: String?, defLong: Long): Long {
//        return defLong
//    }
//
//    override fun get(key: String?, defBool: Boolean): Boolean {
//        return defBool
//    }
//
//    override fun get(key: String?, defFloat: Float): Float {
//        return defFloat
//    }
//}