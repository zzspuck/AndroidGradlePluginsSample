package cn.cxzheng.tracemanplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import org.objectweb.asm.ClassVisitor

abstract class TraceManTransform():AsmClassVisitorFactory<TraceManParameter> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
      return TraceClassVisitor(nextClassVisitor,parameters.get())
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        TODO("Not yet implemented")
    }
}