package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        String[] splittedList = text.split(" ");
        for (String element : splittedList) {
            wordsLinkedList.add(element);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsLinkedList.remove(wordToBeRemoved);
    }

    @Override
    public int size() {
        return wordsLinkedList.size();

    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int counter = 0; counter < wordsLinkedList.size(); counter++) {
            if (wordsLinkedList.get(counter).equals(from)) {
                wordsLinkedList.set(counter, to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        LinkedList<String> fromLinkedList = new LinkedList<String>(Arrays.asList(fromWords));
        LinkedList<String> toLinkedList = new LinkedList<String>(Arrays.asList(toWords));

        LinkedList<String> resultArray = new LinkedList<String>();

        Iterator<String> iter = wordsLinkedList.listIterator();

    }

        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            for (String word : wordsLinkedList) {
                sb.append(word).append(" ");
            }
            if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
            return sb.toString();
        }

    }
