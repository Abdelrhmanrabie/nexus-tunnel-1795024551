package com.blacksquircle.ui.language.base.model;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ColorScheme {
    public final int attrNameColor;
    public final int attrValueColor;
    public final int backgroundColor;
    public final int commentColor;
    public final int delimiterBackgroundColor;
    public final int entityRefColor;
    public final int findResultBackgroundColor;
    public final int gutterColor;
    public final int gutterCurrentLineNumberColor;
    public final int gutterDividerColor;
    public final int gutterTextColor;
    public final int keywordColor;
    public final int langConstColor;
    public final int methodColor;
    public final int numberColor;
    public final int operatorColor;
    public final int preprocessorColor;
    public final int selectedLineColor;
    public final int selectionColor;
    public final int stringColor;
    public final int suggestionQueryColor;
    public final int tagColor;
    public final int tagNameColor;
    public final int textColor;
    public final int typeColor;
    public final int variableColor;

    public ColorScheme(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26) {
        this.textColor = i;
        this.backgroundColor = i2;
        this.gutterColor = i3;
        this.gutterDividerColor = i4;
        this.gutterCurrentLineNumberColor = i5;
        this.gutterTextColor = i6;
        this.selectedLineColor = i7;
        this.selectionColor = i8;
        this.suggestionQueryColor = i9;
        this.findResultBackgroundColor = i10;
        this.delimiterBackgroundColor = i11;
        this.numberColor = i12;
        this.operatorColor = i13;
        this.keywordColor = i14;
        this.typeColor = i15;
        this.langConstColor = i16;
        this.preprocessorColor = i17;
        this.variableColor = i18;
        this.methodColor = i19;
        this.stringColor = i20;
        this.commentColor = i21;
        this.tagColor = i22;
        this.tagNameColor = i23;
        this.attrNameColor = i24;
        this.attrValueColor = i25;
        this.entityRefColor = i26;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) obj;
        return this.textColor == colorScheme.textColor && this.backgroundColor == colorScheme.backgroundColor && this.gutterColor == colorScheme.gutterColor && this.gutterDividerColor == colorScheme.gutterDividerColor && this.gutterCurrentLineNumberColor == colorScheme.gutterCurrentLineNumberColor && this.gutterTextColor == colorScheme.gutterTextColor && this.selectedLineColor == colorScheme.selectedLineColor && this.selectionColor == colorScheme.selectionColor && this.suggestionQueryColor == colorScheme.suggestionQueryColor && this.findResultBackgroundColor == colorScheme.findResultBackgroundColor && this.delimiterBackgroundColor == colorScheme.delimiterBackgroundColor && this.numberColor == colorScheme.numberColor && this.operatorColor == colorScheme.operatorColor && this.keywordColor == colorScheme.keywordColor && this.typeColor == colorScheme.typeColor && this.langConstColor == colorScheme.langConstColor && this.preprocessorColor == colorScheme.preprocessorColor && this.variableColor == colorScheme.variableColor && this.methodColor == colorScheme.methodColor && this.stringColor == colorScheme.stringColor && this.commentColor == colorScheme.commentColor && this.tagColor == colorScheme.tagColor && this.tagNameColor == colorScheme.tagNameColor && this.attrNameColor == colorScheme.attrNameColor && this.attrValueColor == colorScheme.attrValueColor && this.entityRefColor == colorScheme.entityRefColor;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((this.textColor * 31) + this.backgroundColor) * 31) + this.gutterColor) * 31) + this.gutterDividerColor) * 31) + this.gutterCurrentLineNumberColor) * 31) + this.gutterTextColor) * 31) + this.selectedLineColor) * 31) + this.selectionColor) * 31) + this.suggestionQueryColor) * 31) + this.findResultBackgroundColor) * 31) + this.delimiterBackgroundColor) * 31) + this.numberColor) * 31) + this.operatorColor) * 31) + this.keywordColor) * 31) + this.typeColor) * 31) + this.langConstColor) * 31) + this.preprocessorColor) * 31) + this.variableColor) * 31) + this.methodColor) * 31) + this.stringColor) * 31) + this.commentColor) * 31) + this.tagColor) * 31) + this.tagNameColor) * 31) + this.attrNameColor) * 31) + this.attrValueColor) * 31) + this.entityRefColor;
    }

    public final String toString() {
        return "ColorScheme(textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", gutterColor=" + this.gutterColor + ", gutterDividerColor=" + this.gutterDividerColor + ", gutterCurrentLineNumberColor=" + this.gutterCurrentLineNumberColor + ", gutterTextColor=" + this.gutterTextColor + ", selectedLineColor=" + this.selectedLineColor + ", selectionColor=" + this.selectionColor + ", suggestionQueryColor=" + this.suggestionQueryColor + ", findResultBackgroundColor=" + this.findResultBackgroundColor + ", delimiterBackgroundColor=" + this.delimiterBackgroundColor + ", numberColor=" + this.numberColor + ", operatorColor=" + this.operatorColor + ", keywordColor=" + this.keywordColor + ", typeColor=" + this.typeColor + ", langConstColor=" + this.langConstColor + ", preprocessorColor=" + this.preprocessorColor + ", variableColor=" + this.variableColor + ", methodColor=" + this.methodColor + ", stringColor=" + this.stringColor + ", commentColor=" + this.commentColor + ", tagColor=" + this.tagColor + ", tagNameColor=" + this.tagNameColor + ", attrNameColor=" + this.attrNameColor + ", attrValueColor=" + this.attrValueColor + ", entityRefColor=" + this.entityRefColor + ')';
    }
}
