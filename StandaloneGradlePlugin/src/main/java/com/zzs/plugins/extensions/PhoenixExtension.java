package com.zzs.plugins.extensions;

import com.zzs.plugins.RenameExtension;

import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;

public class PhoenixExtension {
    private final RenameExtension rename;
    private final TransformExtension transform;

    public PhoenixExtension(ObjectFactory objectFactory) {
        this.rename = objectFactory.newInstance(RenameExtension.class);
        this.transform = objectFactory.newInstance(TransformExtension.class);
    }

    public void rename(Action<RenameExtension> action) {
        action.execute(rename);
    }

    public void transform(Action<TransformExtension> action) {
        action.execute(transform);
    }

    @Override
    public String toString() {
        return "PhoenixExtension(rename=" + rename + ", transform=" + transform + ")";
    }
}

