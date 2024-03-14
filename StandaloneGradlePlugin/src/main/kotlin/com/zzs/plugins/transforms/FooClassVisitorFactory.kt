package com.zzs.plugins.transforms


import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import com.android.build.api.instrumentation.InstrumentationParameters
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.util.TraceClassVisitor
import java.io.PrintWriter

/**
 * @author rookie
 * @since 12-03-2019
 */
abstract class FooClassVisitorFactory : AsmClassVisitorFactory<InstrumentationParameters.None> {
    override fun isInstrumentable(classData: ClassData): Boolean {
        return classData.className.startsWith("com.example.androidgradlepluginssample.MainActivity")
    }

    override fun createClassVisitor(
        classContext: ClassContext, nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return TraceClassVisitor(nextClassVisitor, PrintWriter(System.out))
    }
}