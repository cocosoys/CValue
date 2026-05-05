package com.CValue.base;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.JGPlayerMP;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class Base {
    public EntityPlayer entityPlayer;
    public NBTTagCompound entityNbt;
    public final static String RaceName="Base";
    public final static int RaceID=-1;
    //获取玩家6大属性，不包含增幅
    public int[] NBTAttributes;
    //获取玩家6大属性，包含增幅
    public int[] Attributes;

    public Base(EntityPlayer entityPlayer){
        this.entityPlayer=entityPlayer;
    }

    public Base(EntityPlayer entityPlayer,boolean getNBT){
        this.entityPlayer=entityPlayer;
        if(getNBT) {
            connectBaseNBT();
        }
    }

    public void connectBaseNBT(){
        entityNbt=JRMCoreH.nbt(entityPlayer, "pres");
        NBTAttributes=JRMCoreH.PlyrAttrbts(entityPlayer);
        Attributes=getAttributes();
    }

    public NBTTagCompound getEntityNbt(){
        return this.entityNbt;
    }

    //获取玩家6大属性值，包括增幅
    public int[] getAttributes(){
        int[] Attributes=new int[JRMCoreH.AttrbtNbtI.length];
        JGPlayerMP JGPlayer=new JGPlayerMP(this.entityPlayer);
        JGPlayer.connectBaseNBT();
        for (int attribute = 0; attribute < Attributes.length; attribute++) {
            Attributes[attribute]=JGPlayer.getAttribute(attribute);
        }
        return Attributes;
    }

    //获取玩家等级
    public int getLevel(){
        return JRMCoreH.attrLvl(this.NBTAttributes);
    }

    //获取玩家到达下个等级所需升级的属性次数
    public int getLevelNext() {
        if (getLevel() >= JRMCoreH.attrLvl(JRMCoreConfig.tmx * 6)) {
            return 0;
        }
        return JRMCoreH.attrLvlNext(this.NBTAttributes);
    }

    //获取玩家开始游戏的基础属性,0:str,1:dex,2:con,3:wil,4:mnd,5:spi
    public int getStartAttributes(int i) {
        if(i<0 || i>5){
            return 0;
        }
        return JRMCoreH.attributeStart(JRMCoreH.getByte(entityPlayer,"jrmcPwrtyp"), i, JRMCoreH.getByte(entityPlayer,"jrmcRace"),JRMCoreH.getByte(entityPlayer,"jrmcClass"));
    }

    //获取玩家 当前 气的上限
    public int getEnergyMax(){
        byte PowerType=JRMCoreH.getByte(entityPlayer,"jrmcPwrtyp");
        byte Class=JRMCoreH.getByte(entityPlayer,"jrmcClass");
        byte Race=JRMCoreH.getByte(entityPlayer,"jrmcRace");
        return JRMCoreH.stat(entityPlayer,5,PowerType,5,NBTAttributes[5],Race,Class,JRMCoreH.SklLvl_KiBs(entityPlayer, PowerType));
    }

    //基础属性+额外属性,额外属性可通过改变形态或者获得buff提升,0:str,1:dex,2:con(错误值),3:wil,4:mnd(错误值),5:spi(错误值)
    public int getAdditionAttribute(int i) {
        int out=0;
        switch (i){
            case 0:
            case 1:
            case 3:
                out=Attributes[i];
                break;
            case 2:
            case 4:
            case 5:
                out=NBTAttributes[i];
                break;
        }
        return out;
    }

    //获取 玩家 伤害减少 值
    public int getDamageReduction() {
        double per=1;
        byte PowerType=JRMCoreH.getByte(entityPlayer,"jrmcPwrtyp");
        if(PowerType>0 && PowerType!=3) {
            per = (Math.max(Attributes[2], NBTAttributes[2])) / ((double)NBTAttributes[2]);
        }
        return (int) ((1D - 1D / per) * 100D);
    }

    //获取玩家 当前 耐力上限
    public int getMaxStamina() {
        byte PowerType=JRMCoreH.getByte(entityPlayer,"jrmcPwrtyp");
        byte Class=JRMCoreH.getByte(entityPlayer,"jrmcClass");
        byte Race=JRMCoreH.getByte(entityPlayer,"jrmcRace");
        return JRMCoreH.stat(entityPlayer,2,PowerType,3,NBTAttributes[2],Race,Class,0);
    }

    //获取玩家最大血量
    public int getMaxBody() {
        byte PowerType=JRMCoreH.getByte(entityPlayer,"jrmcPwrtyp");
        byte Class=JRMCoreH.getByte(entityPlayer,"jrmcClass");
        byte Race=JRMCoreH.getByte(entityPlayer,"jrmcRace");
        return JRMCoreH.stat(entityPlayer,2,PowerType,2,NBTAttributes[2],Race,Class,0);
    }

    //获取种族形态掌握数值
    public double getRaceFormMastery(){
        int PowerType=JRMCoreH.getInt(entityPlayer,"jrmcPwrtyp");
        if(!JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(PowerType)) {
            return 0;
        }else{
            int Race=JRMCoreH.getInt(entityPlayer,"jrmcRace");
            int State=JRMCoreH.getInt(entityPlayer,"jrmcState");
            int State2=JRMCoreH.getInt(entityPlayer,"jrmcState2");
            boolean isKaiokenOn = hasStatusEffect(5);
            boolean isMysticOn = hasStatusEffect(13);
            boolean isUltraInstinctOn = hasStatusEffect(19);
            boolean isGoDOn = hasStatusEffect(20);
            String FormMasteryData=JRMCoreH.getFormMasteryData(entityPlayer,Race,State,State2,isKaiokenOn,isMysticOn,isUltraInstinctOn,isGoDOn);
            String[] formData=FormMasteryData.split(",");
            if(formData.length>=2) {
                return Double.parseDouble(formData[1]);
            }
            return 0;
        }
    }

    //获取形态掌握值
    public double getFormMasteryValue(String formName){
        int PowerType=JRMCoreH.getInt(entityPlayer,"jrmcPwrtyp");
        int Race=JRMCoreH.getInt(entityPlayer,"jrmcRace");
        if(!JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(PowerType)) {
            return 0;
        }else{
            int FormID = JRMCoreH.getFormID(formName, Race);
            return JRMCoreH.getFormMasteryValue(entityPlayer,FormID);
        }
    }

    //玩家是否拥有某种龙珠buff,有则true,无则false
    public boolean hasStatusEffect(int effectId){
        String StatusEffect=JRMCoreH.getString(entityPlayer,"jrmcStatusEff");
        return StatusEffect.contains(JRMCoreH.StusEfcts[effectId]);
    }

    public int getMelee(){

    }

    public float getNCBonus(){
        int PowerType=JRMCoreH.getInt(entityPlayer,"jrmcPwrtyp");
        float NCBonus = 0F;
        if(JRMCoreH.isPowerTypeChakra(PowerType)){

        }
        return NCBonus;
    }

    public int getStatSPI(){

    }

    public int getSklks(int skillId,double multiple){
        int sklks=0;
        int PowerType=JRMCoreH.getInt(entityPlayer,"jrmcPwrtyp");
        if(JRMCoreH.isPowerTypeKi(PowerType)){
            byte curRelease=JRMCoreH.getByte(entityPlayer,"jrmcRelease");
            sklks=
        }
        return sklks;
    }

    public int getSTRSklks(){

    }

    public int getDEXSklks(){

    }
}
