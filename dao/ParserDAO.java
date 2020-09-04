package by.epamtc.aladzyin.parser.dao;

import by.epamtc.aladzyin.parser.entity.Text;

import java.io.IOException;

public interface ParserDAO {
    Text reader(String path) throws IOException;
}


