package by.epamtc.aladzyin.parser.entity;

import java.util.Objects;

public class Word implements Element {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String getText() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
