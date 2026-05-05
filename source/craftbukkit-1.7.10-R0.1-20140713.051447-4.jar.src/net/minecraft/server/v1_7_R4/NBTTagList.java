/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class NBTTagList extends NBTBase {
/*   8 */   private List list = new ArrayList();
/*   9 */   private byte type = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void write(DataOutput paramDataOutput) {
/*  16 */     if (!this.list.isEmpty()) { this.type = ((NBTBase)this.list.get(0)).getTypeId(); }
/*  17 */     else { this.type = 0; }
/*     */     
/*  19 */     paramDataOutput.writeByte(this.type);
/*  20 */     paramDataOutput.writeInt(this.list.size());
/*  21 */     for (byte b = 0; b < this.list.size(); b++) {
/*  22 */       ((NBTBase)this.list.get(b)).write(paramDataOutput);
/*     */     }
/*     */   }
/*     */   
/*     */   void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
/*  27 */     if (paramInt > 512) {
/*  28 */       throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
/*     */     }
/*  30 */     paramNBTReadLimiter.a(8L);
/*  31 */     this.type = paramDataInput.readByte();
/*  32 */     int i = paramDataInput.readInt();
/*     */     
/*  34 */     this.list = new ArrayList();
/*  35 */     for (byte b = 0; b < i; b++) {
/*  36 */       NBTBase nBTBase = NBTBase.createTag(this.type);
/*  37 */       nBTBase.load(paramDataInput, paramInt + 1, paramNBTReadLimiter);
/*  38 */       this.list.add(nBTBase);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getTypeId() {
/*  44 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  49 */     String str = "[";
/*  50 */     byte b = 0;
/*  51 */     for (NBTBase nBTBase : this.list) {
/*  52 */       str = str + "" + b + ':' + nBTBase + ',';
/*  53 */       b++;
/*     */     } 
/*  55 */     return str + "]";
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
/*     */   public void add(NBTBase paramNBTBase) {
/*  71 */     if (this.type == 0) {
/*  72 */       this.type = paramNBTBase.getTypeId();
/*  73 */     } else if (this.type != paramNBTBase.getTypeId()) {
/*  74 */       System.err.println("WARNING: Adding mismatching tag types to tag list");
/*     */       return;
/*     */     } 
/*  77 */     this.list.add(paramNBTBase);
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
/*     */   
/*     */   public NBTTagCompound get(int paramInt) {
/*  99 */     if (paramInt < 0 || paramInt >= this.list.size()) {
/* 100 */       return new NBTTagCompound();
/*     */     }
/* 102 */     NBTBase nBTBase = this.list.get(paramInt);
/* 103 */     if (nBTBase.getTypeId() == 10) {
/* 104 */       return (NBTTagCompound)nBTBase;
/*     */     }
/* 106 */     return new NBTTagCompound();
/*     */   }
/*     */   
/*     */   public int[] c(int paramInt) {
/* 110 */     if (paramInt < 0 || paramInt >= this.list.size()) {
/* 111 */       return new int[0];
/*     */     }
/* 113 */     NBTBase nBTBase = this.list.get(paramInt);
/* 114 */     if (nBTBase.getTypeId() == 11) {
/* 115 */       return ((NBTTagIntArray)nBTBase).c();
/*     */     }
/* 117 */     return new int[0];
/*     */   }
/*     */   
/*     */   public double d(int paramInt) {
/* 121 */     if (paramInt < 0 || paramInt >= this.list.size()) {
/* 122 */       return 0.0D;
/*     */     }
/* 124 */     NBTBase nBTBase = this.list.get(paramInt);
/* 125 */     if (nBTBase.getTypeId() == 6) {
/* 126 */       return ((NBTTagDouble)nBTBase).g();
/*     */     }
/* 128 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public float e(int paramInt) {
/* 132 */     if (paramInt < 0 || paramInt >= this.list.size()) {
/* 133 */       return 0.0F;
/*     */     }
/* 135 */     NBTBase nBTBase = this.list.get(paramInt);
/* 136 */     if (nBTBase.getTypeId() == 5) {
/* 137 */       return ((NBTTagFloat)nBTBase).h();
/*     */     }
/* 139 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public String getString(int paramInt) {
/* 143 */     if (paramInt < 0 || paramInt >= this.list.size()) {
/* 144 */       return "";
/*     */     }
/* 146 */     NBTBase nBTBase = this.list.get(paramInt);
/* 147 */     if (nBTBase.getTypeId() == 8) {
/* 148 */       return nBTBase.a_();
/*     */     }
/* 150 */     return nBTBase.toString();
/*     */   }
/*     */   
/*     */   public int size() {
/* 154 */     return this.list.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTBase clone() {
/* 159 */     NBTTagList nBTTagList = new NBTTagList();
/* 160 */     nBTTagList.type = this.type;
/* 161 */     for (NBTBase nBTBase1 : this.list) {
/* 162 */       NBTBase nBTBase2 = nBTBase1.clone();
/* 163 */       nBTTagList.list.add(nBTBase2);
/*     */     } 
/* 165 */     return nBTTagList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 170 */     if (super.equals(paramObject)) {
/* 171 */       NBTTagList nBTTagList = (NBTTagList)paramObject;
/* 172 */       if (this.type == nBTTagList.type) {
/* 173 */         return this.list.equals(nBTTagList.list);
/*     */       }
/*     */     } 
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     return super.hashCode() ^ this.list.hashCode();
/*     */   }
/*     */   
/*     */   public int d() {
/* 185 */     return this.type;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTTagList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */