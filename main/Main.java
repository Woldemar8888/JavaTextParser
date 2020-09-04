package by.epamtc.aladzyin.parser.main;

import by.epamtc.aladzyin.parser.dao.DAOFactory;
import by.epamtc.aladzyin.parser.entity.Text;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        Text text = daoFactory.getParserDAO().reader("book.txt");
        System.out.println(text.getText());
    }
}
