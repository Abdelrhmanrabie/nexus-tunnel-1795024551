package com.trilead.ssh2.packets;

import defpackage.ak;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthRequestInteractive {
    byte[] payload;
    String serviceName;
    String[] submethods;
    String userName;

    public PacketUserauthRequestInteractive(String str, String str2, String[] strArr) {
        this.serviceName = str;
        this.userName = str2;
        this.submethods = strArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(50);
            typesWriterI.writeString(this.userName, "UTF-8");
            typesWriterI.writeString(this.serviceName);
            typesWriterI.writeString("keyboard-interactive");
            typesWriterI.writeString(AppConfig.CUSTOM);
            typesWriterI.writeNameList(this.submethods);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
