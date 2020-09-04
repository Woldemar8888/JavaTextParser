package by.epamtc.aladzyin.parser.dao;

import by.epamtc.aladzyin.parser.dao.impl.ParserDAOImpl;

public final class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();
    private final ParserDAO parserDAO = new ParserDAOImpl();
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public ParserDAO getParserDAO() {
        return parserDAO;
    }
}