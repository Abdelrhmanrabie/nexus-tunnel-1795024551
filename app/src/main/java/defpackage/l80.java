package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class l80 {
    public static final LinkedHashSet a = nz0.y1(e.N(new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}, "Collection"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    public static final LinkedHashSet b;
    public static final LinkedHashSet c;
    public static final LinkedHashSet d;
    public static final LinkedHashSet e;
    public static final LinkedHashSet f;

    static {
        List<u80> listAsList = Arrays.asList(u80.BOOLEAN, u80.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (u80 u80Var : listAsList) {
            he.C0(e.M(new String[]{u80Var.c + "Value()" + u80Var.d}, u80Var.f().a.g().b()), linkedHashSet);
        }
        b = nz0.x1(nz0.x1(nz0.x1(nz0.x1(nz0.x1(nz0.x1(linkedHashSet, e.N(new String[]{"sort(Ljava/util/Comparator;)V"}, "List")), e.M(new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"}, "String")), e.M(new String[]{"isInfinite()Z", "isNaN()Z"}, "Double")), e.M(new String[]{"isInfinite()Z", "isNaN()Z"}, "Float")), e.M(new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"}, "Enum")), e.M(new String[]{"isEmpty()Z"}, "CharSequence"));
        c = nz0.x1(nz0.x1(nz0.x1(nz0.x1(nz0.x1(nz0.x1(e.M(new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}, "CharSequence"), e.N(new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"}, "Iterator")), e.M(new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"}, "Iterable")), e.M(new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"}, "Throwable")), e.N(new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"}, "Collection")), e.N(new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V"}, "List")), e.N(new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}, "Map"));
        d = nz0.x1(nz0.x1(e.N(new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}, "Collection"), e.N(new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"}, "List")), e.N(new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}, "Map"));
        u80 u80Var2 = u80.BYTE;
        List listAsList2 = Arrays.asList(u80.BOOLEAN, u80Var2, u80.DOUBLE, u80.FLOAT, u80Var2, u80.INT, u80.LONG, u80.SHORT);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listAsList2.iterator();
        while (it.hasNext()) {
            String strB = ((u80) it.next()).f().a.g().b();
            String[] strArrL = e.l("Ljava/lang/String;");
            he.C0(e.M((String[]) Arrays.copyOf(strArrL, strArrL.length), strB), linkedHashSet2);
        }
        String[] strArrL2 = e.l("D");
        LinkedHashSet linkedHashSetX1 = nz0.x1(linkedHashSet2, e.M((String[]) Arrays.copyOf(strArrL2, strArrL2.length), "Float"));
        String[] strArrL3 = e.l("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        e = nz0.x1(linkedHashSetX1, e.M((String[]) Arrays.copyOf(strArrL3, strArrL3.length), "String"));
        String[] strArrL4 = e.l("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f = e.M((String[]) Arrays.copyOf(strArrL4, strArrL4.length), "Throwable");
    }
}
