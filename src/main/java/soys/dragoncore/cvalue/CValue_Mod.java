package soys.dragoncore.cvalue;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import soys.dragoncore.cvalue.command.CValueCommand;
import soys.dragoncore.cvalue.common.CommonProxy;
import soys.dragoncore.cvalue.config.BasicConfig;

import java.util.logging.LogManager;

@Mod(modid = CValue_Mod.MODID, version = CValue_Mod.VERSION, acceptedMinecraftVersions= "1.7.10", acceptableRemoteVersions= "*")
public class CValue_Mod
{
    public static final String MODID = "re_cvalue";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "soys.dragoncore.cvalue.common.CommonProxy",clientSide = "soys.dragoncore.cvalue.client.ClientPorxy")
    public static CommonProxy proxy;

    public static boolean update=true;


    public final String 作者创作名="cocosoys";
    public final String 作者="不打酱油的酱油君--xiao";
    public final String B站uid="77034512";
    public final String QQ="2782876939";
    public final String mcbbs="https://www.mcbbs.net/thread-1157799-1-1.html";
    public final String[] 赞助名单=new String[]{
            "非常感谢 湫(752556267) 提出CValue的制作!赞助了30RMB",
            "感谢 王陌少(783409442) 对CValue的支持!赞助了30RMB",
            "感谢 Kong'Shao(3176336132) 对CValue的肯定!赞助了30RMB",
            "排列按赞助时间顺序排序,CValue于今日(2021.7.12)正式免费!且持续更新!"
    };
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    @EventHandler
    public void load(FMLPreInitializationEvent event){
        proxy.load(event);
        try{
            BasicConfig.init(event.getSuggestedConfigurationFile());
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if(BasicConfig.config==null){
                BasicConfig.config.save();
            }
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CValueCommand());
    }
}
