package renz.javacodez.v2ray.dto;

import defpackage.a7;
import defpackage.e4;
import defpackage.gr;
import defpackage.hr;
import defpackage.z;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum Language {
    AUTO(AppConfig.DEFAULT_SECURITY),
    ENGLISH("en"),
    CHINA("zh-rCN"),
    TRADITIONAL_CHINESE("zh-rTW"),
    VIETNAMESE("vi"),
    RUSSIAN("ru"),
    PERSIAN("fa"),
    BANGLA("bn"),
    BAKHTIARI("bqi-rIR");

    private final String code;
    private static final /* synthetic */ gr $ENTRIES = new hr(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final Language fromCode(String str) {
            Object next;
            z zVar = (z) Language.getEntries();
            zVar.getClass();
            a7 a7Var = new a7(1, zVar);
            do {
                if (!a7Var.hasNext()) {
                    next = null;
                    break;
                }
                next = a7Var.next();
            } while (!e4.a(((Language) next).getCode(), str));
            Language language = (Language) next;
            return language == null ? Language.AUTO : language;
        }
    }

    Language(String str) {
        this.code = str;
    }

    public static gr getEntries() {
        return $ENTRIES;
    }

    public final String getCode() {
        return this.code;
    }
}
