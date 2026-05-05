/*     */ package net.minecraft.world.gen.structure;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class StructureStart {
/*  10 */   protected LinkedList field_75075_a = new LinkedList();
/*     */   
/*     */   protected StructureBoundingBox field_75074_b;
/*     */   private int field_143024_c;
/*     */   private int field_143023_d;
/*     */   private static final String __OBFID = "CL_00000513";
/*     */   
/*     */   public StructureStart() {}
/*     */   
/*     */   public StructureStart(int p_i43002_1_, int p_i43002_2_) {
/*  20 */     this.field_143024_c = p_i43002_1_;
/*  21 */     this.field_143023_d = p_i43002_2_;
/*     */   }
/*     */   
/*     */   public StructureBoundingBox func_75071_a() {
/*  25 */     return this.field_75074_b;
/*     */   }
/*     */   
/*     */   public LinkedList func_75073_b() {
/*  29 */     return this.field_75075_a;
/*     */   }
/*     */   
/*     */   public void func_75068_a(World p_75068_1_, Random p_75068_2_, StructureBoundingBox p_75068_3_) {
/*  33 */     Iterator<StructureComponent> iterator = this.field_75075_a.iterator();
/*  34 */     while (iterator.hasNext()) {
/*  35 */       StructureComponent structureComponent = iterator.next();
/*  36 */       if (structureComponent.func_74874_b().func_78884_a(p_75068_3_) && 
/*  37 */         !structureComponent.func_74875_a(p_75068_1_, p_75068_2_, p_75068_3_)) {
/*  38 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_75072_c() {
/*  45 */     this.field_75074_b = StructureBoundingBox.func_78887_a();
/*     */     
/*  47 */     for (StructureComponent structureComponent : this.field_75075_a) {
/*  48 */       this.field_75074_b.func_78888_b(structureComponent.func_74874_b());
/*     */     }
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_143021_a(int p_143021_1_, int p_143021_2_) {
/*  53 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/*  55 */     nBTTagCompound.func_74778_a("id", MapGenStructureIO.func_143033_a(this));
/*  56 */     nBTTagCompound.func_74768_a("ChunkX", p_143021_1_);
/*  57 */     nBTTagCompound.func_74768_a("ChunkZ", p_143021_2_);
/*  58 */     nBTTagCompound.func_74782_a("BB", (NBTBase)this.field_75074_b.func_151535_h());
/*     */     
/*  60 */     NBTTagList nBTTagList = new NBTTagList();
/*  61 */     for (StructureComponent structureComponent : this.field_75075_a) {
/*  62 */       nBTTagList.func_74742_a((NBTBase)structureComponent.func_143010_b());
/*     */     }
/*  64 */     nBTTagCompound.func_74782_a("Children", (NBTBase)nBTTagList);
/*     */     
/*  66 */     func_143022_a(nBTTagCompound);
/*     */     
/*  68 */     return nBTTagCompound;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_143022_a(NBTTagCompound p_143022_1_) {}
/*     */ 
/*     */   
/*     */   public void func_143020_a(World p_143020_1_, NBTTagCompound p_143020_2_) {
/*  77 */     this.field_143024_c = p_143020_2_.func_74762_e("ChunkX");
/*  78 */     this.field_143023_d = p_143020_2_.func_74762_e("ChunkZ");
/*  79 */     if (p_143020_2_.func_74764_b("BB")) {
/*  80 */       this.field_75074_b = new StructureBoundingBox(p_143020_2_.func_74759_k("BB"));
/*     */     }
/*     */     
/*  83 */     NBTTagList nBTTagList = p_143020_2_.func_150295_c("Children", 10);
/*  84 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  85 */       this.field_75075_a.add(MapGenStructureIO.func_143032_b(nBTTagList.func_150305_b(b), p_143020_1_));
/*     */     }
/*     */     
/*  88 */     func_143017_b(p_143020_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_143017_b(NBTTagCompound p_143017_1_) {}
/*     */ 
/*     */   
/*     */   protected void func_75067_a(World p_75067_1_, Random p_75067_2_, int p_75067_3_) {
/*  96 */     int i = 63 - p_75067_3_;
/*     */ 
/*     */     
/*  99 */     int j = this.field_75074_b.func_78882_c() + 1;
/*     */     
/* 101 */     if (j < i) {
/* 102 */       j += p_75067_2_.nextInt(i - j);
/*     */     }
/*     */ 
/*     */     
/* 106 */     int k = j - this.field_75074_b.field_78894_e;
/* 107 */     this.field_75074_b.func_78886_a(0, k, 0);
/* 108 */     for (StructureComponent structureComponent : this.field_75075_a) {
/* 109 */       structureComponent.func_74874_b().func_78886_a(0, k, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_75070_a(World p_75070_1_, Random p_75070_2_, int p_75070_3_, int p_75070_4_) {
/* 115 */     int i = p_75070_4_ - p_75070_3_ + 1 - this.field_75074_b.func_78882_c();
/* 116 */     int j = 1;
/*     */     
/* 118 */     if (i > 1) {
/* 119 */       j = p_75070_3_ + p_75070_2_.nextInt(i);
/*     */     } else {
/* 121 */       j = p_75070_3_;
/*     */     } 
/*     */ 
/*     */     
/* 125 */     int k = j - this.field_75074_b.field_78895_b;
/* 126 */     this.field_75074_b.func_78886_a(0, k, 0);
/* 127 */     for (StructureComponent structureComponent : this.field_75075_a) {
/* 128 */       structureComponent.func_74874_b().func_78886_a(0, k, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75069_d() {
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   public int func_143019_e() {
/* 137 */     return this.field_143024_c;
/*     */   }
/*     */   
/*     */   public int func_143018_f() {
/* 141 */     return this.field_143023_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */