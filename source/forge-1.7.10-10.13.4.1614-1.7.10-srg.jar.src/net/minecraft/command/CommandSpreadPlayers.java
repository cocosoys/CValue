/*     */ package net.minecraft.command;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CommandSpreadPlayers extends CommandBase {
/*     */   public String func_71517_b() {
/*  24 */     return "spreadplayers";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */   private static final String __OBFID = "CL_00001080";
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  34 */     return "commands.spreadplayers.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  39 */     if (p_71515_2_.length < 6) throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]); 
/*  40 */     byte b = 0;
/*  41 */     double d1 = func_110666_a(p_71515_1_, Double.NaN, p_71515_2_[b++]);
/*  42 */     double d2 = func_110666_a(p_71515_1_, Double.NaN, p_71515_2_[b++]);
/*  43 */     double d3 = func_110664_a(p_71515_1_, p_71515_2_[b++], 0.0D);
/*  44 */     double d4 = func_110664_a(p_71515_1_, p_71515_2_[b++], d3 + 1.0D);
/*  45 */     boolean bool = func_110662_c(p_71515_1_, p_71515_2_[b++]);
/*     */     
/*  47 */     ArrayList<? super EntityPlayerMP> arrayList = Lists.newArrayList();
/*     */     
/*  49 */     while (b < p_71515_2_.length) {
/*  50 */       String str = p_71515_2_[b++];
/*     */       
/*  52 */       if (PlayerSelector.func_82378_b(str)) {
/*  53 */         EntityPlayerMP[] arrayOfEntityPlayerMP = PlayerSelector.func_82380_c(p_71515_1_, str);
/*     */         
/*  55 */         if (arrayOfEntityPlayerMP != null && arrayOfEntityPlayerMP.length != 0) {
/*  56 */           Collections.addAll(arrayList, arrayOfEntityPlayerMP); continue;
/*     */         } 
/*  58 */         throw new PlayerNotFoundException();
/*     */       } 
/*     */       
/*  61 */       EntityPlayerMP entityPlayerMP = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(str);
/*     */       
/*  63 */       if (entityPlayerMP != null) {
/*  64 */         arrayList.add(entityPlayerMP); continue;
/*     */       } 
/*  66 */       throw new PlayerNotFoundException();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (arrayList.isEmpty()) {
/*  72 */       throw new PlayerNotFoundException();
/*     */     }
/*     */     
/*  75 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.spreadplayers.spreading." + (bool ? "teams" : "players"), new Object[] { Integer.valueOf(arrayList.size()), Double.valueOf(d4), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3) }));
/*     */     
/*  77 */     func_110669_a(p_71515_1_, arrayList, new Position(d1, d2), d3, d4, ((EntityLivingBase)arrayList.get(0)).field_70170_p, bool);
/*     */   }
/*     */   
/*     */   private void func_110669_a(ICommandSender p_110669_1_, List p_110669_2_, Position p_110669_3_, double p_110669_4_, double p_110669_6_, World p_110669_8_, boolean p_110669_9_) {
/*  81 */     Random random = new Random();
/*  82 */     double d1 = p_110669_3_.field_111101_a - p_110669_6_;
/*  83 */     double d2 = p_110669_3_.field_111100_b - p_110669_6_;
/*  84 */     double d3 = p_110669_3_.field_111101_a + p_110669_6_;
/*  85 */     double d4 = p_110669_3_.field_111100_b + p_110669_6_;
/*     */     
/*  87 */     Position[] arrayOfPosition = func_110670_a(random, p_110669_9_ ? func_110667_a(p_110669_2_) : p_110669_2_.size(), d1, d2, d3, d4);
/*  88 */     int i = func_110668_a(p_110669_3_, p_110669_4_, p_110669_8_, random, d1, d2, d3, d4, arrayOfPosition, p_110669_9_);
/*  89 */     double d5 = func_110671_a(p_110669_2_, p_110669_8_, arrayOfPosition, p_110669_9_);
/*     */     
/*  91 */     func_152373_a(p_110669_1_, this, "commands.spreadplayers.success." + (p_110669_9_ ? "teams" : "players"), new Object[] { Integer.valueOf(arrayOfPosition.length), Double.valueOf(p_110669_3_.field_111101_a), Double.valueOf(p_110669_3_.field_111100_b) });
/*  92 */     if (arrayOfPosition.length > 1) p_110669_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.spreadplayers.info." + (p_110669_9_ ? "teams" : "players"), new Object[] { String.format("%.2f", new Object[] { Double.valueOf(d5) }), Integer.valueOf(i) })); 
/*     */   }
/*     */   
/*     */   private int func_110667_a(List p_110667_1_) {
/*  96 */     HashSet<Team> hashSet = Sets.newHashSet();
/*     */     
/*  98 */     for (EntityLivingBase entityLivingBase : p_110667_1_) {
/*  99 */       if (entityLivingBase instanceof net.minecraft.entity.player.EntityPlayer) {
/* 100 */         hashSet.add(entityLivingBase.func_96124_cp()); continue;
/*     */       } 
/* 102 */       hashSet.add(null);
/*     */     } 
/*     */ 
/*     */     
/* 106 */     return hashSet.size();
/*     */   }
/*     */   
/*     */   private int func_110668_a(Position p_110668_1_, double p_110668_2_, World p_110668_4_, Random p_110668_5_, double p_110668_6_, double p_110668_8_, double p_110668_10_, double p_110668_12_, Position[] p_110668_14_, boolean p_110668_15_) {
/* 110 */     boolean bool = true;
/*     */     
/* 112 */     double d = 3.4028234663852886E38D;
/*     */     byte b;
/* 114 */     for (b = 0; b < '✐' && bool; b++) {
/* 115 */       bool = false;
/* 116 */       d = 3.4028234663852886E38D;
/*     */       
/* 118 */       for (byte b1 = 0; b1 < p_110668_14_.length; b1++) {
/* 119 */         Position position1 = p_110668_14_[b1];
/* 120 */         byte b2 = 0;
/* 121 */         Position position2 = new Position();
/*     */         
/* 123 */         for (byte b3 = 0; b3 < p_110668_14_.length; b3++) {
/* 124 */           if (b1 != b3) {
/* 125 */             Position position = p_110668_14_[b3];
/*     */             
/* 127 */             double d1 = position1.func_111099_a(position);
/* 128 */             d = Math.min(d1, d);
/* 129 */             if (d1 < p_110668_2_) {
/* 130 */               b2++;
/* 131 */               position2.field_111101_a += position.field_111101_a - position1.field_111101_a;
/* 132 */               position2.field_111100_b += position.field_111100_b - position1.field_111100_b;
/*     */             } 
/*     */           } 
/*     */         } 
/* 136 */         if (b2 > 0) {
/* 137 */           position2.field_111101_a /= b2;
/* 138 */           position2.field_111100_b /= b2;
/* 139 */           double d1 = position2.func_111096_b();
/*     */           
/* 141 */           if (d1 > 0.0D) {
/* 142 */             position2.func_111095_a();
/*     */             
/* 144 */             position1.func_111094_b(position2);
/*     */           } else {
/* 146 */             position1.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
/*     */           } 
/*     */           
/* 149 */           bool = true;
/*     */         } 
/*     */         
/* 152 */         if (position1.func_111093_a(p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_)) {
/* 153 */           bool = true;
/*     */         }
/*     */       } 
/*     */       
/* 157 */       if (!bool) {
/* 158 */         for (Position position : p_110668_14_) {
/* 159 */           if (!position.func_111098_b(p_110668_4_)) {
/* 160 */             position.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
/* 161 */             bool = true;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 167 */     if (b >= '✐') {
/* 168 */       throw new CommandException("commands.spreadplayers.failure." + (p_110668_15_ ? "teams" : "players"), new Object[] { Integer.valueOf(p_110668_14_.length), Double.valueOf(p_110668_1_.field_111101_a), Double.valueOf(p_110668_1_.field_111100_b), String.format("%.2f", new Object[] { Double.valueOf(d) }) });
/*     */     }
/*     */     
/* 171 */     return b;
/*     */   }
/*     */   
/*     */   private double func_110671_a(List<EntityLivingBase> p_110671_1_, World p_110671_2_, Position[] p_110671_3_, boolean p_110671_4_) {
/* 175 */     double d = 0.0D;
/* 176 */     byte b1 = 0;
/* 177 */     HashMap<Team, Position> hashMap = Maps.newHashMap();
/*     */     
/* 179 */     for (byte b2 = 0; b2 < p_110671_1_.size(); b2++) {
/* 180 */       Position position; EntityLivingBase entityLivingBase = p_110671_1_.get(b2);
/*     */ 
/*     */       
/* 183 */       if (p_110671_4_) {
/* 184 */         Team team = (entityLivingBase instanceof net.minecraft.entity.player.EntityPlayer) ? entityLivingBase.func_96124_cp() : null;
/*     */         
/* 186 */         if (!hashMap.containsKey(team)) {
/* 187 */           hashMap.put(team, p_110671_3_[b1++]);
/*     */         }
/*     */         
/* 190 */         position = hashMap.get(team);
/*     */       } else {
/* 192 */         position = p_110671_3_[b1++];
/*     */       } 
/*     */       
/* 195 */       entityLivingBase.func_70634_a((MathHelper.func_76128_c(position.field_111101_a) + 0.5F), position.func_111092_a(p_110671_2_), MathHelper.func_76128_c(position.field_111100_b) + 0.5D);
/*     */       
/* 197 */       double d1 = Double.MAX_VALUE;
/* 198 */       for (byte b = 0; b < p_110671_3_.length; b++) {
/* 199 */         if (position != p_110671_3_[b]) {
/*     */           
/* 201 */           double d2 = position.func_111099_a(p_110671_3_[b]);
/* 202 */           d1 = Math.min(d2, d1);
/*     */         } 
/* 204 */       }  d += d1;
/*     */     } 
/*     */     
/* 207 */     d /= p_110671_1_.size();
/* 208 */     return d;
/*     */   }
/*     */   
/*     */   private Position[] func_110670_a(Random p_110670_1_, int p_110670_2_, double p_110670_3_, double p_110670_5_, double p_110670_7_, double p_110670_9_) {
/* 212 */     Position[] arrayOfPosition = new Position[p_110670_2_];
/*     */     
/* 214 */     for (byte b = 0; b < arrayOfPosition.length; b++) {
/* 215 */       Position position = new Position();
/*     */       
/* 217 */       position.func_111097_a(p_110670_1_, p_110670_3_, p_110670_5_, p_110670_7_, p_110670_9_);
/*     */       
/* 219 */       arrayOfPosition[b] = position;
/*     */     } 
/*     */     
/* 222 */     return arrayOfPosition;
/*     */   }
/*     */   
/*     */   static class Position {
/*     */     double field_111101_a;
/*     */     double field_111100_b;
/*     */     private static final String __OBFID = "CL_00001105";
/*     */     
/*     */     Position() {}
/*     */     
/*     */     Position(double p_i1358_1_, double p_i1358_3_) {
/* 233 */       this.field_111101_a = p_i1358_1_;
/* 234 */       this.field_111100_b = p_i1358_3_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     double func_111099_a(Position p_111099_1_) {
/* 243 */       double d1 = this.field_111101_a - p_111099_1_.field_111101_a;
/* 244 */       double d2 = this.field_111100_b - p_111099_1_.field_111100_b;
/*     */       
/* 246 */       return Math.sqrt(d1 * d1 + d2 * d2);
/*     */     }
/*     */     
/*     */     void func_111095_a() {
/* 250 */       double d = func_111096_b();
/* 251 */       this.field_111101_a /= d;
/* 252 */       this.field_111100_b /= d;
/*     */     }
/*     */     
/*     */     float func_111096_b() {
/* 256 */       return MathHelper.func_76133_a(this.field_111101_a * this.field_111101_a + this.field_111100_b * this.field_111100_b);
/*     */     }
/*     */     
/*     */     public void func_111094_b(Position p_111094_1_) {
/* 260 */       this.field_111101_a -= p_111094_1_.field_111101_a;
/* 261 */       this.field_111100_b -= p_111094_1_.field_111100_b;
/*     */     }
/*     */     
/*     */     public boolean func_111093_a(double p_111093_1_, double p_111093_3_, double p_111093_5_, double p_111093_7_) {
/* 265 */       boolean bool = false;
/*     */       
/* 267 */       if (this.field_111101_a < p_111093_1_) {
/* 268 */         this.field_111101_a = p_111093_1_;
/* 269 */         bool = true;
/* 270 */       } else if (this.field_111101_a > p_111093_5_) {
/* 271 */         this.field_111101_a = p_111093_5_;
/* 272 */         bool = true;
/*     */       } 
/*     */       
/* 275 */       if (this.field_111100_b < p_111093_3_) {
/* 276 */         this.field_111100_b = p_111093_3_;
/* 277 */         bool = true;
/* 278 */       } else if (this.field_111100_b > p_111093_7_) {
/* 279 */         this.field_111100_b = p_111093_7_;
/* 280 */         bool = true;
/*     */       } 
/*     */       
/* 283 */       return bool;
/*     */     }
/*     */     
/*     */     public int func_111092_a(World p_111092_1_) {
/* 287 */       int i = MathHelper.func_76128_c(this.field_111101_a);
/* 288 */       int j = MathHelper.func_76128_c(this.field_111100_b);
/*     */       
/* 290 */       for (char c = 'Ā'; c > '\000'; c--) {
/* 291 */         if (p_111092_1_.func_147439_a(i, c, j).func_149688_o() != Material.field_151579_a) {
/* 292 */           return c + 1;
/*     */         }
/*     */       } 
/*     */       
/* 296 */       return 257;
/*     */     }
/*     */     
/*     */     public boolean func_111098_b(World p_111098_1_) {
/* 300 */       int i = MathHelper.func_76128_c(this.field_111101_a);
/* 301 */       int j = MathHelper.func_76128_c(this.field_111100_b);
/*     */       
/* 303 */       char c = 'Ā'; if (c > '\000') {
/* 304 */         Material material = p_111098_1_.func_147439_a(i, c, j).func_149688_o();
/*     */         
/* 306 */         return (!material.func_76224_d() && material != Material.field_151581_o);
/*     */       } 
/*     */       
/* 309 */       return false;
/*     */     }
/*     */     
/*     */     public void func_111097_a(Random p_111097_1_, double p_111097_2_, double p_111097_4_, double p_111097_6_, double p_111097_8_) {
/* 313 */       this.field_111101_a = MathHelper.func_82716_a(p_111097_1_, p_111097_2_, p_111097_6_);
/* 314 */       this.field_111100_b = MathHelper.func_82716_a(p_111097_1_, p_111097_4_, p_111097_8_);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandSpreadPlayers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */