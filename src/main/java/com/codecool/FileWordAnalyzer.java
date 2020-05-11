package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        String lines = "";
        try {
            lines = filePartReader.readLines();
        } catch (IOException e) {
            System.out.println(e);
        }
        List<String> words = Arrays.asList(lines.split(" "));
        Collections.sort(words);
        return words;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String lines = filePartReader.readLines();
        String[] words = lines.split(" ");
        List<String> subStringsWords = new ArrayList<>();
        for (String w : words) {
            if (w.toLowerCase().contains(subString.toLowerCase())) {
                subStringsWords.add(w);
            }
        }
        return subStringsWords;
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        String lines = filePartReader.readLines();
        String[] words = lines.split(" ");
        List<String> palindromeWords = new ArrayList<>();
        for (String w: words) {
            if (isPalindrome(w)) {
                palindromeWords.add(w);
            }
        }
        return palindromeWords;
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
