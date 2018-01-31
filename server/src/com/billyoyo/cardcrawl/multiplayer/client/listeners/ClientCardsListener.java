package com.billyoyo.cardcrawl.multiplayer.client.listeners;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.CardGroupEventListener;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.logging.Logger;

/**
 * Created by william on 30/01/2018.
 */
public class ClientCardsListener extends CardGroupEventListener {

    private static Logger log = Logger.getLogger(ClientCardsListener.class.getName());

    private ClientHub hub;

    public ClientCardsListener(ClientHub hub) {
        this.hub = hub;
    }

    private CardGroup getCardGroup(CardGroup.CardGroupType type) {
        AbstractPlayer player = AbstractDungeon.player;

        if (player == null) {
            return null;
        }

        switch (type) {
            case DRAW_PILE:
                return player.drawPile;
            case MASTER_DECK:
                return player.masterDeck;
            case HAND:
                return player.hand;
            case DISCARD_PILE:
                return player.discardPile;
            case EXHAUST_PILE:
                return player.exhaustPile;
            case UNSPECIFIED:
                return player.limbo;
        }

        return null;
    }

    private CardGroup getCardGroup(BaseCardGroupEvent event) {
        return getCardGroup(event.getCardGroupType());
    }

    @Override
    public boolean onCardAdd(CardAddGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null && event.getCard() != null) {
            int position = event.getPosition();

            // add to bottom
            if (position == -1) {
                group.addToBottom(event.getCard());
            } else if (position == 0) {
                group.addToTop(event.getCard());
            } else {
                group.group.add(position, event.getCard());
            }
        }

        return true;
    }

    @Override
    public boolean onCardApplyPowers(CardApplyPowersGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null) {
            group.applyPowers();
        }

        return true;
    }

    @Override
    public boolean onCardRemove(CardRemoveGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null && event.getCard() != null) {
            AbstractCard actualCard = null;
            AbstractCard eventCard = event.getCard();

            for (AbstractCard card : group.group) {
                if (AbstractCardDTO.matches(card, eventCard)) {
                    actualCard = card;
                    break;
                }
            }

            if (actualCard != null) {
                group.removeCard(actualCard);
            } else {
                log.warning("failed to find card " + new AbstractCardDTO(eventCard).toString() + " in hand");
            }
        }

        return true;
    }

    @Override
    public boolean onCardRemoveId(CardRemoveIdGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null && event.getTargetId() != null) {
            group.removeCard(event.getTargetId());
        }

        return true;
    }

    @Override
    public boolean onClearCards(ClearCardsGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null) {
            group.clear();
        }

        return true;
    }

    @Override
    public boolean onDiscardAll(DiscardAllGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null) {
            group.clear();
        }

        return true;
    }

    @Override
    public boolean onRemoveTopCard(RemoveTopCardGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null) {
            group.removeTopCard();
        }

        return true;
    }

    @Override
    public boolean onUpdateCards(UpdateCardsGroupEvent event) {
        CardGroup group = getCardGroup(event);

        if (group != null && event.getCards() != null) {
            group.clear();
            group.group.addAll(event.getCards());
        }

        return true;
    }

}
