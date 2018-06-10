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
            if (!wordsArray[wordsindex].equals(wordToBeRemoved)) {
                temp[tempindex] = wordsArray[wordsindex];
                tempindex++;
            } else {
                counter++;
            }
        }

        wordsArray = temp;
        wordsArray = Arrays.copyOf(wordsArray, temp.length - counter);
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

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        int occurrence = 0;
        String[] checkerArray = new String[fromWords.length];


        // if fromWords greater the toWords
        if (fromWords.length > toWords.length) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (wordsArray[i].equals(fromWords[0])) {
                    if ((i + fromWords.length) < wordsArray.length) {
                        for (int x = 0; x < checkerArray.length; x++) {
                            checkerArray[x] = wordsArray[i + x];
                        }
                        if (Arrays.equals(checkerArray, fromWords)) {
                            occurrence++;
                        }
                    }
                }
            }

            String[] resultArray = new String[wordsArray.length + (fromWords.length - toWords.length) * occurrence];

            for (int check = 0, resultIndex = 0; check < wordsArray.length; check++) {

                //check if first word equals first fromWord
                if (wordsArray[check].equals(fromWords[0])) {

                    //check if the wordsArray length is longer than fromWords and the current index
                    if ((check + fromWords.length) < wordsArray.length) {

                        //if yes, then check the next part if equals
                        for (int x = 0; x < fromWords.length; x++) {
                            checkerArray[x] = wordsArray[check + x];
                        }

                        //if equals then change it to toWords
                        if (Arrays.equals(checkerArray, fromWords)) {
                            for (int y = 0; y < toWords.length; y++) {
                                resultArray[resultIndex + y] = toWords[y];
                            }

                            resultIndex = resultIndex + toWords.length;
                            check = check + fromWords.length - 1;

                            //if not, then just copy to resultArray and move on
                        } else {
                            resultArray[resultIndex] = wordsArray[check];
                            resultIndex++;
                        }
                    }
                } else {
                    resultArray[resultIndex] = wordsArray[check];
                    resultIndex++;
                }
            }
            wordsArray = resultArray;
        }

        //if toWords greater than fromWords
        if (fromWords.length < toWords.length) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (wordsArray[i].equals(fromWords[0])) {
                    if ((i + fromWords.length) < wordsArray.length) {
                        for (int x = 0; x < checkerArray.length; x++) {
                            checkerArray[x] = wordsArray[i + x];
                        }
                        if (Arrays.equals(checkerArray, fromWords)) {
                            occurrence++;
                        }
                    }
                }
            }


            String[] resultArray = new String[wordsArray.length + (toWords.length - fromWords.length) * occurrence];

            for (int check = 0, resultIndex = 0; check < wordsArray.length; check++) {

                //check if first word equals first fromWord
                if (wordsArray[check].equals(fromWords[0])) {

                    //check if the wordsArray length is longer than fromWords and the current index
                    if ((check + fromWords.length) < wordsArray.length) {

                        //if yes, then check the next part if equals
                        for (int x = 0; x < fromWords.length; x++) {
                            checkerArray[x] = wordsArray[check + x];
                        }

                        //if equals then change it to toWords
                        if (Arrays.equals(checkerArray, fromWords)) {
                            for (int y = 0; y < toWords.length; y++) {
                                resultArray[resultIndex + y] = toWords[y];
                            }

                            resultIndex = resultIndex + toWords.length;
                            check = check + fromWords.length - 1;


                            //if not, then just copy to resultArray and move on
                        } else {
                            resultArray[resultIndex] = wordsArray[check];
                            resultIndex++;
                        }
                    }
                } else {
                    resultArray[resultIndex] = wordsArray[check];
                    resultIndex++;
                }
            }
            wordsArray = resultArray;
        }


        if (fromWords.length == toWords.length) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (wordsArray[i].equals(fromWords[0])) {
                    if ((i + fromWords.length) < wordsArray.length) {
                        for (int x = 0; x < checkerArray.length; x++) {
                            checkerArray[x] = wordsArray[i + x];
                        }
                        if (Arrays.equals(checkerArray, fromWords)) {
                            for (int x = 0; x < toWords.length; x++) {
                                wordsArray[i + x] = toWords[x];
                            }
                            i = i + toWords.length - 1;
                        }
                    }
                }
            }
        }
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
