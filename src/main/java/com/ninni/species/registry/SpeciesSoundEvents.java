package com.ninni.species.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static com.ninni.species.Species.MOD_ID;

public class SpeciesSoundEvents {

    public static final SoundEvent WRAPTOR_DEATH = register("entity.wraptor.death");
    public static final SoundEvent WRAPTOR_HURT = register("entity.wraptor.hurt");
    public static final SoundEvent WRAPTOR_IDLE = register("entity.wraptor.idle");
    public static final SoundEvent WRAPTOR_AGGRO = register("entity.wraptor.aggro");
    public static final SoundEvent WRAPTOR_AGITATED = register("entity.wraptor.agitated");
    public static final SoundEvent WRAPTOR_ATTACK = register("entity.wraptor.attack");
    public static final SoundEvent WRAPTOR_SHEAR = register("entity.wraptor.shear");
    public static final SoundEvent WRAPTOR_STEP = register("entity.wraptor.step");
    public static final SoundEvent WRAPTOR_FEATHER_LOSS = register("entity.wraptor.feather_loss");
    public static final SoundEvent WRAPTOR_EGG = register("entity.wraptor.egg");

    public static final SoundEvent WRAPTOR_EGG_BREAK = register("block.wraptor_egg.break");
    public static final SoundEvent WRAPTOR_EGG_CRACK = register("block.wraptor_egg.crack");
    public static final SoundEvent WRAPTOR_EGG_HATCH = register("block.wraptor_egg.hatch");

    public static final SoundEvent CRACKED_WRAPTOR_EGG_SLURP = register("item.cracked_wraptor_egg.slurp");

    public static final SoundEvent DEEPFISH_DEATH = register("entity.deepfish.death");
    public static final SoundEvent DEEPFISH_HURT = register("entity.deepfish.hurt");
    public static final SoundEvent DEEPFISH_IDLE = register("entity.deepfish.idle");
    public static final SoundEvent DEEPFISH_FLOP = register("entity.deepfish.flop");

    public static final SoundEvent ROOMBUG_DEATH = register("entity.roombug.death");
    public static final SoundEvent ROOMBUG_HURT = register("entity.roombug.hurt");
    public static final SoundEvent ROOMBUG_IDLE = register("entity.roombug.idle");
    public static final SoundEvent ROOMBUG_SNORING = register("entity.roombug.snoring");
    public static final SoundEvent ROOMBUG_EAT = register("entity.roombug.eat");
    public static final SoundEvent ROOMBUG_STEP = register("entity.roombug.step");
    public static final SoundEvent ROOMBUG_GOOFY_AAH_STEP = register("entity.roombug.goofy_aah_step");

    public static final SoundEvent ENTITY_BIRT_DEATH = register("entity.birt.death");
    public static final SoundEvent ENTITY_BIRT_HURT = register("entity.birt.hurt");
    public static final SoundEvent ENTITY_BIRT_IDLE = register("entity.birt.idle");
    public static final SoundEvent ENTITY_BIRT_FLY = register("entity.birt.fly");
    public static final SoundEvent ENTITY_BIRT_MESSAGE = register("entity.birt.message");

    public static final SoundEvent BLOCK_BIRT_DWELLING_COLLECT = register("block.birt_dwelling.collect");
    public static final SoundEvent BLOCK_BIRT_DWELLING_ENTER = register("block.birt_dwelling.enter");
    public static final SoundEvent BLOCK_BIRT_DWELLING_EXIT = register("block.birt_dwelling.exit");
    public static final SoundEvent BLOCK_BIRT_DWELLING_WORK = register("block.birt_dwelling.work");

    public static final SoundEvent ENTITY_BIRTD = register("entity.birtd");

    public static final SoundEvent ITEM_BIRT_EGG_THROW = register("item.birt_egg.throw");
    public static final SoundEvent ITEM_BIRT_EGG_HIT = register("item.birt_egg.hit");

    public static final SoundEvent MUSIC_DISC_DIAL = register("music.disc.dial");

    public static final SoundEvent LIMPET_DEATH = register("entity.limpet.death");
    public static final SoundEvent LIMPET_HURT = register("entity.limpet.hurt");
    public static final SoundEvent LIMPET_IDLE = register("entity.limpet.idle");
    public static final SoundEvent LIMPET_STEP = register("entity.limpet.step");
    public static final SoundEvent LIMPET_DEFLECT = register("entity.limpet.deflect");

    public static final SoundEvent GOOBER_DEATH = register("entity.goober.death");
    public static final SoundEvent GOOBER_HURT = register("entity.goober.hurt");
    public static final SoundEvent GOOBER_IDLE = register("entity.goober.idle");
    public static final SoundEvent GOOBER_IDLE_RESTING = register("entity.goober.idle_resting");
    public static final SoundEvent GOOBER_SNEEZE = register("entity.goober.sneeze");
    public static final SoundEvent GOOBER_LAY_DOWN = register("entity.goober.lay_down");
    public static final SoundEvent GOOBER_REAR_UP = register("entity.goober.rear_up");
    public static final SoundEvent GOOBER_STEP = register("entity.goober.step");
    public static final SoundEvent GOOBER_YAWN = register("entity.goober.yawn");
    public static final SoundEvent GOOBER_EAT = register("entity.goober.eat");

    public static final SoundEvent TREEPER_DEATH = register("entity.treeper.death");
    public static final SoundEvent TREEPER_HURT = register("entity.treeper.hurt");
    public static final SoundEvent TREEPER_IDLE = register("entity.treeper.idle");
    public static final SoundEvent TREEPER_IDLE_PLANTED = register("entity.treeper.idle_planted");
    public static final SoundEvent TREEPER_PLANT = register("entity.treeper.plant");
    public static final SoundEvent TREEPER_UPROOT = register("entity.treeper.uproot");
    public static final SoundEvent TREEPER_STEP = register("entity.treeper.step");
    public static final SoundEvent TREEPER_SHAKE_FAIL = register("entity.treeper.shake_fail");
    public static final SoundEvent TREEPER_SHAKE_SUCCESS = register("entity.treeper.shake_success");

    public static final SoundEvent PETRIFIED_EGG_CRACK = register("block.petrified_egg.crack");
    public static final SoundEvent PETRIFIED_EGG_HATCH = register("block.petrified_egg.hatch");

    private static SoundEvent register(String name) {
        ResourceLocation id = new ResourceLocation(MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
