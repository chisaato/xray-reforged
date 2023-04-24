package fr.atesab.xray.mixins;

import fr.atesab.xray.XrayMain;
import me.jellysquid.mods.sodium.client.render.occlusion.BlockOcclusionCache;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockOcclusionCache.class)
public class MixinRubidiumBlockOcclusionCache {
    @Inject(at = @At("RETURN"), method = "shouldDrawSide", cancellable = true, remap = false)
    public void shouldDrawSide(BlockState state,
                                       BlockGetter reader,
                                       BlockPos pos,
                                       Direction face,
                                       CallbackInfoReturnable<Boolean> ci) {
        XrayMain.getMod().shouldSideBeRendered(state, reader, pos, face, ci);
    }

    private MixinRubidiumBlockOcclusionCache() {
    }
}
