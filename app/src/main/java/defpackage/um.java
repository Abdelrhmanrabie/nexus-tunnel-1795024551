package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class um implements tm {
    public static final /* synthetic */ ja0[] W;
    public final vm A;
    public final vm B;
    public final vm C;
    public final vm D;
    public final vm E;
    public final vm F;
    public final vm G;
    public final vm H;
    public final vm I;
    public final vm J;
    public final vm K;
    public final vm L;
    public final vm M;
    public final vm N;
    public final vm O;
    public final vm P;
    public final vm Q;
    public final vm R;
    public final vm S;
    public final vm U;
    public final vm V;
    public boolean a;
    public final vm b = new vm(qd$a.a$2, this);
    public final vm c;
    public final vm d;
    public final vm e;
    public final vm f;
    public final vm g;
    public final vm h;
    public final vm i;
    public final vm j;
    public final vm k;
    public final vm l;
    public final vm m;
    public final vm n;
    public final vm o;
    public final vm p;
    public final vm q;
    public final vm r;
    public final vm s;
    public final vm u;
    public final vm v;
    public final vm w;
    public final vm x;
    public final vm y;
    public final vm z;

    static {
        pu0 pu0Var = ou0.a;
        W = new ja0[]{pu0Var.d(new aj0(pu0Var.b(um.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), pu0Var.d(new aj0(pu0Var.b(um.class), "withDefinedIn", "getWithDefinedIn()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "modifiers", "getModifiers()Ljava/util/Set;")), pu0Var.d(new aj0(pu0Var.b(um.class), "startFromName", "getStartFromName()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "debugMode", "getDebugMode()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "verbose", "getVerbose()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "unitReturnType", "getUnitReturnType()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "withoutReturnType", "getWithoutReturnType()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "enhancedTypes", "getEnhancedTypes()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderDefaultModality", "getRenderDefaultModality()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), pu0Var.d(new aj0(pu0Var.b(um.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), pu0Var.d(new aj0(pu0Var.b(um.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), pu0Var.d(new aj0(pu0Var.b(um.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), pu0Var.d(new aj0(pu0Var.b(um.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), pu0Var.d(new aj0(pu0Var.b(um.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), pu0Var.d(new aj0(pu0Var.b(um.class), "receiverAfterName", "getReceiverAfterName()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), pu0Var.d(new aj0(pu0Var.b(um.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), pu0Var.d(new aj0(pu0Var.b(um.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), pu0Var.d(new aj0(pu0Var.b(um.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), pu0Var.d(new aj0(pu0Var.b(um.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), pu0Var.d(new aj0(pu0Var.b(um.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public um() {
        Boolean bool = Boolean.TRUE;
        this.c = new vm(bool, this);
        this.d = new vm(bool, this);
        this.e = new vm(sm.c, this);
        Boolean bool2 = Boolean.FALSE;
        this.f = new vm(bool2, this);
        this.g = new vm(bool2, this);
        this.h = new vm(bool2, this);
        this.i = new vm(bool2, this);
        this.j = new vm(bool2, this);
        this.k = new vm(bool, this);
        this.l = new vm(bool2, this);
        this.m = new vm(bool2, this);
        this.n = new vm(bool2, this);
        this.o = new vm(bool, this);
        this.p = new vm(bool, this);
        this.q = new vm(bool2, this);
        this.r = new vm(bool2, this);
        this.s = new vm(bool2, this);
        this.u = new vm(bool2, this);
        this.v = new vm(bool2, this);
        this.w = new vm(bool2, this);
        this.x = new vm(p0.b$12, this);
        this.y = new vm(p0.b$11, this);
        this.z = new vm(bool, this);
        this.A = new vm(on0.c, this);
        this.B = new vm(mm$l$a.a, this);
        this.C = new vm(zu0.b, this);
        this.D = new vm(mo0.b, this);
        this.E = new vm(bool2, this);
        this.F = new vm(bool2, this);
        this.G = new vm(lq0.b, this);
        this.H = new vm(bool2, this);
        this.I = new vm(bool2, this);
        this.J = new vm(yq.b, this);
        this.K = new vm(yr.a, this);
        this.L = new vm(null, this);
        this.M = new vm(c4.NO_ARGUMENTS, this);
        this.N = new vm(bool2, this);
        this.O = new vm(bool, this);
        this.P = new vm(bool, this);
        this.Q = new vm(bool2, this);
        this.R = new vm(bool, this);
        this.S = new vm(bool, this);
        this.U = new vm(bool2, this);
        this.V = new vm(bool, this);
    }

    @Override // defpackage.tm
    public final void a() {
        ja0 ja0Var = W[29];
        this.E.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final void b() {
        ja0 ja0Var = W[30];
        this.F.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final void d() {
        ja0 ja0Var = W[20];
        this.v.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final void e(qd$a qd_a) {
        ja0 ja0Var = W[0];
        this.b.c(qd_a);
    }

    @Override // defpackage.tm
    public final void f() {
        ja0 ja0Var = W[4];
        this.f.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final Set g() {
        ja0 ja0Var = W[35];
        return (Set) this.K.a;
    }

    public final boolean h() {
        ja0 ja0Var = W[6];
        return ((Boolean) this.h.a).booleanValue();
    }

    @Override // defpackage.tm
    public final void i() {
        ja0 ja0Var = W[21];
        this.w.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final void j() {
        ja0 ja0Var = W[6];
        this.h.c(Boolean.TRUE);
    }

    @Override // defpackage.tm
    public final void k(Set set) {
        ja0 ja0Var = W[3];
        this.e.c(set);
    }

    @Override // defpackage.tm
    public final void l(LinkedHashSet linkedHashSet) {
        ja0 ja0Var = W[35];
        this.K.c(linkedHashSet);
    }

    @Override // defpackage.tm
    public final void m(mo0 mo0Var) {
        ja0 ja0Var = W[28];
        this.D.c(mo0Var);
    }

    @Override // defpackage.tm
    public final void n() {
        ja0 ja0Var = W[1];
        this.c.c(Boolean.FALSE);
    }

    @Override // defpackage.tm
    public final void o() {
        zu0.a aVar = zu0.c;
        ja0 ja0Var = W[27];
        this.C.c(aVar);
    }
}
