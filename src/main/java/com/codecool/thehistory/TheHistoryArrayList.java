package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] splittedList = text.split(" ");
        for (String element: splittedList) {
            wordsArrayList.add(element);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.remove(wordToBeRemoved);
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        /* Version 1 - 120ms */
//        Iterator<String> iter = wordsArrayList.iterator();
//
//        int indexCounter = 0;
//
//        while(iter.hasNext()) {
//            String value = iter.next();
//            if(value.equals(from)) {
//                wordsArrayList.set(indexCounter,to);
//            }
//            indexCounter++;
//        }


        /* Version 2 - 167ms */
//        ListIterator<String> iter = wordsArrayList.listIterator();
//
//        while (iter.hasNext()) {
//            if(iter.next().equals(from)) {
//                iter.set(to);
//            }
//        }

        /* Version 3 - 63ms */
        for(int counter=0; counter < wordsArrayList.size(); counter++) {
            if(wordsArrayList.get(counter).equals(from)) {
                wordsArrayList.set(counter, to);
            }
        }

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
