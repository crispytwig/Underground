package com.crispytwig.dwellers.entity;

import com.crispytwig.dwellers.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class Grub extends AgeableMob {
    public static int ticksToBeBeetle = Math.abs(-200);
    public final AnimationState walkAnimationState = new AnimationState();
    public Grub(EntityType<? extends AgeableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        // this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    public void tick() {
        super.tick();
            if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
                this.walkAnimationState.startIfStopped(tickCount);
            } else {
                this.walkAnimationState.stop();
            }

    }

    private boolean isFood(ItemStack pStack) {
        return Items.HANGING_ROOTS.equals(pStack.getItem());
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.isFood(itemstack)) {
            this.feed(pPlayer, itemstack);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    private void feed(Player pPlayer, ItemStack pStack) {
        this.usePlayerItem(pPlayer, pStack);
        this.ageUp(AgeableMob.getSpeedUpSecondsWhenFeeding(this.getTicksLeftUntilAdult()));
        this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
    }

    private void usePlayerItem(Player pPlayer, ItemStack pStack) {
        if (!pPlayer.getAbilities().instabuild) {
            pStack.shrink(1);
        }

    }

    @Override
    public void setAge(int pAge) {
        this.age = pAge;
        if (this.age >= ticksToBeBeetle) {
            this.ageUp();
        }

    }

    private void ageUp() {
        Level $$1 = this.level;
        if ($$1 instanceof ServerLevel serverlevel) {
            Beetle beetle = EntityInit.BEETLE.get().create(serverlevel);
            beetle.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
            beetle.finalizeSpawn(serverlevel, this.level.getCurrentDifficultyAt(beetle.blockPosition()), MobSpawnType.CONVERSION, null, null);
            beetle.setNoAi(this.isNoAi());
            if (this.hasCustomName()) {
                beetle.setCustomName(this.getCustomName());
                beetle.setCustomNameVisible(this.isCustomNameVisible());
            }
            beetle.setPersistenceRequired();
            this.playSound(SoundEvents.TADPOLE_GROW_UP, 0.15F, 1.0F);
            serverlevel.addFreshEntityWithPassengers(beetle);
            this.discard();
        }
    }

    private int getTicksLeftUntilAdult() {
        return Math.max(0, ticksToBeBeetle - this.age);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
}
