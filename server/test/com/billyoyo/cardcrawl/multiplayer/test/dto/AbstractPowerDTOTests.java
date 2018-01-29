package com.billyoyo.cardcrawl.multiplayer.test.dto;

import com.badlogic.gdx.Gdx;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.test.mocks.BaseMockTest;
import com.billyoyo.cardcrawl.multiplayer.test.mocks.MockCreature;
import com.billyoyo.cardcrawl.multiplayer.test.mocks.MockTest;
import com.megacrit.cardcrawl.powers.WeakPower;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by william on 29/01/2018.
 */
public class AbstractPowerDTOTests extends BaseMockTest {

    @Test
    // ignored until some form of integration tests can be run.
    public void can_create_a_weakpower() {
        /**/

        runTest(new MockTest() {
            @Override
            public void run() {
                int amount = 3;
                AbstractPowerDTO powerDTO = new AbstractPowerDTO(WeakPower.POWER_ID, amount);
                WeakPower power = (WeakPower) powerDTO.create(mockCreateData());

                System.out.println(power.amount);

                Assert.assertNotNull(power);
                Assert.assertEquals(amount, power.amount);
            }
        });
    }

    private CreateData mockCreateData() {
        CreateData data = new CreateData();
        data.setClientId("exampleClientId");
        data.setOwner(new MockCreature());
        data.setOpponent(new MockCreature());
        return data;
    }

}
