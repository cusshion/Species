package com.ninni.species.entity;

import com.ninni.species.data.GooberGooManager;
import com.ninni.species.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class GooberGoo extends ThrowableItemProjectile {

    public GooberGoo(EntityType<? extends GooberGoo> entityType, Level world) {
        super(entityType, world);
    }

    public GooberGoo(Level world, double x, double y, double z) {
        super(SpeciesEntities.GOOBER_GOO, x, y, z, world);
    }


    @Override
    public void handleEntityEvent(byte status) {
        if (status == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getDefaultItem().getDefaultInstance()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        HitResult.Type type = hitResult.getType();
        if (type != HitResult.Type.ENTITY) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        Level world = this.level();
        BlockPos blockPos = blockHitResult.getBlockPos();
        int xRadius = UniformInt.of(1, 2).sample(this.random);
        int zRadius = UniformInt.of(1, 2).sample(this.random);
        for (int y = -1; y <= 1; y++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    BlockPos placePos = BlockPos.containing(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    BlockState state = world.getBlockState(placePos);
                    BlockState aboveState = world.getBlockState(placePos.above());


                    boolean aboveStateFlag = aboveState.isAir() || aboveState.canBeReplaced();
                    for (GooberGooManager.GooberGooData data : GooberGooManager.DATA) {
                        if (!level().isClientSide && state.is(data.input()) && aboveStateFlag) {
                            Block output = data.output();
                            world.setBlock(placePos, output.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        double d = clientboundAddEntityPacket.getXa();
        double e = clientboundAddEntityPacket.getYa();
        double f = clientboundAddEntityPacket.getZa();
        for (int i = 0; i < 7; ++i) {
            double g = 0.4 + 0.1 * (double)i;
            this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), d * g, e, f * g);
        }
        this.setDeltaMovement(d, e, f);
    }

    @Override
    protected Item getDefaultItem() {
        return SpeciesItems.PETRIFIED_EGG;
    }
}

