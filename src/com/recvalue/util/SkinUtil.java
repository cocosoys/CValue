package com.recvalue.util;

import JinRyuu.JRMCore.JRMCoreH;

/**
 * 对 JRMCore 遗留 DNS/外观字符串格式的包装器。
 * Wrapper around the legacy DNS/skin string format used by JRMCore.
 *
 * <p>这个辅助类提供对编码外观字符串的小型读写操作，
 * 避免调用方直接处理字符偏移。
 * This helper exposes small read/write operations on the encoded appearance
 * string without forcing callers to manage raw character offsets directly.</p>
 */
public class SkinUtil {
    /**
     * 原始 DNS/外观字符串。
     * Raw DNS/skin string.
     */
    public String str;

    /**
     * 为一个编码外观字符串创建辅助器。
     * Creates a helper for one encoded appearance string.
     */
    public SkinUtil(String str) {
        this.str = (str == null) ? "" : str;
    }

    /**
     * 读取字符串中编码的种族值。
     * Reads the race value encoded in the skin string.
     */
    public int getRace() {
        return JRMCoreH.dnsRace(this.str);
    }

    /**
     * 把种族值写回外观字符串。
     * Writes the race value back into the skin string.
     */
    public String setRace(int type) {
        return replaceSpan(0, 2, JRMCoreH.numToLet(type));
    }

    /**
     * 读取字符串中编码的性别值。
     * Reads the gender value encoded in the skin string.
     */
    public int getGender() {
        return JRMCoreH.dnsGender(this.str);
    }

    /**
     * 把性别值写回外观字符串。
     * Writes the gender value back into the skin string.
     */
    public String setGender(String type) {
        return JRMCoreH.dnsGenderSet(this.str, type);
    }

    /**
     * 读取主发型值。
     * Reads the primary hair style value.
     */
    public int getHairB() {
        return JRMCoreH.dnsHairB(this.str);
    }

    /**
     * 写入主发型值。
     * Writes the primary hair style value.
     */
    public String setHairB(int type) {
        return JRMCoreH.dnsHairBSet(this.str, type);
    }

    /**
     * 读取副发型值。
     * Reads the secondary hair style value.
     */
    public int getHairF() {
        return JRMCoreH.dnsHairF(this.str);
    }

    /**
     * 写入副发型值。
     * Writes the secondary hair style value.
     */
    public String setHairF(int type) {
        return JRMCoreH.dnsHairFSet(this.str, type);
    }

    /**
     * 读取发色值。
     * Reads the hair color value.
     */
    public int getHairC() {
        return JRMCoreH.dnsHairC(this.str);
    }

    /**
     * 写入发色值。
     * Writes the hair color value.
     */
    public String setHairC(int color) {
        return JRMCoreH.dnsHairCSet(this.str, color);
    }

    /**
     * 读取胸围值。
     * Reads the breast-size value.
     */
    public int getBreast() {
        return JRMCoreH.dnsBreast(this.str);
    }

    /**
     * 写入胸围值。
     * Writes the breast-size value.
     */
    public String setBreast(int count) {
        return replaceChar(12, Integer.toString(count));
    }

    /**
     * 读取皮肤类型值。
     * Reads the skin-type value.
     */
    public int getSkinT() {
        return JRMCoreH.dnsSkinT(this.str);
    }

    /**
     * 写入皮肤类型值。
     * Writes the skin-type value.
     */
    public String setSkinT(int type) {
        return replaceChar(13, Integer.toString(type));
    }

    /**
     * 读取体型值。
     * Reads the body-type value.
     */
    public int getBodyT() {
        return JRMCoreH.dnsBodyT(this.str);
    }

    /**
     * 写入体型值。
     * Writes the body-type value.
     */
    public String setBodyT(int type) {
        return replaceSpan(14, 2, JRMCoreH.numToLet(type));
    }

    /**
     * 读取主身体颜色值。
     * Reads the main body color value.
     */
    public int getBodyCM() {
        return JRMCoreH.dnsBodyCM(this.str);
    }

