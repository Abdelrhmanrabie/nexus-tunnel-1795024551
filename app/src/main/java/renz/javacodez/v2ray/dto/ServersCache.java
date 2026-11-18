package renz.javacodez.v2ray.dto;

import defpackage.e4;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ServersCache {
    private final String guid;
    private final ProfileItem profile;

    public ServersCache(String str, ProfileItem profileItem) {
        this.guid = str;
        this.profile = profileItem;
    }

    public static /* synthetic */ ServersCache copy$default(ServersCache serversCache, String str, ProfileItem profileItem, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serversCache.guid;
        }
        if ((i & 2) != 0) {
            profileItem = serversCache.profile;
        }
        return serversCache.copy(str, profileItem);
    }

    public final String component1() {
        return this.guid;
    }

    public final ProfileItem component2() {
        return this.profile;
    }

    public final ServersCache copy(String str, ProfileItem profileItem) {
        return new ServersCache(str, profileItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServersCache)) {
            return false;
        }
        ServersCache serversCache = (ServersCache) obj;
        return e4.a(this.guid, serversCache.guid) && e4.a(this.profile, serversCache.profile);
    }

    public final String getGuid() {
        return this.guid;
    }

    public final ProfileItem getProfile() {
        return this.profile;
    }

    public int hashCode() {
        return this.profile.hashCode() + (this.guid.hashCode() * 31);
    }

    public String toString() {
        return "ServersCache(guid=" + this.guid + ", profile=" + this.profile + ')';
    }
}
