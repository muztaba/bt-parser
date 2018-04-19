package main.bt.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

    }

    private byte[] bytes;
    private int index = 0;

    public MetaInfo read(String path) throws IOException {
        bytes = Files.readAllBytes(Paths.get(path));

        byte currentByte = readNextByte();

        if (currentByte == -1) return new MetaInfo();

        switch (currentByte) {
            case 'd':
                readMap();
                break;
        }

        return null;
    }

    public byte readNextByte() {
        return (index < bytes.length) ? bytes[index++] : -1;
    }

    private void readMap() {

    }


}
