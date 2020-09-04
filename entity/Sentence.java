package by.epamtc.aladzyin.parser.entity;

import java.util.List;
import java.util.Objects;

public class Sentence implements Element {
    private final String sentence;
    private List<String> words;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getText() {
        return sentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence) &&
                Objects.equals(words, sentence1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, words);
    }
}
