package com.billyoyo.cardcrawl.multiplayer.server.player;

import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 27/01/2018.
 */
public class ClientMonster extends AbstractMonster {

    public ClientMonster(ClientPlayer player) {
        // arbitrarily chosen numbers, copied from snecko so I know they won't cause any errors
        super(player.name, player.id, player.maxHealth, -30.0F, 0.0F, 310.0F, 305.0F, null);

        this.powers = player.powers;
    }

    public ClientMonsterSnapshot getSnapshot() {
        return new ClientMonsterSnapshot(this);
    }

    @Override
    public void takeTurn() {

    }

    @Override
    protected void getMove(int i) {

    }
}
