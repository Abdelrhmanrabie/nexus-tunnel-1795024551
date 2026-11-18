package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.h;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l41 extends MenuInflater {
    public static final Class[] e;
    public static final Class[] f;
    public final Object[] a;
    public final Object[] b;
    public final Context c;
    public Object d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public CharSequence A;
        public CharSequence B;
        public final Menu a;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public hh0.b z;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;
        public int b = 0;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public boolean f = true;
        public boolean g = true;

        public b(Menu menu) {
            this.a = menu;
        }

        public final void a(MenuItem menuItem) {
            Object objNewInstance;
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            String str = this.y;
            l41 l41Var = l41.this;
            Context context = l41Var.c;
            if (str != null) {
                if (context.isRestricted()) {
                    d.AnonymousClass0.m("The android:onClick attribute cannot be used within a restricted context");
                    return;
                } else {
                    if (l41Var.d == null) {
                        l41Var.d = l41.a(context);
                    }
                    menuItem.setOnMenuItemClickListener(new hh0.e(this.y, l41Var.d));
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).f(true);
                } else if (menuItem instanceof hh0) {
                    hh0 hh0Var = (hh0) menuItem;
                    try {
                        Method method = hh0Var.e;
                        m41 m41Var = hh0Var.d;
                        if (method == null) {
                            hh0Var.e = m41Var.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        hh0Var.e.invoke(m41Var, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            }
            String str2 = this.x;
            if (str2 != null) {
                Class<?>[] clsArr = l41.e;
                Object[] objArr = l41Var.a;
                try {
                    Constructor<?> constructor = Class.forName(str2, false, context.getClassLoader()).getConstructor(clsArr);
                    constructor.setAccessible(true);
                    objNewInstance = constructor.newInstance(objArr);
                } catch (Exception unused2) {
                    objNewInstance = null;
                }
                menuItem.setActionView((View) objNewInstance);
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0 && !z) {
                menuItem.setActionView(i2);
            }
            hh0.b bVar = this.z;
            if (bVar != null && (menuItem instanceof m41)) {
                ((m41) menuItem).a(bVar);
            }
            CharSequence charSequence = this.A;
            boolean z2 = menuItem instanceof m41;
            if (z2) {
                ((m41) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.B;
            if (z2) {
                ((m41) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.n;
            int i3 = this.o;
            if (z2) {
                ((m41) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i3);
            }
            char c2 = this.p;
            int i4 = this.q;
            if (z2) {
                ((m41) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i4);
            }
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                if (z2) {
                    ((m41) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                if (z2) {
                    ((m41) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public l41(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r16v0, types: [l41] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v30, types: [int] */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        ?? r5;
        XmlResourceParser xmlResourceParser2;
        ?? r13;
        hh0.b bVar;
        ColorStateList colorStateList;
        Object objNewInstance;
        MenuItem menuItemAdd;
        b bVar2 = new b(menu);
        int eventType = xmlResourceParser.getEventType();
        do {
            i = 2;
            r5 = 1;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
                break;
            }
            eventType = xmlResourceParser.next();
        } while (eventType != 1);
        ?? r9 = 0;
        boolean z = false;
        String str = null;
        while (r9 == 0) {
            if (eventType == r5) {
                throw new RuntimeException("Unexpected end of document");
            }
            Menu menu2 = bVar2.a;
            if (eventType == i) {
                if (!z) {
                    String name2 = xmlResourceParser.getName();
                    boolean zEquals = name2.equals("group");
                    l41 l41Var = l41.this;
                    Context context = l41Var.c;
                    if (zEquals) {
                        ?? ObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.q);
                        bVar2.b = ObtainStyledAttributes.getResourceId(r5, 0);
                        bVar2.c = ObtainStyledAttributes.getInt(3, 0);
                        bVar2.d = ObtainStyledAttributes.getInt(4, 0);
                        bVar2.e = ObtainStyledAttributes.getInt(5, 0);
                        bVar2.f = ObtainStyledAttributes.getBoolean(2, r5);
                        bVar2.g = ObtainStyledAttributes.getBoolean(0, r5);
                        ObtainStyledAttributes.recycle();
                        r9 = r9;
                    } else if (name2.equals("item")) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.r);
                        m6 m6Var = new m6(context, typedArrayObtainStyledAttributes);
                        bVar2.i = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                        bVar2.j = (typedArrayObtainStyledAttributes.getInt(6, bVar2.d) & 65535) | (typedArrayObtainStyledAttributes.getInt(5, bVar2.c) & (-65536));
                        bVar2.k = typedArrayObtainStyledAttributes.getText(7);
                        bVar2.l = typedArrayObtainStyledAttributes.getText(8);
                        bVar2.m = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                        String string = typedArrayObtainStyledAttributes.getString(9);
                        bVar2.n = string == null ? (char) 0 : string.charAt(0);
                        bVar2.o = typedArrayObtainStyledAttributes.getInt(16, 4096);
                        String string2 = typedArrayObtainStyledAttributes.getString(10);
                        bVar2.p = string2 == null ? (char) 0 : string2.charAt(0);
                        bVar2.q = typedArrayObtainStyledAttributes.getInt(20, 4096);
                        bVar2.r = typedArrayObtainStyledAttributes.hasValue(11) ? typedArrayObtainStyledAttributes.getBoolean(11, false) : bVar2.e;
                        bVar2.s = typedArrayObtainStyledAttributes.getBoolean(3, false);
                        bVar2.t = typedArrayObtainStyledAttributes.getBoolean(4, bVar2.f);
                        bVar2.u = typedArrayObtainStyledAttributes.getBoolean(1, bVar2.g);
                        bVar2.v = typedArrayObtainStyledAttributes.getInt(21, -1);
                        bVar2.y = typedArrayObtainStyledAttributes.getString(12);
                        bVar2.w = typedArrayObtainStyledAttributes.getResourceId(13, 0);
                        bVar2.x = typedArrayObtainStyledAttributes.getString(15);
                        String string3 = typedArrayObtainStyledAttributes.getString(14);
                        if (string3 != null && bVar2.w == 0 && bVar2.x == null) {
                            Class<?>[] clsArr = f;
                            Object[] objArr = l41Var.b;
                            try {
                                Constructor<?> constructor = Class.forName(string3, false, context.getClassLoader()).getConstructor(clsArr);
                                constructor.setAccessible(true);
                                objNewInstance = constructor.newInstance(objArr);
                            } catch (Exception unused) {
                                objNewInstance = null;
                            }
                            bVar = (hh0.b) objNewInstance;
                        } else {
                            bVar = null;
                        }
                        bVar2.z = bVar;
                        bVar2.A = typedArrayObtainStyledAttributes.getText(17);
                        bVar2.B = typedArrayObtainStyledAttributes.getText(22);
                        if (typedArrayObtainStyledAttributes.hasValue(19)) {
                            bVar2.D = fp.d(typedArrayObtainStyledAttributes.getInt(19, -1), bVar2.D);
                            colorStateList = null;
                        } else {
                            colorStateList = null;
                            bVar2.D = null;
                        }
                        if (typedArrayObtainStyledAttributes.hasValue(18)) {
                            bVar2.C = m6Var.b(18);
                        } else {
                            bVar2.C = colorStateList;
                        }
                        m6Var.n();
                        bVar2.h = false;
                        xmlResourceParser2 = xmlResourceParser;
                        r13 = 1;
                    } else if (name2.equals("menu")) {
                        r13 = 1;
                        bVar2.h = true;
                        SubMenu subMenuAddSubMenu = menu2.addSubMenu(bVar2.b, bVar2.i, bVar2.j, bVar2.k);
                        bVar2.a(subMenuAddSubMenu.getItem());
                        xmlResourceParser2 = xmlResourceParser;
                        b(xmlResourceParser2, attributeSet, subMenuAddSubMenu);
                    } else {
                        xmlResourceParser2 = xmlResourceParser;
                        r13 = 1;
                        str = name2;
                        z = true;
                    }
                }
                eventType = xmlResourceParser2.next();
                r5 = r13;
                i = 2;
                r9 = r9;
            } else if (eventType == 3) {
                String name3 = xmlResourceParser.getName();
                if (z && name3.equals(str)) {
                    z = false;
                    str = null;
                    r9 = r9;
                } else if (name3.equals("group")) {
                    bVar2.b = 0;
                    bVar2.c = 0;
                    bVar2.d = 0;
                    bVar2.e = 0;
                    bVar2.f = r5;
                    bVar2.g = r5;
                    r9 = r9;
                } else if (name3.equals("item")) {
                    if (!bVar2.h) {
                        hh0.b bVar3 = bVar2.z;
                        if (bVar3 == null || !bVar3.a.hasSubMenu()) {
                            r9 = r9;
                            r9 = r9;
                            bVar2.h = r5;
                            menuItemAdd = menu2.add(bVar2.b, bVar2.i, bVar2.j, bVar2.k);
                        } else {
                            r9 = r9;
                            bVar2.h = r5;
                            menuItemAdd = menu2.addSubMenu(bVar2.b, bVar2.i, bVar2.j, bVar2.k).getItem();
                        }
                        bVar2.a(menuItemAdd);
                        r9 = r9;
                    }
                } else if (name3.equals("menu")) {
                    r9 = r9;
                    r9 = r5;
                }
            }
            r9 = r9;
            r9 = r9;
            r13 = r5;
            xmlResourceParser2 = xmlResourceParser;
            eventType = xmlResourceParser2.next();
            r5 = r13;
            i = 2;
            r9 = r9;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof k41)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.c.getResources().getLayout(i);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
