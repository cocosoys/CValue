package soys.dragoncore.cvalue.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public final class BasicConfig {
    public static boolean mixinEnable;

    public static Configuration config;

    public static void init(File file) {
        config=new Configuration(file);
        try {
            mixinEnable=config.getBoolean("enableMixin","misc",true,"启用Mixin修改JrmcCore,正常情况请填true,开发测试环境下建议false");
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            if(config.hasChanged()){
                config.save();
            }
        }
    }
}
