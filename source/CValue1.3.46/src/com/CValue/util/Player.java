package com.CValue.util;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import com.CValue.base.Base;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class Player {
    public EntityPlayer player;

    public byte pwr;

    public byte rce;

    public byte cls;

    public int[] PlyrAttrbts;

    public int[] NBTPlyrAttrbts;

    public byte st;

    public NBTTagCompound nbt;

    public byte st2;

    public String sX;

    public byte cr;

    public int sta;

    public int resrv;

    public String buff;

    public String[] PlyrSkills;

    public byte Diff;

    public byte Align;

    public String MissionSyncData;

    public String[] StatusEffect;

    public String[] StatusEffectName;

    public int RevTmr;

    public int TPint;

    public int CurBody;

    public int Karma;

    public int KllCG;

    public int KllCN;

    public int KllCE;

    public int total;

    public int LastDamageDealt;

    public int LastDamageReceived;

    public String LastAttacker;

    public byte alive;

    public byte Tm;

    //public JGPlayerMP jgplayer;

    public Base baseRace;

    public Player(EntityPlayer player) {
        //this.jgplayer=new JGPlayerMP(player);
        //jgplayer.connectBaseNBT();
        this.baseRace=Util.getRacePlayerNBT(player);
        this.StatusEffect=JRMCoreH.StusEfcts;
        this.StatusEffectName=new String[this.StatusEffect.length];

        String[] NameList=new String[]{"", "进化", "", "暴气", "集气", "界王拳集气", "飞行", "夜晚", "", "", "", "魔化", "神秘形态", "传说中的赛亚人", "", "", "", "红桃", "", "自在极意功(不完美)"};
        System.arraycopy(NameList, 0, StatusEffectName, 0, NameList.length);

        log("玩家实例");
        this.player = player;

        NBTTagCompound nbt = JRMCoreH.nbt(this.player, "pres");
        log("玩家龙珠nbt");
        this.nbt = nbt;

        log("玩家6大属性值,包含增幅");
        this.PlyrAttrbts = baseRace.Attributes;

        log("玩家6大属性值,不包含增幅");
        this.NBTPlyrAttrbts = baseRace.NBTAttributes;

        log("力量类型");
        this.pwr = nbt.func_74771_c("jrmcPwrtyp");

        log("种族");
        this.rce = nbt.func_74771_c("jrmcRace");

        log("职业");
        this.cls = nbt.func_74771_c("jrmcClass");

        log("形态");
        this.st = nbt.func_74771_c("jrmcState");

        log("界王拳等级");
        this.st2 = nbt.func_74771_c("jrmcState2");

        log("种族天赋");
        this.sX = nbt.func_74779_i("jrmcSSltX");

        log("力量释放");
        this.cr = nbt.func_74771_c("jrmcRelease");

        log("耐力");
        this.sta = nbt.func_74762_e("jrmcStamina");

        log("额外气,冰冻恶魔专属");
        this.resrv = nbt.func_74762_e("jrmcArcRsrv");

        log("buff列表");
        this.buff = nbt.func_74779_i("jrmcStatusEff");

        log("技能列表");
        this.PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");

        log("难度");
        this.Diff = nbt.func_74771_c("jrmcDiff");

        log("玩家阵营点数");
        this.Align = nbt.func_74771_c("jrmcAlign");

        log("玩家任务");
        this.MissionSyncData = nbt.func_74779_i("JRMCmissionSync");

        log("剩余复活时间,复活时间*5=剩余复活秒数");
        this.RevTmr = nbt.func_74762_e("jrmcReviveTmer");

        log("玩家的技能点数");
        this.TPint = nbt.func_74762_e("jrmcTpint");

        log("玩家的血量");
        this.CurBody = nbt.func_74762_e("jrmcBdy");

        log("恶业值");
        this.Karma = nbt.func_74762_e("jrmcKarma");

        log("友好杀敌数");
        this.KllCG = nbt.func_74762_e("jrmcKillCountGood");

        log("中立杀敌数");
        this.KllCN = nbt.func_74762_e("jrmcKillCountNeut");

        log("敌对杀敌数");
        this.KllCE = nbt.func_74762_e("jrmcKillCountEvil");

        log("综合杀敌数");
        this.total = this.KllCG + this.KllCN + this.KllCE;

        log("上一次造成的伤害");
        this.LastDamageDealt = nbt.func_74762_e("jrmcLastDamageDealt");

        log("上一次受到的伤害");
        this.LastDamageReceived = nbt.func_74762_e("jrmcLastDamageReceived");

        log("上一次攻击玩家的名字以及攻击时间");
        this.LastAttacker = nbt.func_74779_i("jrmcLastAttacker");

        log("玩家是否活着,0为活着,1为死亡");
        this.alive = nbt.func_74771_c("jrmcAlv");

        log("玩家是否开启尾巴,-1为无尾巴,0为开启尾巴,1为关闭尾巴");
        this.Tm = nbt.func_74771_c("jrmcTlmd");
    }

    public int getMaxBody() {
        log("获取玩家最大血量");
        return baseRace.getMaxBody();
        //return jgplayer.getHealthMax(this.rce,this.cls,this.pwr,this.PlyrAttrbts);
    }

    public int getLevel() {
        log("获取玩家等级");
        return baseRace.getLevel();
    }

    public int getLevelNext() {
        log("获取玩家到达下个等级所需升级的属性次数");
        return baseRace.getLevelNext();
    }

    public int getMaxStamina() {
        log("获取玩家 当前 耐力上限");
        return baseRace.getMaxStamina();
        //return jgplayer.getStaminaMax(this.rce,this.cls,this.pwr,this.PlyrAttrbts);
    }

    public int getBodyStrength() {
        log("获取玩家 当前 身体强度");
        return getcurAtr(1);
    }

    public int getMaxBodyStrength() {
        log("获取玩家 当前 最大身体强度");
        return stat(1);
        //return JRMCoreH.stat(this.player, 1, this.PlyrAttrbts[1], 0.0F);
    }

    public int getPassive() {
        log("获取玩家 当前 被动数值");
        return (int) (getBodyStrength() * JRMCoreConfig.StatPasDef * 0.01F);
    }

    public int getKiPower() {
        log("获取玩家 当前 气的伤害");
        return (int) (getMaxKiPower() * 0.01D * this.cr);
    }

    public int getMaxKiPower() {
        log("获取玩家 当前 最大气的伤害");
        return JRMCoreH.stat(this.player,3,this.pwr, 4, getAdd_Att(3), this.rce, this.cls, 0.0F);
        //return JRMCoreH.stat(this.pwr, 4, this.PlyrAttrbts[3], this.rce, this.cls, 0.0F);
    }

    public int getMaxKi() {
        log("获取玩家 当前 气的上限");
        return baseRace.getEnergyMax();
        //return jgplayer.getEnergyMax(this.rce,this.cls,this.pwr,this.PlyrAttrbts,JRMCoreH.SklLvl_KiBs(this.player, this.pwr));
    }

    public int getRunning() {
        log("获取玩家 当前 奔跑速度");
        return ((int) (JRMCoreH.spdFrm(this.PlyrAttrbts[1], SklLvlC((this.pwr == 1) ? 2 : 0, (this.pwr == 1) ? JRMCoreH.DBCSkillsIDs : JRMCoreH.NCSkillIDs), 100.0F, true, false, getSt1(), this.st2, getInc(7)) * 100.0F))-2;
    }

    public int getFlying() {
        log("获取玩家 当前 飞行速度");
        int i=3-(SklLvl(3)%2);
        i=SklLvl(3)==0?i+1:SklLvl(3)==5?i-1:i;
        return ((int) (JRMCoreH.spdFrm(this.NBTPlyrAttrbts[4], SklLvlC(3, JRMCoreH.DBCSkillsIDs), 100.0F, true, true, getSt1(), this.st2, getInc(11)) * 100.0F))-i;
    }

    public String getDBCTaskID() throws Exception {
        log("获取主线任务id");
        return getTask("mainDBC")[1];
    }

    public String getDBCTaskPage() throws Exception {
        log("获取玩家当前主线任务 的 剧情页数,如:点击'下一页'会增加1");
        log("建议使用任务剧情页数判断 是否有 任务目标");
        return getTask("mainDBC")[2];
    }

    public String getDBCTaskTarget(int i) throws Exception {
        log("获取玩家当前主线任务 目标,i可以为-1以上的数字");
        log("如:mainDBC,1,1,5中,5为任务目标1,也可有更多任务目标");
        log("使用时请根据任务目标数量填写参数,否则报错!");
        if ((getTask("mainDBC")).length < 4 + i)
            throw new Exception("任务目标超出上限!该任务 目前 仅有 " + ((getTask("mainDBC")).length - 3) + " 个任务目标");
        return getTask("mainDBC")[3 + i];
    }

    public String[] getTask(String type) throws Exception {
        log("获取所有类型任务数组,type中填入任务类型,mainDBC为龙珠主线,mainNC为支线");
        String[] task = this.MissionSyncData.split(";");
        for (String str : task) {
            String[] temp = str.split(",");
            if (temp[0].equals(type))
                return temp;
        }
        throw new Exception("该玩家 并没有 该任务类型!");
    }


    public float getInc(int i) {
        return JRMCoreH.statInc(this.pwr, i, 100, this.rce, this.cls, 0.0F) * 0.01F;
    }

    public int getSt1() {
        return (this.pwr == 1 && JRMCoreH.StusEfcts(13, this.buff)) ? 1 : (JRMCoreH.rc_humNam(this.rce) ? JRMCoreH.mstc_humnam() : (JRMCoreH.rc_arc(this.rce) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_sai(this.rce) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvl(JRMCoreH.vlblRSkls, this.sX) - 1) : this.st)));
    }

    public int getcurAtr(int i) {
        return (int) (stat(i) * 0.01D * this.cr * JRMCoreH.weightPerc(i, this.player)) + getSklks(i);
    }

    public int getMelee() {
        log("获取玩家 当前 近战伤害");
        return getcurAtr(0);
    }

    public int getMaxMelee() {
        log("获取玩家 当前 最大近战伤害");
        return stat(0);
        //return JRMCoreH.stat(this.player, 0, this.PlyrAttrbts[0], 0.0F);
    }

    public String getUpAtt(int i) {
        log("获取 提升一次属性 所需技能点,i可以为0-3,分别代表x1,x10,x100,x1000");
        return JRMCoreH.numSep(JRMCoreH.attrCst(this.NBTPlyrAttrbts, i));
    }

    public int getStartAtt(int i) {
        log("获取玩家开始游戏的基础属性,0:str,1:dex,2:con,3:wil,4:mnd,5:spi");
        return baseRace.getStartAttributes(i);
    }

    public int getSklks(int i) {
        int sklks = 0;
        int statSPI = JRMCoreH.stat(this.pwr, 5, this.NBTPlyrAttrbts[5], this.rce, this.cls, (this.pwr == 1) ? (SklLvl(13) * 0.01F) : 0.0F);
        if (this.pwr == 1)
            sklks = (int) (SklLvl(12 - i) * (0.0025D + i * 0.0025D) * statSPI * this.cr * 0.01D);
        return sklks;
    }

    public int stat(int i) {
        log("基础属性+额外属性所得的 统计最大值,0为最大近战伤害,1为最大身体强度");
        float ncbonus = 0.0F;
        if (this.pwr == 2) {
            int ta = JRMCoreH.SklLvl(0, 2, JRMCoreH.PlyrSkills);
            ncbonus = ta * 0.04F + this.st * 0.25F;
        }
        return JRMCoreH.stat(this.pwr, i, getAdd_Att(i), this.rce, this.cls, ncbonus);
    }

    public int getAdd_Att(int i) {
        log("基础属性+额外属性,额外属性可通过改变形态或者获得buff提升,0:str,1:dex,2:con(错误值),3:wil,4:mnd(错误值),5:spi(错误值)");
        return baseRace.getAdditionAttribute(i);
        /*
        Boolean kk = JRMCoreH.StusEfcts(5, this.buff);
        Boolean mj = JRMCoreH.StusEfcts(12, this.buff);
        Boolean mc = JRMCoreH.StusEfcts(13, this.buff);
        Boolean lg = JRMCoreH.StusEfcts(14, this.buff);
        Boolean mn = JRMCoreH.StusEfcts(19, this.buff);
        Boolean gd = JRMCoreH.StusEfcts(20, this.buff);
        Boolean c = (JRMCoreH.StusEfcts(10, this.buff) || JRMCoreH.StusEfcts(11, this.buff));
        return JRMCoreH.getPlayerAttribute(this.player,this.PlyrAttrbts, i, this.st, this.st2, this.rce, this.sX, this.cr, JRMCoreH.getArcRsrvID(this.player.func_70005_c_()), lg.booleanValue(), mj.booleanValue(),kk.booleanValue(), mc.booleanValue(), mn.booleanValue(),gd.booleanValue(),this.pwr,this.PlyrSkills, c.booleanValue(),JRMCoreH.getMajinAbsorptionID(this.player.func_70005_c_()));
        */
        //return JRMCoreH.TransPwrModAtr(this.PlyrAttrbts, i, this.st, this.st2, this.rce, this.sX, this.cr, this.resrv, lg.booleanValue(), mj.booleanValue(), mc.booleanValue(), mn.booleanValue(), 1, this.PlyrSkills, c.booleanValue());
    }

    public int getDamageReduction() {
        log("获取 玩家 伤害减少 值");
        return baseRace.getDamageReduction();
    }

    public int getAvailableMind() {
        log("获取 玩家 可用的心灵");
        return this.NBTPlyrAttrbts[4] - SklSlt_MU();
    }

    public double getKaiokenFormMasteryValue(){
        log("获取界王拳形态掌握值,如果服务器禁止形态掌握增长属性,则为0");
        return baseRace.getFormMasteryValue("Kaioken");
    }

    public double getMysticFormMasteryValue(){
        log("获取自我形态掌握值,如果服务器禁止形态掌握增长属性,则为0");
        return baseRace.getFormMasteryValue("Mystic");
    }

    public double getUltraInstictFormMasteryValue(){
        log("获取自在极意功形态掌握值,如果服务器禁止形态掌握增长属性,则为0");
        return baseRace.getFormMasteryValue("UltraInstict");
    }

    public double getGodOfDestructionFormMasteryValue(){
        log("获取神模式形态掌握值,如果服务器禁止形态掌握增长属性,则为0");
        return baseRace.getFormMasteryValue("GodOfDestruction");
    }

    public double getFormMasteryValue(String formName){
        log("获取形态掌握值,可填入四种形态:Kaioken(界王拳),Mystic(自我),UltraInstict(自在极意功),GodOfDestruction(神模式)");
        return baseRace.getFormMasteryValue(formName);
    }

    public double getRaceFormMastery(){
        log("获取种族形态掌握数值");
        return baseRace.getRaceFormMastery();
    }

    public int SklSlt_MU() {
        String[] cSkls, skls;
        int[][] sklsMR, rSklsMR = null;
        int[][] cSklsMR = null;
        if (this.pwr == 2) {
            log("火影忍者");
            cSkls = JRMCoreH.ncCSkls;
            cSklsMR = JRMCoreH.NCRacialSkillMindCost;
            skls = JRMCoreH.NCSkillIDs;
            sklsMR = JRMCoreH.NCSkillMindCost;
        } else {
            log("龙珠C");
            cSkls = JRMCoreH.vlblCSkls;
            rSklsMR = JRMCoreH.DBCRacialSkillMindCost;
            skls = JRMCoreH.DBCSkillsIDs;
            sklsMR = JRMCoreH.DBCSkillMindCost;
        }
        return JRMCoreH.skillSlot_SpentMindRequirement(this.nbt.func_74779_i("jrmcSSlts"), skls, sklsMR) + JRMCoreH.skillSlot_SpentMindRequirement_X(sX, rce, rSklsMR) + JRMCoreH.skillSlot_SpentMindRequirement(this.nbt.func_74779_i("jrmcSSltY"), cSkls, cSklsMR);
    }

    public int[] PlyrAttrbts(boolean fused) {
        log("异步情况下获取玩家6大属性值,其他情况请勿使用");
        log("fused为true时允许判断 融合状态 下的属性,建议为true");
        if (fused) {
            String Fzn = nbt.func_74779_i("jrmcFuzion");
            if (Fzn.contains(",")) {
                String[] FznA = Fzn.split(",");
                if (FznA.length == 3) {
                    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                    EntityPlayerMP entityPlayerMP1 = JRMCoreH.getPlayerForUsername(server, FznA[0]);
                    EntityPlayerMP entityPlayerMP2 = JRMCoreH.getPlayerForUsername(server, FznA[1]);
                    if (entityPlayerMP1 != null && entityPlayerMP2 != null)
                        return JRMCoreH.PlyrAttrbts(entityPlayerMP1, entityPlayerMP2);
                    nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
                    if (entityPlayerMP1 != null) {
                        NBTTagCompound nbt1 = JRMCoreH.nbt(entityPlayerMP1);
                        JRMCoreH.StusEfcts(10, nbt1, false);
                        JRMCoreH.StusEfcts(11, nbt1, false);
                    }
                    if (entityPlayerMP2 != null) {
                        NBTTagCompound nbt2 = JRMCoreH.nbt(entityPlayerMP2);
                        JRMCoreH.StusEfcts(10, nbt2, false);
                        JRMCoreH.StusEfcts(11, nbt2, false);
                    }
                }
            }
        }
        int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];
        byte i;
        for (i = 0; i < JRMCoreH.AttrbtNbt.length; i = (byte) (i + 1)) {
            if ((((nbt.func_74781_a(JRMCoreH.AttrbtNbtI[i]) == null) ? 1 : 0) & ((nbt.func_74781_a(JRMCoreH.AttrbtNbt[i]) != null) ? 1 : 0)) != 0) {
                nbt.func_74768_a(JRMCoreH.AttrbtNbtI[i], nbt.func_74765_d(JRMCoreH.AttrbtNbt[i]));
                nbt.func_82580_o(JRMCoreH.AttrbtNbt[i]);
            } else if (nbt.func_74781_a(JRMCoreH.AttrbtNbtI[i]) == null) {
                nbt.func_74768_a(JRMCoreH.AttrbtNbtI[i], 1);
            }
            int r = JRMCoreH.etXq4V(nbt.func_74762_e(JRMCoreH.AttrbtNbtI[i]));
            PlyrAttrbts[i] = r;
        }
        return PlyrAttrbts;
    }

    public void addEff(String str) {
        log("通过 中文名 添加龙珠buff");
        String buff = str;
        if (this.buff.length() > 0) {
            buff = this.buff + getEff(str);
        }
        setEff(buff);
    }

    public void setEff(String str) {
        this.nbt.func_74778_a("jrmcStatusEff", str);
    }

    public void removeEff(String str) {
        log("通过 中文名 删除龙珠buff");
        if (this.buff.length() > 0) {
            int num = this.buff.lastIndexOf(getEff(str));
            if (num != -1) {
                String buff = this.buff.replace(getEff(str), "");
                setEff(buff);
            }
        }
    }

    public String getEff(String str) {
        log("通过 中文名 获取龙珠buff中的代表 字母");
        String effname = "";
        for (int count = 0; count < this.StatusEffectName.length; count++) {
            if (this.StatusEffectName[count].equals(str))
                return getEff(count);
        }
        return effname;
    }

    public String getEff(int i) {
        log("通过 数字 获取龙珠buff中的代表 字母");
        return this.StatusEffect[i];
    }

    public String getEffName(String str) {
        log("通过 龙珠buff代表字母 获取 中文名");
        String effname = "";
        for (int count = 0; count < this.StatusEffect.length; count++) {
            if (this.StatusEffect[count].equals(str)) {
                return this.StatusEffectName[count];
            }
        }
        return effname;
    }

    public int SklLvl(int sn) {
        switch (this.pwr) {
            case 1:
                return SklLvlC(sn, JRMCoreH.DBCSkillsIDs);
            case 2:
                return SklLvlC(sn, JRMCoreH.NCSkillIDs);
        }
        return 0;
    }

    public int SklLvlC(int sn, String[] s) {
        if (s == null) {
            return 0;
        }
        int n = 0;//原为1
        if (this.PlyrSkills != null) {
            for (byte i = 0; i < this.PlyrSkills.length; i = (byte) (i + 1)) {
                String curSkl = this.PlyrSkills[i];
                if (curSkl.length() > 2 && s.length > sn && curSkl.contains(s[sn]) && !curSkl.contains("pty")) {
                    n = 1 + Integer.parseInt(curSkl.substring(2));
                    break;
                }
            }
        }
        return n;
    }

    public String log(String str) {
        return "该函数没有实际效果,仅仅用于标注各个函数的用法";
    }
}