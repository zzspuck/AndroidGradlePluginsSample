package com.zzs.plugins;

import com.android.build.api.instrumentation.AsmClassVisitorFactory;
import com.android.build.api.instrumentation.ClassContext;
import com.android.build.api.instrumentation.ClassData;
import com.android.build.api.instrumentation.InstrumentationParameters;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassVisitor;

public abstract class FooClassVisitorFactory implements AsmClassVisitorFactory<InstrumentationParameters.None>{

    @Override
    public boolean isInstrumentable(@NotNull ClassData classData) {
        return false;
    }

    @NotNull
    @Override
    public ClassVisitor createClassVisitor(@NotNull ClassContext classContext, @NotNull ClassVisitor classVisitor) {
        return null;
    }
}
