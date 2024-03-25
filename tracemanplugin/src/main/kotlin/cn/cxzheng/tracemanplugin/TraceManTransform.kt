package cn.cxzheng.tracemanplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import com.android.tools.lint.LintResourceRepository.Companion.EmptyRepository.project
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes
import java.io.File

abstract class TraceManTransform() : AsmClassVisitorFactory<TraceManParameter> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        val traceManConfig = parameters.get()
        val output = traceManConfig.output.get()
        if (output == null || output.isEmpty()) {
            //traceManConfig.output.set() = project.getBuildDir().getAbsolutePath() + File.separator + "traceman_output"
        }
        val traceConfig = if (traceManConfig.open.get()) {
            val traceConfig = initConfig(traceManConfig)
            traceConfig.parseTraceConfigFile()
            traceConfig
        } else {
            Config()
        }
        return TraceClassVisitor(Opcodes.ASM9, nextClassVisitor, traceConfig)
    }

    private fun initConfig(configuration: TraceManParameter): Config {
        val config = Config()
        config.MTraceConfigFile = configuration.traceConfigFile.get()
        config.MIsNeedLogTraceInfo = configuration.logTraceInfo.get()
        return config
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        return true
    }
}