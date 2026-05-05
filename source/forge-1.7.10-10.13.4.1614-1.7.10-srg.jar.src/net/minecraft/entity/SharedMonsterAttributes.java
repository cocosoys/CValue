/*    */ package net.minecraft.entity;
/*    */ import java.util.Collection;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.entity.ai.attributes.IAttribute;
/*    */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*    */ import net.minecraft.entity.ai.attributes.RangedAttribute;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ public class SharedMonsterAttributes {
/* 11 */   private static final Logger field_151476_f = LogManager.getLogger();
/* 12 */   public static final IAttribute field_111267_a = (IAttribute)(new RangedAttribute("generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).func_111117_a("Max Health").func_111112_a(true);
/* 13 */   public static final IAttribute field_111265_b = (IAttribute)(new RangedAttribute("generic.followRange", 32.0D, 0.0D, 2048.0D)).func_111117_a("Follow Range");
/* 14 */   public static final IAttribute field_111266_c = (IAttribute)(new RangedAttribute("generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).func_111117_a("Knockback Resistance");
/* 15 */   public static final IAttribute field_111263_d = (IAttribute)(new RangedAttribute("generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).func_111117_a("Movement Speed").func_111112_a(true);
/* 16 */   public static final IAttribute field_111264_e = (IAttribute)new RangedAttribute("generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE); private static final String __OBFID = "CL_00001695";
/*    */   
/*    */   public static NBTTagList func_111257_a(BaseAttributeMap p_111257_0_) {
/* 19 */     NBTTagList nBTTagList = new NBTTagList();
/*    */     
/* 21 */     for (IAttributeInstance iAttributeInstance : p_111257_0_.func_111146_a()) {
/* 22 */       nBTTagList.func_74742_a((NBTBase)func_111261_a(iAttributeInstance));
/*    */     }
/*    */     
/* 25 */     return nBTTagList;
/*    */   }
/*    */   
/*    */   private static NBTTagCompound func_111261_a(IAttributeInstance p_111261_0_) {
/* 29 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 30 */     IAttribute iAttribute = p_111261_0_.func_111123_a();
/*    */     
/* 32 */     nBTTagCompound.func_74778_a("Name", iAttribute.func_111108_a());
/* 33 */     nBTTagCompound.func_74780_a("Base", p_111261_0_.func_111125_b());
/*    */     
/* 35 */     Collection collection = p_111261_0_.func_111122_c();
/*    */     
/* 37 */     if (collection != null && !collection.isEmpty()) {
/* 38 */       NBTTagList nBTTagList = new NBTTagList();
/*    */       
/* 40 */       for (AttributeModifier attributeModifier : collection) {
/* 41 */         if (attributeModifier.func_111165_e()) {
/* 42 */           nBTTagList.func_74742_a((NBTBase)func_111262_a(attributeModifier));
/*    */         }
/*    */       } 
/*    */       
/* 46 */       nBTTagCompound.func_74782_a("Modifiers", (NBTBase)nBTTagList);
/*    */     } 
/*    */     
/* 49 */     return nBTTagCompound;
/*    */   }
/*    */   
/*    */   private static NBTTagCompound func_111262_a(AttributeModifier p_111262_0_) {
/* 53 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*    */     
/* 55 */     nBTTagCompound.func_74778_a("Name", p_111262_0_.func_111166_b());
/* 56 */     nBTTagCompound.func_74780_a("Amount", p_111262_0_.func_111164_d());
/* 57 */     nBTTagCompound.func_74768_a("Operation", p_111262_0_.func_111169_c());
/* 58 */     nBTTagCompound.func_74772_a("UUIDMost", p_111262_0_.func_111167_a().getMostSignificantBits());
/* 59 */     nBTTagCompound.func_74772_a("UUIDLeast", p_111262_0_.func_111167_a().getLeastSignificantBits());
/*    */     
/* 61 */     return nBTTagCompound;
/*    */   }
/*    */   
/*    */   public static void func_151475_a(BaseAttributeMap p_151475_0_, NBTTagList p_151475_1_) {
/* 65 */     for (byte b = 0; b < p_151475_1_.func_74745_c(); b++) {
/* 66 */       NBTTagCompound nBTTagCompound = p_151475_1_.func_150305_b(b);
/* 67 */       IAttributeInstance iAttributeInstance = p_151475_0_.func_111152_a(nBTTagCompound.func_74779_i("Name"));
/*    */       
/* 69 */       if (iAttributeInstance != null) {
/* 70 */         func_111258_a(iAttributeInstance, nBTTagCompound);
/*    */       } else {
/* 72 */         field_151476_f.warn("Ignoring unknown attribute '" + nBTTagCompound.func_74779_i("Name") + "'");
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void func_111258_a(IAttributeInstance p_111258_0_, NBTTagCompound p_111258_1_) {
/* 78 */     p_111258_0_.func_111128_a(p_111258_1_.func_74769_h("Base"));
/*    */     
/* 80 */     if (p_111258_1_.func_150297_b("Modifiers", 9)) {
/* 81 */       NBTTagList nBTTagList = p_111258_1_.func_150295_c("Modifiers", 10);
/*    */       
/* 83 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 84 */         AttributeModifier attributeModifier1 = func_111259_a(nBTTagList.func_150305_b(b));
/* 85 */         AttributeModifier attributeModifier2 = p_111258_0_.func_111127_a(attributeModifier1.func_111167_a());
/* 86 */         if (attributeModifier2 != null) p_111258_0_.func_111124_b(attributeModifier2); 
/* 87 */         p_111258_0_.func_111121_a(attributeModifier1);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static AttributeModifier func_111259_a(NBTTagCompound p_111259_0_) {
/* 93 */     UUID uUID = new UUID(p_111259_0_.func_74763_f("UUIDMost"), p_111259_0_.func_74763_f("UUIDLeast"));
/* 94 */     return new AttributeModifier(uUID, p_111259_0_.func_74779_i("Name"), p_111259_0_.func_74769_h("Amount"), p_111259_0_.func_74762_e("Operation"));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\SharedMonsterAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */