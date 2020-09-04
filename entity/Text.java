package by.epamtc.aladzyin.parser.entity;

import java.util.List;
import java.util.Objects;

public class Text implements Element {
    private List<Element> elementsList;


    public Text(List<Element> elements) {
        this.elementsList = elements;
    }


    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Element element : elementsList){
            stringBuilder.append(element.getText() + "\n");
        }

        return stringBuilder.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text = (Text) o;
        return Objects.equals(elementsList, text.elementsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementsList);
    }
}
