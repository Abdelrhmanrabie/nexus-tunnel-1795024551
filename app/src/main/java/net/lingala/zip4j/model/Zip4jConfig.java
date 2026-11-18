package net.lingala.zip4j.model;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Zip4jConfig {
    private final int bufferSize;
    private final Charset charset;

    public Zip4jConfig(Charset charset, int i) {
        this.charset = charset;
        this.bufferSize = i;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        return this.charset;
    }
}
