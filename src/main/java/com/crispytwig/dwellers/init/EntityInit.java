package com.crispytwig.dwellers.init;

import com.crispytwig.dwellers.Dwellers;
import com.crispytwig.dwellers.entity.Beetle;
import com.crispytwig.dwellers.entity.Dweller;
import com.crispytwig.dwellers.entity.Grub;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Dwellers.MODID);

    public static final RegistryObject<EntityType<Dweller>> DWELLER = ENTITY_TYPES.register("dweller",
            () -> EntityType.Builder.<Dweller>of(Dweller::new, MobCategory.MISC).sized(0.6F, 1.95F)
                    .build(new ResourceLocation(Dwellers.MODID, "dweller").toString()));

    public static final RegistryObject<EntityType<Beetle>> BEETLE = ENTITY_TYPES.register("beetle",
            () -> EntityType.Builder.of(Beetle::new, MobCategory.CREATURE).sized(1.0F, 0.6F)
                    .build(new ResourceLocation(Dwellers.MODID, "beetle").toString()));

    public static final RegistryObject<EntityType<Grub>> GRUB = ENTITY_TYPES.register("grub",
            () -> EntityType.Builder.of(Grub::new, MobCategory.CREATURE).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(Dwellers.MODID, "grub").toString()));
}
