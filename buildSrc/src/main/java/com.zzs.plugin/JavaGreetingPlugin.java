package com.zzs.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JavaGreetingPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("JavaGreetingPlugin(buildSrc) ---> apply");
        project.task("BuildSrcHelloTask").doLast(task -> System.out.println("Hello from the com.zzs.plugin.JavaGreetingPlugin(buildSrc)"));
    }
}
