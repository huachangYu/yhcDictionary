package csu.gis.dictionary.dic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordList {
    
    private ArrayList<Word> _data = new ArrayList<>();

    public WordList() {
        
    }
    
    public WordList(String filePath) throws IOException {
        StringBuilder name = new StringBuilder();
        StringBuilder explain = new StringBuilder();
        InputStreamReader reader = null;
        File file = new File(filePath);
        reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferreader = new BufferedReader(reader);
        String line;
        int i = 0;
        int index = 0;
        while ((line = bufferreader.readLine()) != null) {
            if (i % 2 == 0) {
                name.append(line);
            } else if (i % 2 == 1) {
                explain.append(line).append("\n");
                if (line.contains(";;;")) {
                    _data.add(new Word(name.toString().replace(";;;", ""),
                            explain.toString().replace(";;;", "")));
                    index++;
                    name = new StringBuilder();
                    explain = new StringBuilder();
                }
            }
            if (line.contains(";;;")) {
                i++;
            }
        }
    }

    public WordList(String filePath, int type) throws FileNotFoundException, IOException {
        StringBuilder name = new StringBuilder();
        StringBuilder explain = new StringBuilder();
        InputStreamReader reader = null;
        File file = new File(filePath);
        reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferreader = new BufferedReader(reader);
        String line;
        int i = 0;
        int indexEC = 0, indexCE = 0;
        while ((line = bufferreader.readLine()) != null) {
            if (i % 2 == 0) {
                name.append(line);
            } else if (i % 2 == 1) {
                explain.append(line).append("\n");
                if (line.contains(";;;")) {
                    if (type == 0) {
                        _data.add(new Word(name.toString().replace(";;;", ""), 
                                explain.toString().replace(";;;", ""), 0, indexEC));
                        indexEC++;
                    } else if (type == 1) {
                        _data.add(new Word(name.toString().replace(";;;", ""), 
                                explain.toString().replace(";;;", ""), 1, indexCE));
                        indexCE++;
                    }
                    name = new StringBuilder();
                    explain = new StringBuilder();
                }
            }
            if (line.contains(";;;")) {
                i++;
            }
        }
    }

    

    public Word getWord(int Index){
        return _data.get(Index);
    }
    
    public ArrayList<Word> getData() {
        return _data;
    }

    public void setData(ArrayList<Word> _data) {
        this._data = _data;
    }
    
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<getData().size();i++){
            builder.append(getData().get(i).toString());
        }
        return builder.toString();
    }
}
