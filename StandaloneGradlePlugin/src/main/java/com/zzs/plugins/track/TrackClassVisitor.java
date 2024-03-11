package com.zzs.plugins.track;

import static java.sql.DriverManager.println;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.Arrays;

public class TrackClassVisitor extends ClassVisitor {
private boolean mTrackOn;
private boolean hack;
private String className;
    public TrackClassVisitor(int api, boolean trackOn, ClassVisitor classVisitor) {
        super(api, classVisitor);
        mTrackOn = trackOn;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        if (!mTrackOn) {
            return;
        }
        if (name.startsWith("home/smart/fly/animations")) {
            for (String anInterface : interfaces) {
                if (anInterface == "android/view/View$OnClickListener") {
                    println("bingo , find click in class : $className");
                    hack = true;
                }
            }
        }
    }

    @Override
    public MethodVisitor visitMethod(
            int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
        if (mTrackOn && hack) {
//        System.out.println("name is " + name + ", desc is " + desc);
            if ("onClick".equals(name) && "(Landroid/view/View;)V".equals(desc)) {
                methodVisitor = new TrackMethodVisitor(className, api, methodVisitor, access, name, desc);
            }
        }

        return methodVisitor;
    }
}
