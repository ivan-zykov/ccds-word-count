package net.ivanzykov.wordcounter.runner;

import java.util.List;

public class WordCount {

    private List<String> stopWords;
    private final String stopWordsFileName;
    private String usersInput;
    private Integer countOfWords;

    public WordCount(String stopWordsFileName) {
        this.stopWordsFileName = stopWordsFileName;
    }

    public List<String> getStopWords() {
        return stopWords;
    }

    public void setStopWords(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public String getStopWordsFileName() {
        return stopWordsFileName;
    }

    public String getUsersInput() {
        return usersInput;
    }

    public void setUsersInput(String usersInput) {
        this.usersInput = usersInput;
    }

    public Integer getCountOfWords() {
        return countOfWords;
    }

    public void setCountOfWords(Integer countOfWords) {
        this.countOfWords = countOfWords;
    }
}