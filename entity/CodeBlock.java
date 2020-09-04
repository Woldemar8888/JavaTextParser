package by.epamtc.aladzyin.parser.entity;

import java.util.Objects;

public class CodeBlock implements Element {
    private final String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    @Override
    public String getText() {
        return codeBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeBlock)) return false;
        CodeBlock codeBlock1 = (CodeBlock) o;
        return Objects.equals(codeBlock, codeBlock1.codeBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlock);
    }
}
