package com.zzs.plugins;


import com.android.build.api.instrumentation.FramesComputationMode;
import com.android.build.api.instrumentation.InstrumentationScope;
import com.android.build.api.variant.AndroidComponentsExtension;
import com.android.build.api.variant.ApplicationVariant;
import com.zzs.plugins.extensions.PhoenixExtension;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GreetingStandaloneGradlePlugins implements Plugin<Project> {

    private static final String TAG = "GreetingStandaloneGradlePlugins";

    @Override
    public void apply(Project project) {
        System.out.println("GreetingStandaloneGradlePlugins(standalone) ---> apply");
        project.task("helloStandalone").doLast(task -> System.out.println("Hello from the com.nxg.plugins.GreetingStandaloneGradlePlugins(standalone)"));

        project.getExtensions().create("phoenix", PhoenixExtension.class, project.getObjects());

        System.out.println();
        System.out.println("===================================PhoenixPlugin===============begin==================");
        System.out.println();

        AndroidComponentsExtension androidComponents = project.getExtensions().getByType(AndroidComponentsExtension.class);
        // TransformExtension transformExtension = getTransformConfig(project);


        androidComponents.onVariants(androidComponents.selector().all(), (Action<ApplicationVariant>) variant -> {
            variant.getInstrumentation().transformClassesWith(FooClassVisitorFactory.class, InstrumentationScope.ALL, none -> null);
            variant.getInstrumentation().setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES);
        });
     /*   androidComponents.onVariants(variant -> {
            variant.getInstrumentation().transformClassesWith(FooClassVisitorFactory.class, InstrumentationScope.ALL, it -> {});
            variant.getInstrumentation().setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES);

            variant.getInstrumentation().transformClassesWith(TrackClassVisitorFactory.class, InstrumentationScope.PROJECT, it -> {
                it.trackOn.set(transformExtension.getTrackOn());
            });
            variant.getInstrumentation().setAsmFramesComputationMode(FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_METHODS);

            variant.getInstrumentation().transformClassesWith(CatClassVisitorFactory.class, InstrumentationScope.ALL, it -> {
                it.catOn.set(transformExtension.getCatOn());
            });

            variant.getInstrumentation().transformClassesWith(TigerClassVisitorFactory.class, InstrumentationScope.ALL, it -> {
                it.tigerOn.set(transformExtension.getTigerOn());
            });
            variant.getInstrumentation().setAsmFramesComputationMode(FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_CLASSES);
        });*/

        System.out.println();
        System.out.println("===================================PhoenixPlugin===============end==================");
        System.out.println();
    }
}

