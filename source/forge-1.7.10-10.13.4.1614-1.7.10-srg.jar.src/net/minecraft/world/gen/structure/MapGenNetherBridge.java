/*    */ package net.minecraft.world.gen.structure;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.monster.EntityPigZombie;
/*    */ import net.minecraft.entity.monster.EntitySkeleton;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class MapGenNetherBridge extends MapGenStructure {
/* 11 */   private List field_75060_e = new ArrayList();
/*    */   
/*    */   private static final String __OBFID = "CL_00000451";
/*    */   
/*    */   public MapGenNetherBridge() {
/* 16 */     this.field_75060_e.add(new BiomeGenBase.SpawnListEntry(EntityBlaze.class, 10, 2, 3));
/* 17 */     this.field_75060_e.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
/* 18 */     this.field_75060_e.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
/* 19 */     this.field_75060_e.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_143025_a() {
/* 24 */     return "Fortress";
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_75059_a() {
/* 29 */     return this.field_75060_e;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
/* 35 */     int i = p_75047_1_ >> 4;
/* 36 */     int j = p_75047_2_ >> 4;
/*    */     
/* 38 */     this.field_75038_b.setSeed((i ^ j << 4) ^ this.field_75039_c.func_72905_C());
/* 39 */     this.field_75038_b.nextInt();
/*    */     
/* 41 */     if (this.field_75038_b.nextInt(3) != 0) {
/* 42 */       return false;
/*    */     }
/* 44 */     if (p_75047_1_ != (i << 4) + 4 + this.field_75038_b.nextInt(8)) {
/* 45 */       return false;
/*    */     }
/* 47 */     if (p_75047_2_ != (j << 4) + 4 + this.field_75038_b.nextInt(8)) {
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
/* 55 */     return new Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Start
/*    */     extends StructureStart
/*    */   {
/*    */     private static final String __OBFID = "CL_00000452";
/*    */ 
/*    */     
/*    */     public Start() {}
/*    */ 
/*    */     
/*    */     public Start(World p_i2040_1_, Random p_i2040_2_, int p_i2040_3_, int p_i2040_4_) {
/* 70 */       super(p_i2040_3_, p_i2040_4_);
/*    */       
/* 72 */       StructureNetherBridgePieces.Start start = new StructureNetherBridgePieces.Start(p_i2040_2_, (p_i2040_3_ << 4) + 2, (p_i2040_4_ << 4) + 2);
/* 73 */       this.field_75075_a.add(start);
/* 74 */       start.func_74861_a(start, this.field_75075_a, p_i2040_2_);
/*    */       
/* 76 */       ArrayList<StructureComponent> arrayList = start.field_74967_d;
/* 77 */       while (!arrayList.isEmpty()) {
/* 78 */         int i = p_i2040_2_.nextInt(arrayList.size());
/* 79 */         StructureComponent structureComponent = arrayList.remove(i);
/* 80 */         structureComponent.func_74861_a(start, this.field_75075_a, p_i2040_2_);
/*    */       } 
/*    */       
/* 83 */       func_75072_c();
/* 84 */       func_75070_a(p_i2040_1_, p_i2040_2_, 48, 70);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenNetherBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */