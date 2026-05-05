/*     */ package org.bukkit.craftbukkit.v1_7_R4.inventory;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.server.v1_7_R4.GameProfileSerializer;
/*     */ import net.minecraft.server.v1_7_R4.NBTBase;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagCompound;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.serialization.DelegateDeserialization;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.Repairable;
/*     */ import org.bukkit.inventory.meta.SkullMeta;
/*     */ 
/*     */ @DelegateDeserialization(CraftMetaItem.SerializableMeta.class)
/*     */ class CraftMetaSkull
/*     */   extends CraftMetaItem
/*     */   implements SkullMeta {
/*  19 */   static final CraftMetaItem.ItemMetaKey SKULL_OWNER = new CraftMetaItem.ItemMetaKey("SkullOwner", "skull-owner");
/*     */   
/*     */   static final int MAX_OWNER_LENGTH = 16;
/*     */   private GameProfile profile;
/*     */   
/*     */   CraftMetaSkull(CraftMetaItem meta) {
/*  25 */     super(meta);
/*  26 */     if (!(meta instanceof CraftMetaSkull)) {
/*     */       return;
/*     */     }
/*  29 */     CraftMetaSkull skullMeta = (CraftMetaSkull)meta;
/*  30 */     this.profile = skullMeta.profile;
/*     */   }
/*     */   
/*     */   CraftMetaSkull(NBTTagCompound tag) {
/*  34 */     super(tag);
/*     */     
/*  36 */     if (tag.hasKeyOfType(SKULL_OWNER.NBT, 10)) {
/*  37 */       this.profile = GameProfileSerializer.deserialize(tag.getCompound(SKULL_OWNER.NBT));
/*  38 */     } else if (tag.hasKeyOfType(SKULL_OWNER.NBT, 8)) {
/*  39 */       this.profile = new GameProfile(null, tag.getString(SKULL_OWNER.NBT));
/*     */     } 
/*     */   }
/*     */   
/*     */   CraftMetaSkull(Map<String, Object> map) {
/*  44 */     super(map);
/*  45 */     setOwner(CraftMetaItem.SerializableMeta.getString(map, SKULL_OWNER.BUKKIT, true));
/*     */   }
/*     */ 
/*     */   
/*     */   void applyToItem(NBTTagCompound tag) {
/*  50 */     super.applyToItem(tag);
/*     */     
/*  52 */     if (hasOwner()) {
/*  53 */       NBTTagCompound owner = new NBTTagCompound();
/*  54 */       GameProfileSerializer.serialize(owner, this.profile);
/*  55 */       tag.set(SKULL_OWNER.NBT, (NBTBase)owner);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isEmpty() {
/*  61 */     return (super.isEmpty() && isSkullEmpty());
/*     */   }
/*     */   
/*     */   boolean isSkullEmpty() {
/*  65 */     return !hasOwner();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean applicableTo(Material type) {
/*  70 */     switch (type) {
/*     */       case SKULL_ITEM:
/*  72 */         return true;
/*     */     } 
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CraftMetaSkull clone() {
/*  80 */     return (CraftMetaSkull)super.clone();
/*     */   }
/*     */   
/*     */   public boolean hasOwner() {
/*  84 */     return (this.profile != null);
/*     */   }
/*     */   
/*     */   public String getOwner() {
/*  88 */     return hasOwner() ? this.profile.getName() : null;
/*     */   }
/*     */   
/*     */   public boolean setOwner(String name) {
/*  92 */     if (name != null && name.length() > 16) {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (name == null) {
/*  97 */       this.profile = null;
/*     */     } else {
/*  99 */       this.profile = new GameProfile(null, name);
/*     */     } 
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int applyHash() {
/* 108 */     int original = super.applyHash(), hash = original;
/* 109 */     if (hasOwner()) {
/* 110 */       hash = 61 * hash + this.profile.hashCode();
/*     */     }
/* 112 */     return (original != hash) ? (CraftMetaSkull.class.hashCode() ^ hash) : hash;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean equalsCommon(CraftMetaItem meta) {
/* 117 */     if (!super.equalsCommon(meta)) {
/* 118 */       return false;
/*     */     }
/* 120 */     if (meta instanceof CraftMetaSkull) {
/* 121 */       CraftMetaSkull that = (CraftMetaSkull)meta;
/*     */       
/* 123 */       return hasOwner() ? ((that.hasOwner() && this.profile.equals(that.profile))) : (!that.hasOwner());
/*     */     } 
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean notUncommon(CraftMetaItem meta) {
/* 130 */     return (super.notUncommon(meta) && (meta instanceof CraftMetaSkull || isSkullEmpty()));
/*     */   }
/*     */ 
/*     */   
/*     */   ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
/* 135 */     super.serialize(builder);
/* 136 */     if (hasOwner()) {
/* 137 */       return builder.put(SKULL_OWNER.BUKKIT, this.profile.getName());
/*     */     }
/* 139 */     return builder;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\inventory\CraftMetaSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */