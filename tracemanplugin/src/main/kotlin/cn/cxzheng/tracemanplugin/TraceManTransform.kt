package cn.cxzheng.tracemanplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import com.android.tools.lint.LintResourceRepository.Companion.EmptyRepository.project
import org.objectweb.asm.ClassVisitor
import java.io.File

abstract class TraceManTransform():AsmClassVisitorFactory<TraceManParameter> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        val traceManConfig = parameters.get()
        val output = traceManConfig.output.get()
                if (output == null || output.isEmpty()) {
                    //traceManConfig.output.set() = project.getBuildDir().getAbsolutePath() + File.separator + "traceman_output"
                }
      return TraceClassVisitor(nextClassVisitor,parameters.get())
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        TODO("Not yet implemented")
    }
}