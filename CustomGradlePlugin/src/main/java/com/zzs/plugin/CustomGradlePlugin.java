package com.zzs.plugin;


import static org.codehaus.groovy.runtime.DefaultGroovyMethods.println;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CustomGradlePlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        println("CustomGradlePlugin");
    }
}