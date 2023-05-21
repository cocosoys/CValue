package soys.dragoncore.cvalue.core.mixin;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.JGPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = JGPlayerMP.class,remap = false)
public class MixinJRMCoreLevel {

    /**
     * @author soys
     * @reason first test
     */
    @Overwrite
    public int getLevel(int[] PlyrAttrbts) {
        return 55;
    }
}
