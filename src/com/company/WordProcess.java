package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class WordProcess {
    public ArrayList<String> Lines;

    public WordProcess(){
        Lines = new ArrayList<>();
    }
    public void reading(String fileName) throws IOException, IndexOutOfBoundsException{
        if(fileName == null){
            throw new IOException("File cannot be found!");
        }
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String wordToRead;
        while((wordToRead = in.readLine()) != null){
            Lines.add(wordToRead);
        }
        System.out.println(Lines);
        in.close();
    }
    public void linesSwap(int firstLine, int secLine){
        int numA;
        int numB;
        numA = firstLine - 1;
        numB = secLine - 1;
        if((numA > Lines.size()) || (numB > Lines.size()) || (numA == numB)){
            throw new IndexOutOfBoundsException("You entered an invalid number! The file has" + (Lines.size() + 1) + " lines!");
        }
        Collections.swap(Lines, numA, numB);
    }
    public void wordsSwap(int firstLine, int secLine, int firstWord, int secWord) throws InputMismatchException {
        int lineNum1;
        int lineNum2;
        int lineNum3;
        int lineNum4;
        lineNum1 = firstLine - 1;
        lineNum2 = secLine - 1;
        lineNum3 = firstWord - 1;
        lineNum4 = secWord - 1;
        if((lineNum1 > Lines.size()) || (lineNum2 > Lines.size())){
            throw new IndexOutOfBoundsException("You entered a line that doesn't exist! The file has" + (Lines.size() + 1) + " lines!");
        }
        String[] firstLineWords = Lines.get(lineNum1).split("\\s+");
        if(lineNum1 != lineNum2){
            String[] secLineWords = Lines.get(lineNum2).split("\\s+");
            String firstWordData = firstLineWords[lineNum3];
            firstLineWords[lineNum3] = secLineWords[lineNum4];
            secLineWords[lineNum4] = firstWordData;
            Lines.set(lineNum1, String.join("", firstLineWords));
            Lines.set(lineNum2, String.join("", secLineWords));
        }
        else {
            String firstWordData = firstLineWords[lineNum3];
            firstLineWords[lineNum3] = firstLineWords[lineNum4];
            firstLineWords[lineNum4] = firstWordData;
            Lines.set(lineNum1, String.join("", firstLineWords));
        }
    }

    public void wordWriting(String fileName) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        for(String line : Lines){
            out.write(line);
            out.flush();
            out.newLine();
        }
        out.close();
    }
}
