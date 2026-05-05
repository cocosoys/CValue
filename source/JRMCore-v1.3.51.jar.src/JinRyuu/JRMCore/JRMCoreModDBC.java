package JinRyuu.JRMCore;

import net.minecraft.server.MinecraftServer;

public class JRMCoreModDBC {
  public static void safeOut(MinecraftServer server) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokevirtual func_71218_a : (I)Lnet/minecraft/world/WorldServer;
    //   5: astore_1
    //   6: ldc2_w 56.0
    //   9: ldc2_w 10.0
    //   12: ldc2_w 20.0
    //   15: ldc2_w 116.0
    //   18: ldc2_w 240.0
    //   21: ldc2_w 80.0
    //   24: invokestatic func_72330_a : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
    //   27: astore_2
    //   28: invokestatic DBC : ()Z
    //   31: ifeq -> 341
    //   34: getstatic JinRyuu/JRMCore/JRMCoreConfig.sfzns : Z
    //   37: ifeq -> 341
    //   40: aload_1
    //   41: ldc JinRyuu/DragonBC/common/Npcs/EntityDBCKami
    //   43: aload_2
    //   44: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface isEmpty : ()Z
    //   54: ifeq -> 57
    //   57: aload_3
    //   58: invokeinterface size : ()I
    //   63: iconst_1
    //   64: if_icmple -> 105
    //   67: iconst_1
    //   68: istore #4
    //   70: aload_3
    //   71: invokeinterface size : ()I
    //   76: iload #4
    //   78: if_icmple -> 105
    //   81: aload_3
    //   82: iload #4
    //   84: invokeinterface get : (I)Ljava/lang/Object;
    //   89: checkcast net/minecraft/entity/Entity
    //   92: astore #5
    //   94: aload #5
    //   96: invokevirtual func_70106_y : ()V
    //   99: iinc #4, 1
    //   102: goto -> 70
    //   105: aload_1
    //   106: ldc net/minecraft/entity/monster/EntityMob
    //   108: aload_2
    //   109: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
    //   112: astore #4
    //   114: aload #4
    //   116: invokeinterface size : ()I
    //   121: ifle -> 164
    //   124: iconst_0
    //   125: istore #5
    //   127: aload #4
    //   129: invokeinterface size : ()I
    //   134: iload #5
    //   136: if_icmple -> 164
    //   139: aload #4
    //   141: iload #5
    //   143: invokeinterface get : (I)Ljava/lang/Object;
    //   148: checkcast net/minecraft/entity/Entity
    //   151: astore #6
    //   153: aload #6
    //   155: invokevirtual func_70106_y : ()V
    //   158: iinc #5, 1
    //   161: goto -> 127
    //   164: aload_1
    //   165: ldc JinRyuu/DragonBC/common/Npcs/EntityDBCEvil
    //   167: aload_2
    //   168: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
    //   171: astore #5
    //   173: aload #5
    //   175: invokeinterface size : ()I
    //   180: ifle -> 223
    //   183: iconst_0
    //   184: istore #6
    //   186: aload #5
    //   188: invokeinterface size : ()I
    //   193: iload #6
    //   195: if_icmple -> 223
    //   198: aload #5
    //   200: iload #6
    //   202: invokeinterface get : (I)Ljava/lang/Object;
    //   207: checkcast net/minecraft/entity/Entity
    //   210: astore #7
    //   212: aload #7
    //   214: invokevirtual func_70106_y : ()V
    //   217: iinc #6, 1
    //   220: goto -> 186
    //   223: aload_1
    //   224: ldc JinRyuu/JRMCore/entity/EntityEnergyAtt
    //   226: aload_2
    //   227: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
    //   230: astore #6
    //   232: aload #6
    //   234: invokeinterface size : ()I
    //   239: ifle -> 282
    //   242: iconst_0
    //   243: istore #7
    //   245: aload #6
    //   247: invokeinterface size : ()I
    //   252: iload #7
    //   254: if_icmple -> 282
    //   257: aload #6
    //   259: iload #7
    //   261: invokeinterface get : (I)Ljava/lang/Object;
    //   266: checkcast net/minecraft/entity/Entity
    //   269: astore #8
    //   271: aload #8
    //   273: invokevirtual func_70106_y : ()V
    //   276: iinc #7, 1
    //   279: goto -> 245
    //   282: aload_1
    //   283: ldc JinRyuu/JRMCore/entity/EntityPunch
    //   285: aload_2
    //   286: invokevirtual func_72872_a : (Ljava/lang/Class;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
    //   289: astore #7
    //   291: aload #7
    //   293: invokeinterface size : ()I
    //   298: ifle -> 341
    //   301: iconst_0
    //   302: istore #8
    //   304: aload #7
    //   306: invokeinterface size : ()I
    //   311: iload #8
    //   313: if_icmple -> 341
    //   316: aload #7
    //   318: iload #8
    //   320: invokeinterface get : (I)Ljava/lang/Object;
    //   325: checkcast net/minecraft/entity/Entity
    //   328: astore #9
    //   330: aload #9
    //   332: invokevirtual func_70106_y : ()V
    //   335: iinc #8, 1
    //   338: goto -> 304
    //   341: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #15	-> 0
    //   #16	-> 6
    //   #17	-> 28
    //   #18	-> 40
    //   #19	-> 48
    //   #20	-> 57
    //   #21	-> 105
    //   #22	-> 114
    //   #23	-> 164
    //   #24	-> 173
    //   #25	-> 223
    //   #26	-> 232
    //   #27	-> 282
    //   #28	-> 291
    //   #30	-> 341
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   94	5	5	m	Lnet/minecraft/entity/Entity;
    //   70	35	4	i	I
    //   153	5	6	m	Lnet/minecraft/entity/Entity;
    //   127	37	5	i	I
    //   212	5	7	m	Lnet/minecraft/entity/Entity;
    //   186	37	6	i	I
    //   271	5	8	m	Lnet/minecraft/entity/Entity;
    //   245	37	7	i	I
    //   330	5	9	m	Lnet/minecraft/entity/Entity;
    //   304	37	8	i	I
    //   48	293	3	enma	Ljava/util/List;
    //   114	227	4	mobs	Ljava/util/List;
    //   173	168	5	dem	Ljava/util/List;
    //   232	109	6	eea	Ljava/util/List;
    //   291	50	7	ep	Ljava/util/List;
    //   0	342	0	server	Lnet/minecraft/server/MinecraftServer;
    //   6	336	1	dim0	Lnet/minecraft/world/WorldServer;
    //   28	314	2	aabb	Lnet/minecraft/util/AxisAlignedBB;
  }
}


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreModDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */