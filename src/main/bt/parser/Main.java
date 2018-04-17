package main.bt.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        byte[] btbyte = Files.readAllBytes(Paths.get("thePost.torrent"));

        for (byte i :
                btbyte) {
            System.out.println((char) i);
        }
    }
}
