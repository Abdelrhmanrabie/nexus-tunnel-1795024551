package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ua1 extends ak {
    public static Class a = null;
    public static Constructor b = null;
    public static Method c = null;
    public static Method d = null;
    public static boolean e = false;
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ua1(int i) {
        super(4);
        this.G0 = i;
    }

    public static Font g(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iH = h(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iH2 = h(fontStyle, font2.getStyle());
            if (iH2 < iH) {
                font = font2;
                iH = iH2;
            }
        }
        return font;
    }

    public static boolean g(int i, Object obj, String str, boolean z) throws NoSuchMethodException {
        h();
        try {
            return ((Boolean) c.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int h(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public static void h() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (e) {
            return;
        }
        e = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            cls = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    @Override // defpackage.ak
    public Typeface a(Context context, vu$c vu_c, Resources resources, int i) throws NoSuchMethodException {
        if (this.G0 != 0) {
            try {
                FontFamily.Builder builder = null;
                for (vu$d vu_d : vu_c.a) {
                    try {
                        Font fontBuild = new Font.Builder(resources, vu_d.f).setWeight(vu_d.b).setSlant(vu_d.c ? 1 : 0).setTtcIndex(vu_d.e).setFontVariationSettings(vu_d.d).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (IOException unused) {
                    }
                }
                if (builder == null) {
                    return null;
                }
                FontFamily fontFamilyBuild = builder.build();
                return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(g(fontFamilyBuild, i).getStyle()).build();
            } catch (Exception unused2) {
                return null;
            }
        }
        h();
        try {
            Object objNewInstance = b.newInstance(null);
            for (vu$d vu_d2 : vu_c.a) {
                File fileD = e4.d(context);
                if (fileD != null) {
                    try {
                        if (e4.b(fileD, resources, vu_d2.f)) {
                            boolean zG = g(vu_d2.b, objNewInstance, fileD.getPath(), vu_d2.c);
                            fileD.delete();
                            if (zG) {
                            }
                        }
                    } catch (RuntimeException unused3) {
                    } catch (Throwable th) {
                        fileD.delete();
                        throw th;
                    }
                    fileD.delete();
                    return null;
                }
                return null;
            }
            h();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) a, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) d.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // defpackage.ak
    public Typeface b(Context context, xu[] xuVarArr, int i) {
        File file;
        Typeface typefaceCreateFromFile;
        if (this.G0 != 0) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                FontFamily.Builder builder = null;
                for (xu xuVar : xuVarArr) {
                    try {
                        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(xuVar.a, "r", null);
                        if (parcelFileDescriptorOpenFileDescriptor == null) {
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                            }
                        } else {
                            try {
                                Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(xuVar.c).setSlant(xuVar.d ? 1 : 0).setTtcIndex(xuVar.b).build();
                                if (builder == null) {
                                    builder = new FontFamily.Builder(fontBuild);
                                } else {
                                    builder.addFont(fontBuild);
                                }
                            } catch (Throwable th) {
                                try {
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                }
                if (builder == null) {
                    return null;
                }
                FontFamily fontFamilyBuild = builder.build();
                return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(g(fontFamilyBuild, i).getStyle()).build();
            } catch (Exception unused2) {
                return null;
            }
        }
        if (xuVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = context.getContentResolver().openFileDescriptor(f(i, xuVarArr).a, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor2 == null) {
                if (parcelFileDescriptorOpenFileDescriptor2 == null) {
                    return null;
                }
                parcelFileDescriptorOpenFileDescriptor2.close();
                return null;
            }
            try {
                try {
                    String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor2.getFd());
                    file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                } catch (Throwable th3) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (ErrnoException unused3) {
            }
            if (file != null && file.canRead()) {
                Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                parcelFileDescriptorOpenFileDescriptor2.close();
                return typefaceCreateFromFile2;
            }
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor());
            try {
                File fileD = e4.d(context);
                if (fileD != null) {
                    try {
                        typefaceCreateFromFile = !e4.c(fileD, fileInputStream) ? null : Typeface.createFromFile(fileD.getPath());
                    } catch (RuntimeException unused4) {
                    } finally {
                        fileD.delete();
                    }
                }
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor2.close();
                return typefaceCreateFromFile;
            } catch (Throwable th5) {
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        } catch (IOException unused5) {
            return null;
        }
    }

    @Override // defpackage.ak
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (this.G0 != 1) {
            return super.d(context, resources, i, str, i2);
        }
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.ak
    public xu f(int i, xu[] xuVarArr) {
        if (this.G0 != 1) {
            return super.f(i, xuVarArr);
        }
        throw null;
    }
}
