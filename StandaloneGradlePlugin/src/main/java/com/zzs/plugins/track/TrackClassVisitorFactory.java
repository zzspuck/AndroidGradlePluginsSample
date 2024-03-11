package com.zzs.plugins.track;

import com.android.build.api.instrumentation.AsmClassVisitorFactory;
import com.android.build.api.instrumentation.ClassContext;
import com.android.build.api.instrumentation.ClassData;
import com.android.build.api.instrumentation.InstrumentationParameters;

import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.objectweb.asm.ClassVisitor;


public abstract class TrackClassVisitorFactory implements AsmClassVisitorFactory<TrackClassVisitorFactory.TrackParam> {

    @Override
    public boolean isInstrumentable(ClassData classData) {
        return true;
    }

    public interface TrackParam extends InstrumentationParameters {
        @Input
        Property<Boolean> getTrackOn();
    }

    @Override
    public ClassVisitor createClassVisitor(ClassContext classContext, ClassVisitor nextClassVisitor) {
        boolean trackOn = getParameters().getOrNull().getTrackOn().get();
        int api = getInstrumentationContext().getApiVersion().get();
        return new TrackClassVisitor(api, trackOn, nextClassVisitor);
    }
}
