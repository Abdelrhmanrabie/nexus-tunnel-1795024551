package com.trilead.ssh2;

import com.trilead.ssh2.packets.PacketExtInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ExtensionInfo {
    private final Set<String> signatureAlgorithmsAccepted;

    private ExtensionInfo(Set<String> set) {
        this.signatureAlgorithmsAccepted = Collections.unmodifiableSet(set);
    }

    public static ExtensionInfo fromPacketExtInfo(PacketExtInfo packetExtInfo) {
        String str = packetExtInfo.getExtNameToValue().get("server-sig-algs");
        if (str == null) {
            return new ExtensionInfo(Collections.EMPTY_SET);
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, str.split(","));
        return new ExtensionInfo(hashSet);
    }

    public static ExtensionInfo noExtInfoSeen() {
        return new ExtensionInfo(Collections.EMPTY_SET);
    }

    public Set<String> getSignatureAlgorithmsAccepted() {
        return this.signatureAlgorithmsAccepted;
    }
}
