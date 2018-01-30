package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.ContinueTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.EndTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.StartTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateOpponentStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientMonster;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientMonsterSnapshot;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayer;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayerSnapshot;
import com.billyoyo.cardcrawl.multiplayer.server.room.GameRoom;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by william on 27/01/2018.
 */
public class GameSession {

    private static final int NUMBER_OF_RELICS = 5;
    private static final int NUMBER_OF_RANDOM_CARDS = 12;
    private static final boolean INCLUDE_STARTER_CARDS = true;

    private ServerHub hub;

    private ClientInfo client1;
    private ClientInfo client2;

    private ClientPlayer player1;
    private ClientPlayer player2;

    private GameRoom room = null;

    private ArrayList<AbstractRelicDTO> randomRelics;
    private ArrayList<AbstractCardDTO> randomCards;

    private Player currentPlayer = Player.FIRST;
    private boolean gameIsBusy = true;

    public GameSession(ServerHub hub, ClientInfo client1, ClientInfo client2) {
        this.hub = hub;
        this.client1 = client1;
        this.client2 = client2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameBusy() {
        return gameIsBusy;
    }

    public ClientInfo getClientInfo(String clientId) {
        return getClientInfo(getPlayer(clientId));
    }

    public Player getPlayer(String clientId) {
        if (client1.getId().equals(clientId)) {
            return Player.FIRST;
        } else if (client2.getId().equals(clientId)) {
            return Player.SECOND;
        } else {
            return null;
        }
    }

    public Player getOtherPlayer(Player player) {
        return player.choose(Player.SECOND, Player.FIRST);
    }

    public ClientInfo getClientInfo(Player player) {
        return player.choose(client1, client2);
    }

    public ClientPlayer getClientPlayer(Player player) {
        return player.choose(player1, player2);
    }

    public boolean canPlay(Player player) {
        return !isGameBusy() && getCurrentPlayer() == player;
    }

    public AbstractCard getCard(Player player, AbstractCardDTO card) {
        ClientPlayer clientPlayer = getClientPlayer(player);

        for (AbstractCard cardInHand : clientPlayer.hand.group) {
            if (card.matches(cardInHand)) {
                return cardInHand;
            }
        }

        return null;
    }

    public void playCard(Player player, AbstractCard card) {
        gameIsBusy = true;
        ClientPlayer clientPlayer = getClientPlayer(player);
        ClientPlayer opponentPlayer = getClientPlayer(getOtherPlayer(player));

        ClientInfo clientInfo = getClientInfo(player);
        ClientInfo opponentInfo = getClientInfo(getOtherPlayer(player));

        Objects.requireNonNull(clientPlayer);
        Objects.requireNonNull(clientInfo);
        Objects.requireNonNull(card);

        ClientMonster opponent = new ClientMonster(opponentPlayer);

        clientPlayer.sessionPlayCard(card, opponent);

        ClientMonsterSnapshot opponentMonsterSnapshot = opponent.getSnapshot();
        opponentMonsterSnapshot.apply(opponentPlayer);

        ClientPlayerSnapshot snapshot = clientPlayer.getSnapshot();
        ClientPlayerSnapshot opponentSnapshot = opponentPlayer.getSnapshot();

        hub.postEvent(new UpdateStatsEvent(clientInfo.getId(), snapshot));
        hub.postEvent(new UpdateOpponentStatsEvent(clientInfo.getId(), opponentSnapshot));

        hub.postEvent(new UpdateOpponentStatsEvent(opponentInfo.getId(), snapshot));
        hub.postEvent(new UpdateStatsEvent(opponentInfo.getId(), opponentSnapshot));

        hub.postEvent(new ContinueTurnEvent(clientInfo.getId()));
    }

    public void onReady(String clientId) {
        ClientInfo info = getClientInfo(getPlayer(clientId));

        info.setReady(true);
        if (client1.isReady() && client2.isReady()) {
            startGame();
        }
    }

    public void startGame() {
        gameIsBusy = true;
        currentPlayer = Player.FIRST;

        player1 = new ClientPlayer(hub, client1, client1.getName(), client1.getPlayerClass());
        player2 = new ClientPlayer(hub, client2, client2.getName(), client2.getPlayerClass());

        room = new GameRoom();
        StaticGameHandler.switchToRoom(room);

        generateCards();
        generateRelics();

        StaticGameHandler.switchToPlayer(player1);
        player1.sessionSetDeck(randomCards);
        player1.sessionSetRelics(randomRelics);
        player1.sessionStartGame(room);

        StaticGameHandler.switchToPlayer(player2);
        player2.sessionSetDeck(randomCards);
        player2.sessionSetRelics(randomRelics);
        player2.sessionStartGame(room);

        StaticGameHandler.switchToPlayer(getClientPlayer(currentPlayer));
        startPlayerTurn(currentPlayer, true);
    }

    public void endTurn() {
        gameIsBusy = true;
        switch (currentPlayer) {
            case SECOND:
                currentPlayer = Player.FIRST;

                endPlayerTurn(Player.SECOND);
                StaticGameHandler.switchToPlayer(getClientPlayer(currentPlayer));
                startPlayerTurn(Player.FIRST, false);
                break;
            default:
                currentPlayer = Player.SECOND;

                endPlayerTurn(Player.FIRST);
                StaticGameHandler.switchToPlayer(getClientPlayer(currentPlayer));
                startPlayerTurn(Player.SECOND, false);
                break;
        }
    }

    private void endPlayerTurn(Player player) {
        ClientInfo clientInfo = getClientInfo(player);
        ClientPlayer clientPlayer = getClientPlayer(player);

        hub.postEvent(new EndTurnEvent(clientInfo.getId()));
        clientPlayer.sessionEndTurn();
    }

    private void startPlayerTurn(Player player, boolean firstTurn) {
        ClientInfo clientInfo = getClientInfo(player);
        ClientPlayer clientPlayer = getClientPlayer(player);

        gameIsBusy = false;
        hub.postEvent(new StartTurnEvent(clientInfo.getId()));
        clientPlayer.sessionStartTurn(firstTurn);
    }

    private void continuePlayerTurn(Player player) {
        ClientInfo clientInfo = getClientInfo(player);

        gameIsBusy = false;
        hub.postEvent(new ContinueTurnEvent(clientInfo.getId()));
    }

    private void generateRelics() {
        randomRelics = new ArrayList<>();

        List<AbstractRelic> options = new ArrayList<>();
        options.addAll(RelicLibrary.bossList);
        options.addAll(RelicLibrary.commonList);
        options.addAll(RelicLibrary.rareList);
        options.addAll(RelicLibrary.shopList);
        options.addAll(RelicLibrary.redList);

        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_RELICS; i++) {
            AbstractRelic relic = options.get(random.nextInt(options.size()));
            options.remove(relic);
            randomRelics.add(new AbstractRelicDTO(relic));
        }
    }

    private void generateCards() {
        randomCards = new ArrayList<>();

        if (INCLUDE_STARTER_CARDS) {
            List<String> startingDeck = Ironclad.getStartingDeck();
            for (String card : startingDeck) {
                randomCards.add(new AbstractCardDTO(CardLibrary.getCard(card)));
            }
        }

        ArrayList<AbstractCard> options = CardLibrary.getAllCards();
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_RANDOM_CARDS; i++) {
            AbstractCard card = options.get(random.nextInt(options.size()));
            randomCards.add(new AbstractCardDTO(card));
        }
    }

    public enum Player {
        FIRST,
        SECOND;

        private <T> T choose(T option1, T option2) {
            switch (this) {
                case FIRST:
                    return option1;
                case SECOND:
                    return option2;
            }
            return null;
        }
    }
}
