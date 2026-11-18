package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
