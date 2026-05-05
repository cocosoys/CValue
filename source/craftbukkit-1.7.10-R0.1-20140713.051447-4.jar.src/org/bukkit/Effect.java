/*     */ package org.bukkit;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.potion.Potion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Effect
/*     */ {
/*     */   private final int id;
/*     */   private final Type type;
/*     */   private final Class<?> data;
/*  17 */   CLICK2(1000, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  21 */   CLICK1(1001, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  25 */   BOW_FIRE(1002, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  29 */   DOOR_TOGGLE(1003, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  33 */   EXTINGUISH(1004, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  37 */   RECORD_PLAY(1005, Type.SOUND, Material.class),
/*     */ 
/*     */ 
/*     */   
/*  41 */   GHAST_SHRIEK(1007, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  45 */   GHAST_SHOOT(1008, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  49 */   BLAZE_SHOOT(1009, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  53 */   ZOMBIE_CHEW_WOODEN_DOOR(1010, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  57 */   ZOMBIE_CHEW_IRON_DOOR(1011, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  61 */   ZOMBIE_DESTROY_DOOR(1012, Type.SOUND),
/*     */ 
/*     */ 
/*     */   
/*  65 */   SMOKE(2000, Type.VISUAL, BlockFace.class),
/*     */ 
/*     */ 
/*     */   
/*  69 */   STEP_SOUND(2001, Type.SOUND, Material.class),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   POTION_BREAK(2002, Type.VISUAL, Potion.class),
/*     */ 
/*     */ 
/*     */   
/*  78 */   ENDER_SIGNAL(2003, Type.VISUAL),
/*     */ 
/*     */ 
/*     */   
/*  82 */   MOBSPAWNER_FLAMES(2004, Type.VISUAL);
/*     */   private static final Map<Integer, Effect> BY_ID;
/*     */   Effect(int id, Type type, Class<?> data) { this.id = id;
/*     */     this.type = type;
/*     */     this.data = data; }
/*  87 */   @Deprecated public int getId() { return this.id; } public Type getType() { return this.type; } static { BY_ID = Maps.newHashMap();
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
/*     */     
/* 138 */     for (Effect effect : values())
/* 139 */       BY_ID.put(Integer.valueOf(effect.id), effect);  }
/*     */    public Class<?> getData() {
/*     */     return this.data;
/*     */   } @Deprecated
/*     */   public static Effect getById(int id) {
/*     */     return BY_ID.get(Integer.valueOf(id));
/*     */   }
/* 146 */   public enum Type { SOUND, VISUAL; }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\Effect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */