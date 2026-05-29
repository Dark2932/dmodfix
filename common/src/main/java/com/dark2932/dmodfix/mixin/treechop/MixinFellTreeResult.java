package com.dark2932.dmodfix.mixin.treechop;

import ht.treechop.common.chop.FellTreeResult;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FellTreeResult.class, remap = false)
public class MixinFellTreeResult {

    @Inject(method = "decayLeavesInsteadOfBreaking", at = @At("HEAD"), cancellable = true)
    private static void mixin$decayLeavesInsteadOfBreaking(ServerLevel level, BlockPos pos, BlockState state, CallbackInfo ci) {
        level.removeBlock(pos, false);
        for (ItemStack stack : Block.getDrops(state, level, pos, null)) {
            Block.popResource(level, pos, stack);
        }
        ci.cancel();
    }

}