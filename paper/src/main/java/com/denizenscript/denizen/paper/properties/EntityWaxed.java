package com.denizenscript.denizen.paper.properties;

import com.denizenscript.denizen.objects.EntityTag;
import com.denizenscript.denizen.objects.properties.entity.EntityProperty;
import com.denizenscript.denizencore.objects.Mechanism;
import com.denizenscript.denizencore.objects.core.ElementTag;
import org.bukkit.entity.CopperGolem;

public class EntityWaxed extends EntityProperty<ElementTag> {

    // <--[property]
    // @object EntityTag
    // @name waxed
    // @input ElementTag(Boolean)
    // @plugin Paper
    // @description
    // Controls whether a copper golem is waxed.
    // -->

    public static boolean describes(EntityTag entity) {
        return entity.getBukkitEntity() instanceof CopperGolem;
    }

    @Override
    public ElementTag getPropertyValue() {
        return new ElementTag(as(CopperGolem.class).getOxidizing() == CopperGolem.Oxidizing.waxed());
    }

    @Override
    public boolean isDefaultValue(ElementTag value) {
        return !value.asBoolean();
    }

    @Override
    public void setPropertyValue(ElementTag value, Mechanism mechanism) {
        if (mechanism.requireBoolean()) {
            as(CopperGolem.class).setOxidizing(value.asBoolean() ? CopperGolem.Oxidizing.waxed() : CopperGolem.Oxidizing.unset());
        }
    }

    @Override
    public String getPropertyId() {
        return "waxed";
    }

    public static void register() {
        autoRegister("waxed", EntityWaxed.class, ElementTag.class, false);
    }
}
