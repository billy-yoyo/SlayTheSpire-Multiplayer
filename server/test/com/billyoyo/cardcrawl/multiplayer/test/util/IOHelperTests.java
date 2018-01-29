package com.billyoyo.cardcrawl.multiplayer.test.util;

import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 29/01/2018.
 */
public class IOHelperTests {

    @Test
    public void can_write_and_decode_datalists() throws IOException {
        List<byte[]> dataList = new ArrayList<>();
        String id = "exampleId";

        dataList.add(IOHelper.bytesForString(id));
        dataList.add(new byte[] {103, 1});

        byte[] joined = IOHelper.joinBytes(dataList);

        List<byte[]> recreated = IOHelper.readDataList(new ByteArrayInputStream(joined));

        Assert.assertEquals(dataList.size(), recreated.size());

        for (int i = 0; i < recreated.size(); i++) {
            Assert.assertArrayEquals(dataList.get(i), recreated.get(i));
        }

        String recreatedId = IOHelper.stringFromBytes(recreated.get(0));

        Assert.assertEquals(id, recreatedId);
    }
}
