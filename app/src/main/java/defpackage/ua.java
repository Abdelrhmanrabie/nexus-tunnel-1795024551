package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ua implements ta {
    public final Member a;
    public final Type b;
    public final Class c;
    public final List d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ua implements g9 {
        public final /* synthetic */ int G0;
        public final Object e;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor constructor, Object obj, int i) {
            this.G0 = i;
            if (i != 1) {
                Class declaringClass = constructor.getDeclaringClass();
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 2 ? new Type[0] : ae.A0(1, genericParameterTypes.length - 1, genericParameterTypes)));
            } else {
                super(constructor, constructor.getDeclaringClass(), null, constructor.getGenericParameterTypes());
            }
            this.e = obj;
        }

        @Override // defpackage.ta
        public final Object call(Object[] objArr) {
            int i = this.G0;
            b2.a(this, objArr);
            Constructor constructor = (Constructor) this.a;
            if (i != 0) {
                o6 o6Var = new o6(2);
                o6Var.a(this.e);
                o6Var.b(objArr);
                return constructor.newInstance(o6Var.f(new Object[o6Var.e()]));
            }
            o6 o6Var2 = new o6(3);
            o6Var2.a(this.e);
            o6Var2.b(objArr);
            o6Var2.a(null);
            return constructor.newInstance(o6Var2.f(new Object[o6Var2.e()]));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends ua {
        public final /* synthetic */ int G0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(Member member, Type type, Class cls, Type[] typeArr, int i) {
            super(member, type, cls, typeArr);
            this.G0 = i;
        }

        @Override // defpackage.ta
        public final Object call(Object[] objArr) {
            int i = this.G0;
            b2.a(this, objArr);
            Constructor constructor = (Constructor) this.a;
            if (i != 0) {
                return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
            }
            o6 o6Var = new o6(2);
            o6Var.b(objArr);
            o6Var.a(null);
            return constructor.newInstance(o6Var.f(new Object[o6Var.e()]));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class e extends ua {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends e implements g9 {
            public final Object e;

            public a(Field field, Object obj) {
                super(field, false);
                this.e = obj;
            }

            @Override // ua.e, defpackage.ta
            public final Object call(Object[] objArr) {
                b2.a(this, objArr);
                return ((Field) this.a).get(this.e);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends e implements g9 {
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends e {
            public final /* synthetic */ int G0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(Field field, boolean z, int i) {
                super(field, z);
                this.G0 = i;
            }

            @Override // defpackage.ua
            public void c(Object[] objArr) {
                if (this.G0 != 1) {
                    super.c(objArr);
                } else {
                    b2.a(this, objArr);
                    d(objArr.length == 0 ? null : objArr[0]);
                }
            }
        }

        public e(Field field, boolean z) {
            super(field, field.getGenericType(), z ? field.getDeclaringClass() : null, new Type[0]);
        }

        @Override // defpackage.ta
        public Object call(Object[] objArr) {
            c(objArr);
            return ((Field) this.a).get(this.c != null ? ae.E0(objArr) : null);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class f extends ua {
        public final /* synthetic */ int G0 = 0;
        public final boolean e;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends f implements g9 {
            public final Object f;

            public a(Field field, boolean z, Object obj) {
                super(field, z, false);
                this.f = obj;
            }

            @Override // ua.f, defpackage.ta
            public final Object call(Object[] objArr) throws IllegalAccessException {
                c(objArr);
                ((Field) this.a).set(this.f, ae.E0(objArr));
                return tb1.a;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends f implements g9 {
            @Override // ua.f, defpackage.ta
            public final Object call(Object[] objArr) throws IllegalAccessException {
                c(objArr);
                ((Field) this.a).set(null, ae.K0(objArr));
                return tb1.a;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends f {
            public final /* synthetic */ int G0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(Field field, boolean z, boolean z2, int i) {
                super(field, z, z2);
                this.G0 = i;
            }

            @Override // ua.f, defpackage.ua
            public void c(Object[] objArr) {
                int i = this.G0;
                super.c(objArr);
                if (i != 1) {
                    return;
                }
                d(objArr.length == 0 ? null : objArr[0]);
            }
        }

        public f(Field field, boolean z, boolean z2) {
            super(field, Void.TYPE, z2 ? field.getDeclaringClass() : null, new Type[]{field.getGenericType()});
            this.e = z;
        }

        public /* synthetic */ f(Method method, boolean z, int i) {
            this(method, (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z, method.getGenericParameterTypes());
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Method method, boolean z, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            super(method, genericReturnType, z ? method.getDeclaringClass() : null, typeArr);
            this.e = e4.a(genericReturnType, Void.TYPE);
        }

        @Override // defpackage.ua
        public void c(Object[] objArr) {
            if (this.G0 != 0) {
                super.c(objArr);
                return;
            }
            b2.a(this, objArr);
            if (this.e && ae.K0(objArr) == null) {
                d.AnonymousClass0.m$2("null is not allowed as a value for this property.");
            }
        }

        @Override // defpackage.ta
        public Object call(Object[] objArr) throws IllegalAccessException {
            c(objArr);
            ((Field) this.a).set(this.c != null ? ae.E0(objArr) : null, ae.K0(objArr));
            return tb1.a;
        }

        public Object e(Object[] objArr, Object obj) {
            return this.e ? tb1.a : ((Method) this.a).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    public ua(Member member, Type type, Class cls, Type[] typeArr) {
        List listAsList;
        this.a = member;
        this.b = type;
        this.c = cls;
        if (cls == null) {
            listAsList = ae.M0(typeArr);
        } else {
            o6 o6Var = new o6(2);
            o6Var.a(cls);
            o6Var.b(typeArr);
            Object[] objArrF = o6Var.f(new Type[o6Var.e()]);
            listAsList = objArrF.length > 0 ? Arrays.asList(objArrF) : uq.b;
        }
        this.d = listAsList;
    }

    @Override // defpackage.ta
    public final List a() {
        return this.d;
    }

    public void c(Object[] objArr) {
        b2.a(this, objArr);
    }

    public final void d(Object obj) {
        if (obj == null || !this.a.getDeclaringClass().isInstance(obj)) {
            d.AnonymousClass0.m$2("An object member requires the object instance passed as the first argument.");
        }
    }

    @Override // defpackage.ta
    public final Type getReturnType() {
        return this.b;
    }
}
