package csu.gis.dictionary.test;

import csu.gis.dictionary.dic.WordList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String rootFilePath = "D:\\biancheng\\java\\yhcDictionary\\wordFile\\";
        System.out.println(new WordList(rootFilePath + "langdao-ce-gb.txt",1));
    }

}
