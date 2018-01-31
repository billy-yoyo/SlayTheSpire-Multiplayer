package com.billyoyo.cardcrawl.multiplayer.test.dto;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.test.mocks.BaseMockTest;
import com.billyoyo.cardcrawl.multiplayer.test.mocks.MockTest;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.thebottom.SlaverBlue;
import com.megacrit.cardcrawl.powers.WeakPower;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by william on 29/01/2018.
 */
public class AbstractPowerDTOTests extends BaseMockTest {

    @Test
    public void can_create_a_weakpower() {
        /**/

        runTest(new MockTest() {
            @Override
            public void run() {
                int amount = 3;
                AbstractPowerDTO powerDTO = new AbstractPowerDTO(WeakPower.POWER_ID, amount);
                WeakPower power = (WeakPower) powerDTO.create(mockCreateData());

                Assert.assertNotNull(power);
                Assert.assertEquals(amount, power.amount);
            }
        });

    }

    private CreateData mockCreateData() {
        CreateData data = new CreateData();
        data.setClientId("exampleClientId");
        data.setOwner(AbstractDungeon.player);
        data.setOpponent(new SlaverBlue(0, 0));
        return data;
    }

}
