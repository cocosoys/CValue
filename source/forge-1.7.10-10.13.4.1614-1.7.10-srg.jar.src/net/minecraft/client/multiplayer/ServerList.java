/*    */ package net.minecraft.client.multiplayer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.io.File;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.nbt.CompressedStreamTools;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ServerList {
/* 12 */   private static final Logger field_147415_a = LogManager.getLogger();
/*    */   private final Minecraft field_78859_a;
/* 14 */   private final List field_78858_b = new ArrayList(); private static final String __OBFID = "CL_00000891";
/*    */   
/*    */   public ServerList(Minecraft p_i1194_1_) {
/* 17 */     this.field_78859_a = p_i1194_1_;
/* 18 */     func_78853_a();
/*    */   }
/*    */   
/*    */   public void func_78853_a() {
/*    */     try {
/* 23 */       this.field_78858_b.clear();
/*    */       
/* 25 */       NBTTagCompound nBTTagCompound = CompressedStreamTools.func_74797_a(new File(this.field_78859_a.field_71412_D, "servers.dat"));
/* 26 */       if (nBTTagCompound == null)
/*    */         return; 
/* 28 */       NBTTagList nBTTagList = nBTTagCompound.func_150295_c("servers", 10);
/* 29 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 30 */         this.field_78858_b.add(ServerData.func_78837_a(nBTTagList.func_150305_b(b)));
/*    */       }
/* 32 */     } catch (Exception exception) {
/* 33 */       field_147415_a.error("Couldn't load server list", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_78855_b() {
/*    */     try {
/* 39 */       NBTTagList nBTTagList = new NBTTagList();
/* 40 */       for (ServerData serverData : this.field_78858_b) {
/* 41 */         nBTTagList.func_74742_a((NBTBase)serverData.func_78836_a());
/*    */       }
/*    */       
/* 44 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 45 */       nBTTagCompound.func_74782_a("servers", (NBTBase)nBTTagList);
/* 46 */       CompressedStreamTools.func_74793_a(nBTTagCompound, new File(this.field_78859_a.field_71412_D, "servers.dat"));
/* 47 */     } catch (Exception exception) {
/* 48 */       field_147415_a.error("Couldn't save server list", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public ServerData func_78850_a(int p_78850_1_) {
/* 53 */     return this.field_78858_b.get(p_78850_1_);
/*    */   }
/*    */   
/*    */   public void func_78851_b(int p_78851_1_) {
/* 57 */     this.field_78858_b.remove(p_78851_1_);
/*    */   }
/*    */   
/*    */   public void func_78849_a(ServerData p_78849_1_) {
/* 61 */     this.field_78858_b.add(p_78849_1_);
/*    */   }
/*    */   
/*    */   public int func_78856_c() {
/* 65 */     return this.field_78858_b.size();
/*    */   }
/*    */   
/*    */   public void func_78857_a(int p_78857_1_, int p_78857_2_) {
/* 69 */     ServerData serverData = func_78850_a(p_78857_1_);
/* 70 */     this.field_78858_b.set(p_78857_1_, func_78850_a(p_78857_2_));
/* 71 */     this.field_78858_b.set(p_78857_2_, serverData);
/* 72 */     func_78855_b();
/*    */   }
/*    */   
/*    */   public void func_147413_a(int p_147413_1_, ServerData p_147413_2_) {
/* 76 */     this.field_78858_b.set(p_147413_1_, p_147413_2_);
/*    */   }
/*    */   
/*    */   public static void func_147414_b(ServerData p_147414_0_) {
/* 80 */     ServerList serverList = new ServerList(Minecraft.func_71410_x());
/* 81 */     serverList.func_78853_a();
/*    */     
/* 83 */     for (byte b = 0; b < serverList.func_78856_c(); b++) {
/* 84 */       ServerData serverData = serverList.func_78850_a(b);
/*    */       
/* 86 */       if (serverData.field_78847_a.equals(p_147414_0_.field_78847_a) && serverData.field_78845_b.equals(p_147414_0_.field_78845_b)) {
/* 87 */         serverList.func_147413_a(b, p_147414_0_);
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/* 92 */     serverList.func_78855_b();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\ServerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */