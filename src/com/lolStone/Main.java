package com.lolStone;

import com.lolStone.client.Client;
import com.lolStone.client.Config;

public class Main {

    public static void main(String[] args) throws Exception {
        Config.loadConfig();
        Client.start();
    }
}
