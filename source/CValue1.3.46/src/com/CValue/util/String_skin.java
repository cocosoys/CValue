package com.CValue.util;

import JinRyuu.JRMCore.JRMCoreH;

public class String_skin {
    public String str;

    public String_skin(String str){
        log("填入nbt中 jrmcDNS 获取出的字符串,用于分析玩家外貌");
        this.str=str;
    }

    public int getRace(){
        log("获取种族,0:人类,1:赛亚人,2:混血赛亚人,3:那美克星人,4:冰冻恶魔");
        return JRMCoreH.dnsRace(this.str);
    }

    public String setRace(int type){
        log("设置种族,0:人类,1:赛亚人,2:混血赛亚人,3:那美克星人,4:冰冻恶魔");
        int i = 0;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i+1) + type + this.str.substring(i + 2)) : "0";
    }

    public int getGender(){
        log("获取性别,0:男性,1:女性,那美克星人没有性别");
        return JRMCoreH.dnsGender(this.str);
    }

    public String setGender(String type){
        log("设置性别,0:男性,1:女性,那美克星人没有性别");
        return JRMCoreH.dnsGenderSet(this.str, type);
    }

    public int getHairB(){
        log("获取发型,0-9:发型1-10,10:发型11,11:发型12,12:自定义发型,仅人类/赛亚人/混血赛亚人有发型");
        return JRMCoreH.dnsHairB(this.str);
    }

    public String setHairB(int type){
        log("设置发型,0-9:发型1-10,10:发型11,11:发型12,12:自定义发型,仅人类/赛亚人/混血赛亚人有发型");
        return JRMCoreH.dnsHairBSet(this.str,type);
    }

    public  int getHairF(){
        log("获取发型2,未知作用");
        return JRMCoreH.dnsHairF(this.str);
    }

    public String setHairF(int type){
        log("设置发型2,未知作用");
        return JRMCoreH.dnsHairFSet(this.str,type);
    }

    public int getHairC(){
        log("获取发色,赛亚人/那美克星人/冰冻恶魔无法使用");
        return JRMCoreH.dnsHairC(this.str);
    }

    public String setHairC(int color){
        log("设置发色,赛亚人/那美克星人/冰冻恶魔无法使用");
        return JRMCoreH.dnsHairCSet(this.str,color);
    }

    public int getBreast(){
        log("获取胸部大小,仅可0-9,仅女性");
        return JRMCoreH.dnsBreast(this.str);
    }

    public String setBreast(int count){
        log("设置胸部大小,仅可0-9,仅女性");
        int i = 12;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i) + count + this.str.substring(i + 1)) : "0";
    }

    public int getSkinT(){
        log("获取皮肤类型,0:默认皮肤,1:自定义皮肤");
        return JRMCoreH.dnsSkinT(this.str);
    }

    public String setSkinT(int type){
        log("设置皮肤类型,0:默认皮肤,1:自定义皮肤");
        int i = 13;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i) + type + this.str.substring(i + 1)) : "0";
    }

    public int getBodyT(){
        log("获取体格,仅自定义皮肤,那美克星人/冰冻恶魔0-2,其余为0");
        return JRMCoreH.dnsBodyT(this.str);
    }

    public String setBodyT(int type){
        log("设置体格,仅自定义皮肤,那美克星人/冰冻恶魔0-2,其余为0");
        int i = 14;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i+1) + type + this.str.substring(i + 2)) : "0";
    }

    public int getBodyCM(){
        log("获取皮肤颜色,仅自定义皮肤,人类与赛亚人只有一个");
        return JRMCoreH.dnsBodyCM(this.str);
    }

    public String setBodyCM(int color){
        log("设置皮肤颜色,仅自定义皮肤,人类与赛亚人只有一个");
        int i = 16;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }

    public int getBodyC1(){
        log("获取皮肤颜色列表1,仅自定义皮肤,混血赛亚人有两个");
        return JRMCoreH.dnsBodyC1(this.str);
    }

    public String setBodyC1(int color){
        log("设置皮肤颜色列表1,仅自定义皮肤,混血赛亚人有两个");
        int i = 21;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }

    public int getBodyC2(){
        log("获取皮肤颜色列表2,仅自定义皮肤,那美克星人有三个");
        return JRMCoreH.dnsBodyC2(this.str);
    }

    public String setBodyC2(int color){
        log("设置皮肤颜色列表2,仅自定义皮肤,那美克星人有三个");
        int i = 26;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }

    public int getBodyC3(){
        log("获取皮肤颜色列表3,仅自定义皮肤,冰冻恶魔有四个");
        return JRMCoreH.dnsBodyC3(this.str);
    }

    public String setBodyC3(int color){
        log("设置皮肤颜色列表3,仅自定义皮肤,冰冻恶魔有四个");
        int i = 31;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }

    public int getFaceN(){
        log("获取鼻子类型,仅自定义皮肤,仅可0-4");
        return JRMCoreH.dnsFaceN(this.str);
    }

    public String setFaceN(int type){
        log("设置鼻子类型,仅自定义皮肤,仅可0-4");
        int i = 36;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i+1) + type + this.str.substring(i + 2)) : "0";
    }

    public int getFaceM(){
        log("获取嘴巴类型,仅自定义皮肤,仅可0-4");
        return JRMCoreH.dnsFaceM(this.str);
    }

    public String setFaceM(int type){
        log("设置嘴巴类型,仅自定义皮肤,仅可0-4");
        int i = 38;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i+1) + type + this.str.substring(i + 2)) : "0";
    }

    public int getEyes(){
        log("获取眼睛类型,仅自定义皮肤,仅可0-5");
        return JRMCoreH.dnsEyes(this.str);
    }

    public String setEyes(int type){
        log("设置眼睛类型,仅自定义皮肤,仅可0-5");
        int i = 40;
        return (this.str != null && this.str.length() > i) ? (this.str.substring(0, i+1) + type + this.str.substring(i + 2)) : "0";
    }

    public int getEyesC1(){
        log("获取左眼颜色,仅自定义皮肤,赛亚人无法使用");
        return JRMCoreH.dnsEyeC1(this.str);
    }

    public String setEyesC1(int color){
        log("设置左眼颜色,仅自定义皮肤,赛亚人无法使用");
        int i = 42;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }

    public int getEyesC2(){
        log("获取右眼颜色,仅自定义皮肤,赛亚人无法使用");
        return JRMCoreH.dnsEyeC2(this.str);
    }

    public String setEyesC2(int color){
        log("设置右眼颜色,仅自定义皮肤,赛亚人无法使用");
        int i = 47;
        return (this.str != null && this.str.length() > i+6) ? (this.str.substring(0, i) + JRMCoreH.numToLet5(color) + this.str.substring(i + 5)) : "0";
    }


    public String log(String str){return "该函数没有实际效果,仅仅用于标注各个函数的用法";}
}
