package com.ramkrishna.jokelib;

import java.util.ArrayList;
import java.util.Random;

public class JokeProvider {

    private static ArrayList<String> jokes;

    public JokeProvider(){
        jokes = new ArrayList<>();
        generateJokes();
    }

    public String getJokes(){
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }

    private void generateJokes(){
        jokes.add("What did the shy pebble wish for?\nThat she was a little boulder.");
        jokes.add("Did you hear about the two antennas that got married?\nThe ceremony was terrible but the reception was amazing.");
        jokes.add("What do you get when you drop a piano down a mine shaft?\nA flat miner.");
        jokes.add("What did the egg say to the boiling water?\nIt'll be a minute before I get hard. I just got laid by a chick.");
    }
}
