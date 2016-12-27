package com.ramkrishna.jokelib;

/**
 * Created by ramkrishna on 27/12/16.
 */

public class Joke {
    String joke;

    public Joke(){}

    public Joke(String joke){this.joke = joke;}

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
