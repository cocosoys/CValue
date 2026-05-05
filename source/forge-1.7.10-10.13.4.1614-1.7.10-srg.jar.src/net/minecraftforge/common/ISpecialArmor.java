/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ISpecialArmor
/*     */ {
/*     */   ArmorProperties getProperties(EntityLivingBase paramEntityLivingBase, ItemStack paramItemStack, DamageSource paramDamageSource, double paramDouble, int paramInt);
/*     */   
/*     */   int getArmorDisplay(EntityPlayer paramEntityPlayer, ItemStack paramItemStack, int paramInt);
/*     */   
/*     */   void damageArmor(EntityLivingBase paramEntityLivingBase, ItemStack paramItemStack, DamageSource paramDamageSource, int paramInt1, int paramInt2);
/*     */   
/*     */   public static class ArmorProperties
/*     */     implements Comparable<ArmorProperties>
/*     */   {
/*  70 */     public int Priority = 0;
/*  71 */     public int AbsorbMax = Integer.MAX_VALUE;
/*  72 */     public double AbsorbRatio = 0.0D;
/*  73 */     public int Slot = 0;
/*     */     
/*     */     private static final boolean DEBUG = false;
/*     */ 
/*     */     
/*     */     public ArmorProperties(int priority, double ratio, int max) {
/*  79 */       this.Priority = priority;
/*  80 */       this.AbsorbRatio = ratio;
/*  81 */       this.AbsorbMax = max;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static float ApplyArmor(EntityLivingBase entity, ItemStack[] inventory, DamageSource source, double damage) {
/*  99 */       damage *= 25.0D;
/* 100 */       ArrayList<ArmorProperties> dmgVals = new ArrayList<ArmorProperties>();
/* 101 */       for (int x = 0; x < inventory.length; x++) {
/*     */         
/* 103 */         ItemStack stack = inventory[x];
/* 104 */         if (stack != null) {
/*     */ 
/*     */ 
/*     */           
/* 108 */           ArmorProperties prop = null;
/* 109 */           if (stack.getItem() instanceof ISpecialArmor) {
/*     */             
/* 111 */             ISpecialArmor armor = (ISpecialArmor)stack.getItem();
/* 112 */             prop = armor.getProperties(entity, stack, source, damage / 25.0D, x).copy();
/*     */           }
/* 114 */           else if (stack.getItem() instanceof ItemArmor && !source.isUnblockable()) {
/*     */             
/* 116 */             ItemArmor armor = (ItemArmor)stack.getItem();
/* 117 */             prop = new ArmorProperties(0, armor.damageReduceAmount / 25.0D, armor.getMaxDamage() + 1 - stack.getItemDamage());
/*     */           } 
/* 119 */           if (prop != null) {
/*     */             
/* 121 */             prop.Slot = x;
/* 122 */             dmgVals.add(prop);
/*     */           } 
/*     */         } 
/* 125 */       }  if (dmgVals.size() > 0) {
/*     */         
/* 127 */         ArmorProperties[] props = dmgVals.<ArmorProperties>toArray(new ArmorProperties[dmgVals.size()]);
/* 128 */         StandardizeList(props, damage);
/* 129 */         int level = (props[0]).Priority;
/* 130 */         double ratio = 0.0D;
/* 131 */         for (ArmorProperties prop : props) {
/*     */           
/* 133 */           if (level != prop.Priority) {
/*     */             
/* 135 */             damage -= damage * ratio;
/* 136 */             ratio = 0.0D;
/* 137 */             level = prop.Priority;
/*     */           } 
/* 139 */           ratio += prop.AbsorbRatio;
/*     */           
/* 141 */           double absorb = damage * prop.AbsorbRatio;
/* 142 */           if (absorb > 0.0D) {
/*     */             
/* 144 */             ItemStack stack = inventory[prop.Slot];
/* 145 */             int itemDamage = (int)((absorb / 25.0D < 1.0D) ? 1.0D : (absorb / 25.0D));
/* 146 */             if (stack.getItem() instanceof ISpecialArmor) {
/*     */               
/* 148 */               ((ISpecialArmor)stack.getItem()).damageArmor(entity, stack, source, itemDamage, prop.Slot);
/*     */ 
/*     */             
/*     */             }
/*     */             else {
/*     */ 
/*     */ 
/*     */               
/* 156 */               stack.damageItem(itemDamage, entity);
/*     */             } 
/* 158 */             if (stack.stackSize <= 0)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 164 */               inventory[prop.Slot] = null;
/*     */             }
/*     */           } 
/*     */         } 
/* 168 */         damage -= damage * ratio;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       return (float)(damage / 25.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static void StandardizeList(ArmorProperties[] armor, double damage) {
/* 185 */       Arrays.sort((Object[])armor);
/*     */       
/* 187 */       int start = 0;
/* 188 */       double total = 0.0D;
/* 189 */       int priority = (armor[0]).Priority;
/* 190 */       int pStart = 0;
/* 191 */       boolean pChange = false;
/* 192 */       boolean pFinished = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 203 */       for (int x = 0; x < armor.length; x++) {
/*     */         
/* 205 */         total += (armor[x]).AbsorbRatio;
/* 206 */         if (x == armor.length - 1 || (armor[x]).Priority != priority) {
/*     */           
/* 208 */           if ((armor[x]).Priority != priority) {
/*     */             
/* 210 */             total -= (armor[x]).AbsorbRatio;
/* 211 */             x--;
/* 212 */             pChange = true;
/*     */           } 
/* 214 */           if (total > 1.0D) {
/*     */             int y;
/* 216 */             for (y = start; y <= x; y++) {
/*     */               
/* 218 */               double newRatio = (armor[y]).AbsorbRatio / total;
/* 219 */               if (newRatio * damage > (armor[y]).AbsorbMax) {
/*     */                 
/* 221 */                 (armor[y]).AbsorbRatio = (armor[y]).AbsorbMax / damage;
/* 222 */                 total = 0.0D;
/* 223 */                 for (int z = pStart; z <= y; z++)
/*     */                 {
/* 225 */                   total += (armor[z]).AbsorbRatio;
/*     */                 }
/* 227 */                 start = y + 1;
/* 228 */                 x = y;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */               
/* 233 */               (armor[y]).AbsorbRatio = newRatio;
/* 234 */               pFinished = true;
/*     */             } 
/*     */             
/* 237 */             if (pChange && pFinished) {
/*     */               
/* 239 */               damage -= damage * total;
/* 240 */               total = 0.0D;
/* 241 */               start = x + 1;
/* 242 */               priority = (armor[start]).Priority;
/* 243 */               pStart = start;
/* 244 */               pChange = false;
/* 245 */               pFinished = false;
/* 246 */               if (damage <= 0.0D) {
/*     */                 
/* 248 */                 for (y = x + 1; y < armor.length; y++)
/*     */                 {
/* 250 */                   (armor[y]).AbsorbRatio = 0.0D;
/*     */                 }
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } else {
/*     */             int y;
/* 258 */             for (y = start; y <= x; y++) {
/*     */               
/* 260 */               total -= (armor[y]).AbsorbRatio;
/* 261 */               if (damage * (armor[y]).AbsorbRatio > (armor[y]).AbsorbMax)
/*     */               {
/* 263 */                 (armor[y]).AbsorbRatio = (armor[y]).AbsorbMax / damage;
/*     */               }
/* 265 */               total += (armor[y]).AbsorbRatio;
/*     */             } 
/* 267 */             damage -= damage * total;
/* 268 */             total = 0.0D;
/* 269 */             if (x != armor.length - 1) {
/*     */               
/* 271 */               start = x + 1;
/* 272 */               priority = (armor[start]).Priority;
/* 273 */               pStart = start;
/* 274 */               pChange = false;
/* 275 */               if (damage <= 0.0D) {
/*     */                 
/* 277 */                 for (y = x + 1; y < armor.length; y++)
/*     */                 {
/* 279 */                   (armor[y]).AbsorbRatio = 0.0D;
/*     */                 }
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(ArmorProperties o) {
/* 299 */       if (o.Priority != this.Priority)
/*     */       {
/* 301 */         return o.Priority - this.Priority;
/*     */       }
/* 303 */       double left = (this.AbsorbRatio == 0.0D) ? 0.0D : (this.AbsorbMax * 100.0D / this.AbsorbRatio);
/* 304 */       double right = (o.AbsorbRatio == 0.0D) ? 0.0D : (o.AbsorbMax * 100.0D / o.AbsorbRatio);
/* 305 */       return (int)(left - right);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 311 */       return String.format("%d, %d, %f, %d", new Object[] { Integer.valueOf(this.Priority), Integer.valueOf(this.AbsorbMax), Double.valueOf(this.AbsorbRatio), Integer.valueOf((this.AbsorbRatio == 0.0D) ? 0 : (int)(this.AbsorbMax * 100.0D / this.AbsorbRatio)) });
/*     */     }
/*     */ 
/*     */     
/*     */     public ArmorProperties copy() {
/* 316 */       return new ArmorProperties(this.Priority, this.AbsorbRatio, this.AbsorbMax);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ISpecialArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */