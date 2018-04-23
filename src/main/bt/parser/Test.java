package main.bt.parser;

import java.util.HashMap;
import java.util.Map;

public class Test {

    static byte[] bytes = "d5:hello2:Hi2:BD2:INe".getBytes();
    static int currentIndex = 0;

    static byte readNextByte() {
        return (currentIndex < bytes.length) ? bytes[currentIndex++] : -1;
    }

    static byte prevByte() {
        return (currentIndex >= 0) ? bytes[--currentIndex] : -1;
    }

    static int getCurrentInde() {
        return currentIndex;
    }

    public static void main(String[] args) {
        readNextByte();
        Map<String, String> map = readMap();


    }

    public void test(Map<String, String> map) {

    }

    public static Map<String, String> readMap() {
        Map<String, String> map = new HashMap<String, String>();
        byte currentByte;

        while ((currentByte = readNextByte()) != 'e') {
            prevByte();
            String key = readString();
            String value = readString();
            map.put(key, value);
        }

        return map;

    }

    public static String readString() {
        int offset = readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            sb.append((char) readNextByte());
        }
        return sb.toString();
    }

    public static int readInt() {
        StringBuilder sb = new StringBuilder();
        byte currentByte;
        while ((currentByte = readNextByte()) != ':') {
            sb.append((char) currentByte);
        }
        return Integer.parseInt(sb.toString());
    }

}
