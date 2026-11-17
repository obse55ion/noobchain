package org.example;

import java.util.Date;

public class Block {

    public String hash;
    public String prevHash;
    private String data;
    private long timeStamp;

    public Block(String prevHash, String data) {
        this.prevHash = prevHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
    }
}
