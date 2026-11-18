package org.apache.commons.logging;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LogConfigurationException extends RuntimeException {
    public final Exception cause;

    public LogConfigurationException(String str, Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" (Caused by ");
        stringBuffer.append(exc);
        stringBuffer.append(")");
        super(stringBuffer.toString());
        this.cause = exc;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }
}
