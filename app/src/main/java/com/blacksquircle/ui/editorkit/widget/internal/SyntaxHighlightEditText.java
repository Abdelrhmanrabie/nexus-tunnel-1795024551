package com.blacksquircle.ui.editorkit.widget.internal;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import com.blacksquircle.ui.editorkit.model.FindResultSpan;
import com.blacksquircle.ui.editorkit.model.TabWidthSpan;
import com.blacksquircle.ui.editorkit.utils.EditorTheme;
import com.blacksquircle.ui.language.base.span.SyntaxHighlightSpan;
import defpackage.fb$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class SyntaxHighlightEditText extends UndoRedoEditText {
    public final ArrayList findResultSpans;
    public final ArrayList syntaxHighlightSpans;
    public final int tabWidth;
    public final boolean useSpacesInsteadOfTabs;

    public SyntaxHighlightEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.bd);
    }

    public SyntaxHighlightEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = EditorTheme.$r8$clinit;
        this.useSpacesInsteadOfTabs = true;
        this.tabWidth = 4;
        this.syntaxHighlightSpans = new ArrayList();
        this.findResultSpans = new ArrayList();
    }

    @Override // com.blacksquircle.ui.editorkit.widget.internal.ScrollableEditText, android.widget.TextView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        updateSyntaxHighlighting();
    }

    @Override // com.blacksquircle.ui.editorkit.widget.internal.ScrollableEditText, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateSyntaxHighlighting();
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    public final void updateSyntaxHighlighting() {
        int lineForVertical;
        int lineForVertical2;
        if (getLayout() != null) {
            Layout layout = getLayout();
            int i = 0;
            if (getLayout() == null || getLineHeight() == 0 || (lineForVertical = getLayout().getLineForVertical(getScrollY())) < 0) {
                lineForVertical = 0;
            } else if (lineForVertical >= getLineCount()) {
                lineForVertical = getLineCount() - 1;
            }
            int lineStart = layout.getLineStart(lineForVertical);
            Layout layout2 = getLayout();
            if (getLayout() == null || getLineHeight() == 0) {
                lineForVertical2 = 0;
            } else {
                lineForVertical2 = getLayout().getLineForVertical(getHeight() + getScrollY());
                if (lineForVertical2 < 0) {
                    lineForVertical2 = 0;
                } else if (lineForVertical2 >= getLineCount()) {
                    lineForVertical2 = getLineCount() - 1;
                }
            }
            int lineEnd = layout2.getLineEnd(lineForVertical2);
            SyntaxHighlightSpan[] syntaxHighlightSpanArr = (SyntaxHighlightSpan[]) getText().getSpans(0, getText().length(), SyntaxHighlightSpan.class);
            int length = syntaxHighlightSpanArr.length;
            int i2 = 0;
            while (i2 < length) {
                SyntaxHighlightSpan syntaxHighlightSpan = syntaxHighlightSpanArr[i2];
                i2++;
                getText().removeSpan(null);
            }
            Iterator it = this.syntaxHighlightSpans.iterator();
            if (it.hasNext()) {
                throw fb$1.m(it);
            }
            FindResultSpan[] findResultSpanArr = (FindResultSpan[]) getText().getSpans(0, getText().length(), FindResultSpan.class);
            int length2 = findResultSpanArr.length;
            int i3 = 0;
            while (i3 < length2) {
                FindResultSpan findResultSpan = findResultSpanArr[i3];
                i3++;
                getText().removeSpan(null);
            }
            Iterator it2 = this.findResultSpans.iterator();
            if (it2.hasNext()) {
                throw fb$1.m(it2);
            }
            if (!this.useSpacesInsteadOfTabs) {
                TabWidthSpan[] tabWidthSpanArr = (TabWidthSpan[]) getText().getSpans(0, getText().length(), TabWidthSpan.class);
                int length3 = tabWidthSpanArr.length;
                while (i < length3) {
                    TabWidthSpan tabWidthSpan = tabWidthSpanArr[i];
                    i++;
                    getText().removeSpan(tabWidthSpan);
                }
                Matcher matcher = Pattern.compile("\t").matcher(getText().subSequence(lineStart, lineEnd));
                while (matcher.find()) {
                    int iStart = matcher.start() + lineStart;
                    int iEnd = matcher.end() + lineStart;
                    if (iStart >= 0 && iEnd <= getText().length()) {
                        getText().setSpan(new TabWidthSpan(this.tabWidth), iStart, iEnd, 18);
                    }
                }
            }
            postInvalidate();
        }
    }
}
