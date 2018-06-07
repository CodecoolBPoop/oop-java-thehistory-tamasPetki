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
        for (String element : splittedList) {
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
        for (int counter = 0; counter < wordsArrayList.size(); counter++) {
            if (wordsArrayList.get(counter).equals(from)) {
                wordsArrayList.set(counter, to);
            }
        }

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        int sizeOfArray = fromWords.length;
        ArrayList<String> fromArrayList = new ArrayList<String>(Arrays.asList(fromWords));
        ArrayList<String> toArrayList = new ArrayList<String>(Arrays.asList(toWords));

        ArrayList<String> resultArray = new ArrayList<String>();

//        if (fromWords.length == 1) {
//            for (int counter = 0; counter < wordsArrayList.size() - sizeOfArray; counter++) {
//                if (wordsArrayList.get(counter).equals(fromWords[0])) {
//                    ArrayList<String> thirdPart = new ArrayList<>(wordsArrayList.subList(counter + sizeOfArray, wordsArrayList.size()));
//                    wordsArrayList.subList(counter, wordsArrayList.size()).clear();
//                    wordsArrayList.addAll(toArrayList);
//                    wordsArrayList.addAll(thirdPart);
//                    counter = counter+toWords.length-1;
//                }
//            }
//        }
//        else{
        for (int counter = 0; counter < wordsArrayList.size(); counter++) {
            if (!wordsArrayList.get(counter).equals(fromWords[0])) {
                resultArray.add(wordsArrayList.get(counter));
            } else {
                if (counter + fromWords.length <= wordsArrayList.size()) {
                    ArrayList<String> checker = new ArrayList<>(wordsArrayList.subList(counter, counter + sizeOfArray));
                    if (checker.equals(fromArrayList)) {
                        resultArray.addAll(toArrayList);
                        if (counter + fromWords.length <= wordsArrayList.size()) {
                            counter = counter + fromWords.length - 1;
                        }
                    } else {
                        resultArray.add(wordsArrayList.get(counter));
                    }
                }

//                            ArrayList<String> thirdPart = new ArrayList<>(wordsArrayList.subList(counter + sizeOfArray, wordsArrayList.size()));
//                            wordsArrayList.subList(counter, wordsArrayList.size()).clear();
//                            wordsArrayList.addAll(toArrayList);
//                            wordsArrayList.addAll(thirdPart);
//                            counter = counter+toWords.length-1;

                //version 1 : removing one by one and inserting one by one
//                    for (int i = 0; i < sizeOfArray; i++) {
//                        wordsArrayList.remove(counter);
//                    }
//
//                    for (int i = toArrayList.size() - 1; i >= 0; i--) {
//                        wordsArrayList.add(counter, toArrayList.get(i));
//                    }
//                    counter = counter + toWords.length - 1;

                //version 2 : copy 3 arrays into one (first part+towords+second part)
//                    ArrayList<String> firstPart = new ArrayList<>(wordsArrayList.subList(0,counter));
//                    ArrayList<String> thirdPart = new ArrayList<>(wordsArrayList.subList(counter + sizeOfArray, wordsArrayList.size()));

//                    wordsArrayList.clear();

//                    wordsArrayList.addAll(firstPart);
//                    wordsArrayList.addAll(toArrayList);
//                   -other Collections.addAll(wordsArrayList, toWords);
//
//                    wordsArrayList.addAll(thirdPart);

                //version 3 : convert to array and
//                    String[] resultArray = new String[wordsArrayList.size() - fromWords.length + toWords.length];
//
//                    String[] stringArr = new String[wordsArrayList.size()];
//                    wordsArrayList.toArray(stringArr);

//                    String[] firstPart = new String[counter];
//                    String[] secondPart = new String[toWords.length];
//                    String[] thirdPart = new String[wordsArrayList.size()-1-fromWords.length+toWords.length-counter];

//                    System.arraycopy(stringArr, 0, resultArray, 0, counter);
//                    System.arraycopy(toWords, 0, resultArray, counter, toWords.length);
//                    System.arraycopy(stringArr, counter + fromWords.length, resultArray, counter + toWords.length, stringArr.length-(counter+fromWords.length));
//                    counter = counter + toWords.length - 1;
            }
        }

        wordsArrayList.clear();
        wordsArrayList = new ArrayList<>(resultArray);
    }


//        int sizeOfArray = fromWords.length;
//        boolean[] checker = new boolean[sizeOfArray];
//
//        for (int counter = 0; counter < wordsArrayList.size() - 1; counter++) {
//            if (wordsArrayList.get(counter).equals(fromWords[0])) {
//                if (wordsArrayList.size() >= counter + sizeOfArray) {
//                    for (int wordsCheck = 1; wordsCheck < sizeOfArray; wordsCheck++) {
//                        if (wordsArrayList.get(counter + wordsCheck).equals(fromWords[wordsCheck])) {
//                            checker[wordsCheck-1] = true;
//                            System.out.println("Suspicious: " + counter + " " + wordsCheck);
//                            if checker
//                        }
//                    }
//                }
//            }
//        }


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
