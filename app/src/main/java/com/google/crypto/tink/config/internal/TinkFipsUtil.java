package com.google.crypto.tink.config.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class TinkFipsUtil {
    public static final AtomicBoolean isRestrictedToFips;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum AlgorithmFipsCompatibility {
        ALGORITHM_NOT_FIPS { // from class: com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility.1
        },
        /* JADX INFO: Fake field, exist only in values array */
        EF9 { // from class: com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility.2
        }
    }

    static {
        Logger.getLogger(TinkFipsUtil.class.getName());
        isRestrictedToFips = new AtomicBoolean(false);
    }
}
