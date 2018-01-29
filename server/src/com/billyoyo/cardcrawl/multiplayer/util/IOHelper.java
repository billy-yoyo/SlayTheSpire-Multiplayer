package com.billyoyo.cardcrawl.multiplayer.util;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class IOHelper {

    public static final String STRING_BYTE_ENCODING = "UTF-8";
    public static final ByteOrder NUMBER_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    public static final int NUMBER_BYTES = 4;
    public static final int BUFFER_SIZE = 1024;

    public static boolean charIsDigit(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3'
                || c == '4' || c == '5' || c == '6' || c == '7'
                || c == '8' || c == '9';
    }

    public static String stringFromBytes(byte[] bytes, boolean lengthRead) throws IOException {
        byte[] actualString = bytes;
        if (!lengthRead) {
            actualString = new byte[bytes.length - NUMBER_BYTES];
            System.arraycopy(bytes, NUMBER_BYTES, actualString, 0, actualString.length);
        }

        return new String(actualString, STRING_BYTE_ENCODING);
    }

    public static String stringFromBytes(byte[] bytes) throws IOException {
        return stringFromBytes(bytes, false);
    }

    public static int numberFromBytes(byte[] number) throws IOException {
        if (number.length != NUMBER_BYTES) {
            throw new IOException("invalid length for number, must be " + NUMBER_BYTES + " bytes");
        }

        return ByteBuffer.wrap(number).order(NUMBER_BYTE_ORDER).getInt();
    }

    private static boolean booleanFromByte(int b) throws IOException {
        if (b != 0 && b != 1) {
            throw new IOException("invalid boolean byte");
        }

        return b == 1;
    }

    public static boolean booleanFromBytes(byte[] bool) throws IOException {
        if (bool.length != 1) {
            throw new IOException("invalid length for bool, must be 1 byte");
        }

        return booleanFromByte(bool[0]);
    }

    /*
     * variable -> bytes methods
     */

    public static byte[] combineByteArrays(byte[] first, byte[] second) {
        byte[] combined = new byte[first.length + second.length];

        System.arraycopy(first, 0, combined, 0, first.length);
        System.arraycopy(second, 0, combined, first.length, second.length);

        return combined;
    }


    public static byte[] bytesForNumber(int number) {
        return ByteBuffer.allocate(NUMBER_BYTES).order(NUMBER_BYTE_ORDER).putInt(number).array();
    }

    public static byte[] bytesForSingleByteInt(int b) {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) b;
        return bytes;
    }

    public static byte[] bytesForString(String s) throws UnsupportedEncodingException {
        if (s == null) {
            return new byte[0];
        }

        byte[] stringBytes = s.getBytes(STRING_BYTE_ENCODING);
        byte[] stringLengthBytes = bytesForNumber(stringBytes.length);

        return combineByteArrays(stringLengthBytes, stringBytes);
    }

    public static byte[] bytesForBoolean(boolean bool) {
        return bytesForSingleByteInt(bool ? 1 : 0);
    }

    public static byte[] joinBytes(List<byte[]> dataList) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        output.write(bytesForSingleByteInt(dataList.size()));
        for (byte[] data : dataList) {
            output.write(bytesForNumber(data.length));
            output.write(data);
        }

        return output.toByteArray();
    }

    /*
     * bytes -> variable method
     */

    public static int readByte(InputStream input) throws IOException {
        int b = input.read();

        if (b < 0) {
            throw new IOException("failed to read byte, input stream terminated");
        }

        return b;
    }

    public static int readNumber(InputStream input) throws IOException {
        byte[] number = new byte[NUMBER_BYTES];
        int read = input.read(number);

        if (read != number.length) {
            throw new IOException("failed to read 4 bytes for number, input stream terminated");
        }

        return numberFromBytes(number);
    }

    private static byte[] bufferedReadBytes(InputStream input, int length) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int left = length;
        int read;

        while (left > 0 && (read = input.read(buffer, 0, Math.min(left, buffer.length))) != -1) {
            baos.write(buffer, 0, read);
            left -= read;
        }

        baos.flush();

        if (left > 0) {
            throw new IOException("failed to read all bytes for string, input stream terminated");
        }

        return baos.toByteArray();
    }

    public static String readString(InputStream input) throws IOException {
        int length = readNumber(input);
        return stringFromBytes(bufferedReadBytes(input, length), true);
    }

    public static boolean readBoolean(InputStream input) throws IOException {
        int b = readByte(input);

        return booleanFromByte(b);
    }

    public static List<byte[]> readDataList(InputStream input) throws IOException {
        int length = readByte(input);

        List<byte[]> dataList = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            int dataLength = readNumber(input);
            byte[] data = bufferedReadBytes(input, dataLength);
            dataList.add(data);
        }

        return dataList;
    }
}
