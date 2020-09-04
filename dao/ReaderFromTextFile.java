package by.epamtc.aladzyin.parser.dao;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromTextFile {
    private String allText;

    public String getAllText(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();

        while (bufferedReader.ready()){
            stringBuffer.append(bufferedReader.readLine() + '\n');
        }

        allText = stringBuffer.toString();
        return allText;
    }
}
