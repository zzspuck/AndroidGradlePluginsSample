package com.zzs.plugins.track;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;

public class TrackMethodVisitor extends AdviceAdapter {
    private final String className;
    private final Type[] argumentArrays;

    public TrackMethodVisitor(String className, int api, MethodVisitor mv, int access, String methodName, String desc) {
        super(api, mv, access, methodName, desc);
        this.className = className;
        this.argumentArrays = Type.getArgumentTypes(desc);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();

        for (int i = 0; i < argumentArrays.length; i++) {
            Type type = argumentArrays[i];
            int index = i + 1;
            mv.visitVarInsn(Opcodes.ALOAD, index);
            box(type);

            if (className != null && className.contains("$")) {
                mv.visitMethodInsn(
                        Opcodes.INVOKESTATIC,
                        com.zzs.plugins.Constants.tracker,
                        "c",
                        "(Landroid/view/View;)V",
                        false
                );
            } else if (className != null) {
                mv.visitLdcInsn(className);
                mv.visitMethodInsn(
                        Opcodes.INVOKESTATIC,
                        com.zzs.plugins.Constants.tracker,
                        "c",
                        "(Landroid/view/View;Ljava/lang/String;)V",
                        false
                );
            }
        }
    }
}

