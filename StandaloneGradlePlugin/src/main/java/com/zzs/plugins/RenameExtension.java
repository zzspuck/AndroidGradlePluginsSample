package com.zzs.plugins;

public class RenameExtension {
    private Function1<String, Unit> result = (aa) -> null;
    private String prefix = "animation";
    private boolean withTime = false;
    private boolean withVariantName = false;
    private boolean withVariantVersion = false;
    private boolean onlyDebug = false;

    public Function1<String, Unit> getResult() {
        return result;
    }

    public void setResult(Function1<String, Unit> result) {
        this.result = result;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isWithTime() {
        return withTime;
    }

    public void setWithTime(boolean withTime) {
        this.withTime = withTime;
    }

    public boolean isWithVariantName() {
        return withVariantName;
    }

    public void setWithVariantName(boolean withVariantName) {
        this.withVariantName = withVariantName;
    }

    public boolean isWithVariantVersion() {
        return withVariantVersion;
    }

    public void setWithVariantVersion(boolean withVariantVersion) {
        this.withVariantVersion = withVariantVersion;
    }

    public boolean isOnlyDebug() {
        return onlyDebug;
    }

    public void setOnlyDebug(boolean onlyDebug) {
        this.onlyDebug = onlyDebug;
    }

    @Override
    public String toString() {
        return "RenameExtension(result=" + result + ", prefix='" + prefix + "', withTime=" + withTime + ", withVariantName=" + withVariantName + ", withVariantVersion=" + withVariantVersion + ", onlyDebug=" + onlyDebug + ")";
    }
}

