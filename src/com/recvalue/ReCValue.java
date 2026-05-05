package com.recvalue;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * ReCValue 的 Forge 模组入口。
 * Forge mod entry point for ReCValue.
 *
 * <p>这个类主要暴露 Forge 需要的模组元数据。
 * This class mainly exposes the metadata required by Forge.</p>
 *
 * <p>真正的数值访问逻辑位于 {@code api}、{@code base} 和 {@code util} 包中。
 * The actual value-access logic lives under the {@code api}, {@code base}, and {@code util} packages.</p>
 */
@Mod(
    modid = ReCValue.MOD_ID,
    name = ReCValue.NAME,
    version = ReCValue.VERSION,
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*",
    dependencies = "required-after:jinryuujrmcore"
)
public class ReCValue {
    /**
     * Forge 模组稳定标识。
     * Stable Forge mod identifier.
     */
    public static final String MOD_ID = "ReCValue";

    /**
     * 模组显示名称。
     * Human-readable mod name.
     */
    public static final String NAME = "ReCValue";

    /**
     * 当前源码版本标识。
     * Current reconstructed source version marker.
     */
    public static final String VERSION = "1.3.46-reconstructed";

    /**
     * 历史作者别名元数据。
     * Legacy author alias retained as metadata.
     */
    public final String authorAlias = "cocosoys";

    /**
     * 历史协作者别名元数据。
     * Legacy co-author alias retained as metadata.
     */
    public final String coAuthorAlias = "xiao";

    /**
     * 历史 B 站元数据。
     * Legacy bili metadata retained from the original project.
     */
    public final String biliUid = "77034512";

    /**
     * 历史联系方式元数据。
     * Legacy contact metadata retained from the original project.
     */
    public final String qq = "2782876939";

    /**
     * 历史论坛帖子元数据。
     * Legacy forum thread metadata retained from the original project.
     */
    public final String mcbbsThread = "https://www.mcbbs.net/thread-1157799-1-1.html";

    /**
     * 当前源码目标适配的 JRMCore 版本线。
     * Supported JRMCore version line for this reconstructed source.
     */
    public final String[] acceptedJrmcoreVersions = new String[] { "JRMCore1.3.51" };

    /**
     * 从旧项目中保留下来的赞助者元数据。
     * Simplified sponsor metadata retained from the legacy project.
     */
    public final String[] sponsorList = new String[] {
        "Legacy sponsor metadata was preserved in a simplified form during reconstruction."
    };

    /**
     * 预留的 Forge 预初始化钩子。
     * Reserved Forge pre-initialization hook.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    /**
     * 预留的 Forge 初始化钩子。
     * Reserved Forge initialization hook.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
