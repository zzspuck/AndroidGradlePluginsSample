package com.zzs.plugins;

import com.android.build.api.instrumentation.FramesComputationMode;
import com.android.build.api.instrumentation.InstrumentationScope;
import com.android.build.api.variant.AndroidComponentsExtension;
import com.android.build.api.variant.VariantSelector;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import kotlin.jvm.functions.Function1;

public class GreetingStandaloneGradlePlugins implements Plugin<Project> {

    private static final String TAG = "GreetingStandaloneGradlePlugins";

    @Override
    public void apply(Project project) {
        AndroidComponentsExtension androidComponents = project.getExtensions().getByType(AndroidComponentsExtension.class);
       /* androidComponents.onVariants(androidComponents.selector().all(),variant -> {
            variant.getInstrumentation().transformClassesWith(
                    FooClassVisitorFactory.class, InstrumentationScope.ALL,
                    it -> {
                    }
            );
            variant.getInstrumentation().setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES);
        });*/
    }
}