    /**
     * 写入主身体颜色值。
     * Writes the main body color value.
     */
    public String setBodyCM(int color) {
        return replaceSpan(16, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 读取第一附加身体颜色值。
     * Reads the first extra body color value.
     */
    public int getBodyC1() {
        return JRMCoreH.dnsBodyC1(this.str);
    }

    /**
     * 写入第一附加身体颜色值。
     * Writes the first extra body color value.
     */
    public String setBodyC1(int color) {
        return replaceSpan(21, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 读取第二附加身体颜色值。
     * Reads the second extra body color value.
     */
    public int getBodyC2() {
        return JRMCoreH.dnsBodyC2(this.str);
    }

    /**
     * 写入第二附加身体颜色值。
     * Writes the second extra body color value.
     */
    public String setBodyC2(int color) {
        return replaceSpan(26, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 读取第三附加身体颜色值。
     * Reads the third extra body color value.
     */
    public int getBodyC3() {
        return JRMCoreH.dnsBodyC3(this.str);
    }

    /**
     * 写入第三附加身体颜色值。
     * Writes the third extra body color value.
     */
    public String setBodyC3(int color) {
        return replaceSpan(31, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 读取鼻子样式值。
     * Reads the nose style value.
     */
    public int getFaceN() {
        return JRMCoreH.dnsFaceN(this.str);
    }

    /**
     * 写入鼻子样式值。
     * Writes the nose style value.
     */
    public String setFaceN(int type) {
        return replaceSpan(36, 2, JRMCoreH.numToLet(type));
    }

    /**
     * 读取嘴部样式值。
     * Reads the mouth style value.
     */
    public int getFaceM() {
        return JRMCoreH.dnsFaceM(this.str);
    }

    /**
     * 写入嘴部样式值。
     * Writes the mouth style value.
     */
    public String setFaceM(int type) {
        return replaceSpan(38, 2, JRMCoreH.numToLet(type));
    }

    /**
     * 读取眼睛样式值。
     * Reads the eye style value.
     */
    public int getEyes() {
        return JRMCoreH.dnsEyes(this.str);
    }

    /**
     * 写入眼睛样式值。
     * Writes the eye style value.
     */
    public String setEyes(int type) {
        return replaceSpan(40, 2, JRMCoreH.numToLet(type));
    }

    /**
     * 读取左眼颜色值。
     * Reads the left-eye color value.
     */
    public int getEyesC1() {
        return JRMCoreH.dnsEyeC1(this.str);
    }

    /**
     * 写入左眼颜色值。
     * Writes the left-eye color value.
     */
    public String setEyesC1(int color) {
        return replaceSpan(42, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 读取右眼颜色值。
     * Reads the right-eye color value.
     */
    public int getEyesC2() {
        return JRMCoreH.dnsEyeC2(this.str);
    }

    /**
     * 写入右眼颜色值。
     * Writes the right-eye color value.
     */
    public String setEyesC2(int color) {
        return replaceSpan(47, 5, JRMCoreH.numToLet5(color));
    }

    /**
     * 为保持源码兼容而保留的空日志钩子。
     * Legacy no-op logger hook kept for source compatibility.
     */
    public String log(String value) {
        return value;
    }

    /**
     * 在底层外观字符串中替换单个字符。
     * Replaces one character in the backing skin string.
     */
    private String replaceChar(int index, String replacement) {
        if (replacement == null || replacement.isEmpty()) {
            return this.str;
        }
        if (this.str.length() <= index) {
            return this.str;
        }
        return this.str.substring(0, index) + replacement + this.str.substring(index + 1);
    }

    /**
     * 在底层外观字符串中替换固定宽度的一段内容。
     * Replaces a fixed-width span in the backing skin string.
     */
    private String replaceSpan(int start, int length, String replacement) {
        if (replacement == null) {
            return this.str;
        }
        if (this.str.length() < start + length) {
            return this.str;
        }
        return this.str.substring(0, start) + replacement + this.str.substring(start + length);
    }
}
