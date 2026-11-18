package kotlin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface Metadata {
    String[] d1() default {};

    String[] d2() default {};

    int[] mv() default {};

    int xi() default 0;
}
