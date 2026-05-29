package com.dark2932.dmodfix.mixin.verdant;

import com.ordana.verdant.dynamicpack.ClientDynamicResourcesHandler;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ClientDynamicResourcesHandler.class, remap = false)
public class MixinClientDynamicResourcesHandler {

    //AI辅助完成
    @Redirect(method = "lambda$regenerateDynamicAssets$2", at = @At(value = "INVOKE", target = "Lnet/mehvahdjukaar/moonlight/api/resources/textures/TextureOps;makeOpaque(Lnet/mehvahdjukaar/moonlight/api/resources/textures/TextureImage;I)V"))
    private static void makeOpaque(TextureImage img, int backgroundColor) {
        int newColor = backgroundColor | 0xFF000000;
        img.forEachPixel(pixel -> {
            int oldColor = pixel.getValue();
            int alpha = (oldColor >> 24) & 0xFF;
            if (alpha == 0) {
                pixel.setValue(newColor);
            } else {
                pixel.setValue(oldColor | 0xFF000000);
            }
        });
    }

}
