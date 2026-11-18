package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gu0 extends ui implements ft0, b50 {
    public final TypeVariable a;

    public gu0(TypeVariable typeVariable) {
        this.a = typeVariable;
    }

    @Override // defpackage.o40
    public final ct0 c(cv cvVar) {
        Annotation[] declaredAnnotations;
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return e.N0(declaredAnnotations, cvVar);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof gu0) {
            return e4.a(this.a, ((gu0) obj).a);
        }
        return false;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return e4.b((ft0) this);
    }

    @Override // defpackage.ft0
    public final AnnotatedElement getElement() {
        TypeVariable typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return gu0.class.getName() + ": " + this.a;
    }
}
