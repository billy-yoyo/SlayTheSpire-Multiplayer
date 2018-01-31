package com.billyoyo.cardcrawl.multiplayer.client.listeners;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.PowerGroupEventListener;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.logging.Logger;

/**
 * Created by william on 30/01/2018.
 */
public class ClientPowerGroupListener extends PowerGroupEventListener {

    private static Logger log = Logger.getLogger(ClientPowerGroupListener.class.getName());

    private ClientHub hub;

    public ClientPowerGroupListener(ClientHub hub) {
        this.hub = hub;
    }

    private AbstractCreature getCreature(BasePowerEvent event) {
        if (event.isOwnerOpponent()) {
            return hub.getOpponent();
        } else {
            return AbstractDungeon.player;
        }
    }

    @Override
    public boolean onAddPower(AddPowerEvent event) {
        if (event.getPower() != null) {
            AbstractCreature creature = getCreature(event);

            if (creature != null) {
                creature.powers.add(event.getPower());
            }
        }

        return true;
    }

    @Override
    public boolean onClearPowers(ClearPowersEvent event) {
        AbstractCreature creature = getCreature(event);

        if (creature != null) {
            creature.powers.clear();
        }

        return true;
    }

    @Override
    public boolean onRemovePower(RemovePowerEvent event) {

        if (event.getPower() != null) {
            AbstractCreature creature = getCreature(event);

            if (creature != null) {
                AbstractPower actualPower = null;
                AbstractPower eventPower = event.getPower();

                for (AbstractPower power : creature.powers) {
                    if (AbstractPowerDTO.matches(power, eventPower)) {
                        actualPower = power;
                        break;
                    }
                }

                if (actualPower != null) {
                    creature.powers.remove(actualPower);
                } else {
                    log.warning("failed to find and remove power " + new AbstractPowerDTO(eventPower).toString());
                }
            }
        }

        return true;
    }

    @Override
    public boolean onUpdatePowers(UpdatePowersEvent event) {
        if (event.getPowers() != null) {
            AbstractCreature creature = getCreature(event);

            if (creature != null) {
                creature.powers.clear();
                creature.powers.addAll(event.getPowers());
            }
        }

        return true;
    }

}
