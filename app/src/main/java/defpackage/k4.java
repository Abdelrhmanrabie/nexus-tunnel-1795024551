package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class k4 {
    public static final cv a = new cv("javax.annotation.meta.TypeQualifierNickname");
    public static final cv b = new cv("javax.annotation.meta.TypeQualifier");
    public static final cv c = new cv("javax.annotation.meta.TypeQualifierDefault");
    public static final cv d = new cv("kotlin.annotations.jvm.UnderMigration");
    public static final List e;
    public static final Map f;
    public static final LinkedHashMap g;
    public static final Set h;

    static {
        j4 j4Var = j4.VALUE_PARAMETER;
        List listAsList = Arrays.asList(j4.FIELD, j4.METHOD_RETURN_TYPE, j4Var, j4.TYPE_PARAMETER_BOUNDS, j4.TYPE_USE);
        e = listAsList;
        cv cvVar = s70.c;
        am0 am0Var = am0.d;
        Map mapSingletonMap = Collections.singletonMap(cvVar, new e50(new bm0(am0Var, false), listAsList, false));
        f = mapSingletonMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ye1.h(new jo0(new cv("javax.annotation.ParametersAreNullableByDefault"), new e50(new bm0(am0.c, false), Collections.singletonList(j4Var))), new jo0(new cv("javax.annotation.ParametersAreNonnullByDefault"), new e50(new bm0(am0Var, false), Collections.singletonList(j4Var)))));
        linkedHashMap.putAll(mapSingletonMap);
        g = linkedHashMap;
        h = ae.O0(new cv[]{s70.e, s70.f});
    }
}
