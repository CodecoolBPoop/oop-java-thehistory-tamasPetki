package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] textArray = text.split(" ");
        wordsArray = textArray;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        String[] temp = new String[wordsArray.length];

        int tempindex = 0;
        int counter = 0;

        for (int wordsindex = 0; wordsindex < wordsArray.length; wordsindex++) {
            if(!wordsArray[wordsindex].equals(wordToBeRemoved)) {
                temp[tempindex] = wordsArray[wordsindex];
                tempindex++;
            } else {
                counter++;
            }
        }

        wordsArray = temp;
        wordsArray = Arrays.copyOf(wordsArray,temp.length - counter);
    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        for(String word: wordsArray) {
            if(word.equals())
        }


        String [] temp = new String[wordsArray.length];

        int tempindex = 0;
        int counter = 0;

        for (int wordsindex = 0; wordsindex < wordsArray.length; wordsindex++) {
            if(!wordsArray[wordsindex].equals(fromWords[0])) {
                temp[tempindex] = wordsArray[wordsindex];
                tempindex++;
            } else {
                counter++;
            }
        }

        wordsArray = temp;
        wordsArray = Arrays.copyOf(wordsArray,temp.length - counter);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
