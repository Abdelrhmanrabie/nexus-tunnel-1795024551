package com.google.android.material.transition;

import defpackage.e;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class FadeModeEvaluators {
    public static final AnonymousClass1 IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public final FadeModeResult evaluate(float f, float f2, float f3) {
            return FadeModeResult.endOnTop(TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    };
    public static final AnonymousClass2 OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public final FadeModeResult evaluate(float f, float f2, float f3) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), 255);
        }
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.transition.FadeModeEvaluators$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.material.transition.FadeModeEvaluators$2] */
    static {
        new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
            @Override // com.google.android.material.transition.FadeModeEvaluator
            public final FadeModeResult evaluate(float f, float f2, float f3) {
                return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), TransitionUtils.lerp(0, 255, f2, f3, f));
            }
        };
        new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
            @Override // com.google.android.material.transition.FadeModeEvaluator
            public final FadeModeResult evaluate(float f, float f2, float f3) {
                float fA = e.a(f3, f2, 0.35f, f2);
                return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, fA, f), TransitionUtils.lerp(0, 255, fA, f3, f));
            }
        };
    }

    private FadeModeEvaluators() {
    }
}
