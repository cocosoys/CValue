/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
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
/*     */ public abstract class NBTBase
/*     */ {
/*  19 */   public static final String[] a = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void write(DataOutput paramDataOutput);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String toString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract byte getTypeId();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static NBTBase createTag(byte paramByte) {
/*  53 */     switch (paramByte) {
/*     */       case 0:
/*  55 */         return new NBTTagEnd();
/*     */       case 1:
/*  57 */         return new NBTTagByte();
/*     */       case 2:
/*  59 */         return new NBTTagShort();
/*     */       case 3:
/*  61 */         return new NBTTagInt();
/*     */       case 4:
/*  63 */         return new NBTTagLong();
/*     */       case 5:
/*  65 */         return new NBTTagFloat();
/*     */       case 6:
/*  67 */         return new NBTTagDouble();
/*     */       case 7:
/*  69 */         return new NBTTagByteArray();
/*     */       case 11:
/*  71 */         return new NBTTagIntArray();
/*     */       case 8:
/*  73 */         return new NBTTagString();
/*     */       case 9:
/*  75 */         return new NBTTagList();
/*     */       case 10:
/*  77 */         return new NBTTagCompound();
/*     */     } 
/*  79 */     return null;
/*     */   }
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
/*     */   public abstract NBTBase clone();
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
/*     */   public boolean equals(Object paramObject) {
/* 118 */     if (!(paramObject instanceof NBTBase)) {
/* 119 */       return false;
/*     */     }
/* 121 */     NBTBase nBTBase = (NBTBase)paramObject;
/* 122 */     if (getTypeId() != nBTBase.getTypeId()) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 130 */     return getTypeId();
/*     */   }
/*     */   
/*     */   protected String a_() {
/* 134 */     return toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */