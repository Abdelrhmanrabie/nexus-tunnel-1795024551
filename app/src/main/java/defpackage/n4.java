package defpackage;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import on.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n4 extends ux implements nw {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n4(int i, Object obj, int i2) {
        super(i, obj);
        this.G0 = i2;
    }

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        int i = this.G0;
        if (i == 0) {
            return "computeTypeQualifierNickname";
        }
        if (i == 1) {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }
        if (i == 2) {
            return "prepareType";
        }
        if (i != 3) {
            return i != 4 ? "searchMethodsByNameWithoutBuiltinMagic" : "loadResource";
        }
        return "<init>";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        int i = this.G0;
        if (i == 0) {
            return ou0.a.b(l4.class);
        }
        if (i == 1) {
            return ou0.a.b(dd0.class);
        }
        if (i == 2) {
            return ou0.a.b(kc0$a.class);
        }
        if (i != 3) {
            return i != 4 ? ou0.a.b(dd0.class) : ou0.a.b(x9.class);
        }
        return ou0.a.b(on.a.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        int i = this.G0;
        if (i == 0) {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }
        if (i == 1) {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }
        if (i == 2) {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }
        if (i != 3) {
            return i != 4 ? "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;" : "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) throws IOException {
        int i = this.G0;
        if (i == 0) {
            ai0 ai0Var = (ai0) obj;
            l4 l4Var = (l4) this.receiver;
            l4Var.getClass();
            if (!ai0Var.getAnnotations().f(k4.a)) {
                return null;
            }
            Iterator it = ai0Var.getAnnotations().iterator();
            while (it.hasNext()) {
                g4 g4VarD = l4Var.d((g4) it.next());
                if (g4VarD != null) {
                    return g4VarD;
                }
            }
            return null;
        }
        if (i == 1) {
            return dd0.w((dd0) this.receiver, (ij0) obj);
        }
        if (i == 2) {
            return ((kc0$a) this.receiver).b((jc0) obj);
        }
        if (i == 3) {
            return ((on) this.receiver).new a((lc0$a) obj);
        }
        if (i != 4) {
            return dd0.v((dd0) this.receiver, (ij0) obj);
        }
        String str = (String) obj;
        ((x9) this.receiver).getClass();
        ClassLoader classLoader = x9.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        uRLConnectionOpenConnection.setUseCaches(false);
        return uRLConnectionOpenConnection.getInputStream();
    }
}
