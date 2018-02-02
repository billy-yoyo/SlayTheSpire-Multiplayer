package com.billyoyo.cardcrawl.multiplayer.client.listeners;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.AddRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.ClearRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.RemoveRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.UpdateRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.RelicGroupEventListener;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.logging.Logger;

/**
 * Created by william on 30/01/2018.
 */
public class ClientRelicGroupListener extends RelicGroupEventListener {

    private static Logger log = Logger.getLogger(ClientRelicGroupListener.class.getName());

    private ClientHub hub;

    public ClientRelicGroupListener(ClientHub hub) {
        this.hub = hub;
    }

    @Override
    public boolean onAddRelic(AddRelicEvent event) {

        if (AbstractDungeon.player != null) {
            log.info("adding relic " + event.getRelic().relicId);
            AbstractDungeon.player.relics.add(event.getRelic());
        }

        return true;
    }

    @Override
    public boolean onClearRelics(ClearRelicsEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractDungeon.player.relics.clear();
        }

        return true;
    }

    @Override
    public boolean onRemoveRelic(RemoveRelicEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractRelic actualRelic = null;
            AbstractRelic eventRelic = event.getRelic();

            for (AbstractRelic relic : AbstractDungeon.player.relics) {
                if (AbstractRelicDTO.matches(relic, eventRelic)) {
                    actualRelic = relic;
                    break;
                }
            }

            if (actualRelic != null) {
                AbstractDungeon.player.relics.remove(actualRelic);
            } else {
                log.warning("failed to find and remove relic " + new AbstractRelicDTO(eventRelic).toString());
            }
        }

        return true;
    }

    @Override
    public boolean onUpdateRelics(UpdateRelicsEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractDungeon.player.relics.clear();
            AbstractDungeon.player.relics.addAll(event.getRelics());
        }

        return true;
    }

}
