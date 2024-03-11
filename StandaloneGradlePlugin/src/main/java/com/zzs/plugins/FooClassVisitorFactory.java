package com.zzs.plugins;

import com.android.build.api.instrumentation.AsmClassVisitorFactory;
import com.android.build.api.instrumentation.ClassContext;
import com.android.build.api.instrumentation.ClassData;
import com.android.build.api.instrumentation.InstrumentationParameters;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.util.TraceClassVisitor;
import java.io.PrintWriter;

public abstract class FooClassVisitorFactory implements AsmClassVisitorFactory<InstrumentationParameters.None>{

    @Override
    public boolean isInstrumentable(@NotNull ClassData classData) {
        return classData.getClassName().startsWith(" com.example.androidgradlepluginssample.MainActivity");
    }

    @NotNull
    @Override
    public ClassVisitor createClassVisitor(@NotNull ClassContext classContext, @NotNull ClassVisitor classVisitor) {
        return new TraceClassVisitor(classVisitor, new PrintWriter(System.out));
    }
}
