package by.epamtc.aladzyin.parser.dao.impl;

import by.epamtc.aladzyin.parser.dao.ParserDAO;
import by.epamtc.aladzyin.parser.dao.ReaderFromTextFile;
import by.epamtc.aladzyin.parser.entity.CodeBlock;
import by.epamtc.aladzyin.parser.entity.Element;
import by.epamtc.aladzyin.parser.entity.Sentence;
import by.epamtc.aladzyin.parser.entity.Text;

import java.io.*;
import java.util.LinkedList;
import java.util.List;



public class ParserDAOImpl implements ParserDAO {
    private List<Element> elementsList;
    private List<Sentence> sentenceList;
    private List<CodeBlock> codeBlocksList;

    public ParserDAOImpl() {
        this.elementsList = new LinkedList<>();
        this.sentenceList = new LinkedList<>();
        this.codeBlocksList = new LinkedList<>();
    }

    @Override
    public Text reader(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Text text;
        boolean isBlockCodeStarted = false;
        int markCount = 0;
        StringBuilder stringBuilder = null;


        while (bufferedReader.ready()){

            String str = bufferedReader.readLine();

            if(str.contains("{")){
                markCount++;
                isBlockCodeStarted = true;
            }

            if(!isBlockCodeStarted && stringBuilder == null){
                stringBuilder = new StringBuilder();
            }

            if(!isBlockCodeStarted){
                stringBuilder.append(str);
                Sentence sentence = new Sentence(stringBuilder.toString());
                sentenceList.add(sentence);
//                elementsList.add(sentence);
                stringBuilder = null;
                continue;
            }


            if(markCount == 1 && stringBuilder == null){

                stringBuilder = new StringBuilder();
            }

            if(isBlockCodeStarted){
                stringBuilder.append(str+"\n");
            }

            if(str.contains("}")){
                markCount--;
            }


            if(markCount==0 && isBlockCodeStarted){

                String code = stringBuilder.toString();
                CodeBlock codeBlock = new CodeBlock(code);
                codeBlocksList.add(codeBlock);
                elementsList.add(codeBlock);

                isBlockCodeStarted = false;
                stringBuilder = null;
            }
        }


        text = new Text(elementsList);

        return text;
    }
}



