package org.example;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    static void main() {
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 0; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }
            if(!previousBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }

        }
        return true;
    }
}
