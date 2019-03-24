package csu.gis.dictionary.ui;

import csu.gis.dictionary.dic.Word;
import csu.gis.dictionary.dic.WordList;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListHistory extends JTable {

    

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<Word> _listEC = new ArrayList<>();
    ArrayList<Word> _listCE = new ArrayList<>();
    protected boolean sorting = false;
    private String _listPath;

    public ListHistory() {
        setModel(tableModel);
        setRowHeight(30);
        setFont(new Font("", 0, 16));
        tableModel.addColumn("单词");
        tableModel.addColumn("释义");
        tableHeader.setFont(new Font("楷体", 1, 17));
    }

    public void add(Word newWord) throws IOException {
        try (FileWriter writer = new FileWriter(getListPath(), true); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.append(newWord.getName() + ";;;\n");
            bufferedWriter.append(newWord.getExplain() + ";;;\n");
        }
    }

    public void clearList() {
        tableModel.setRowCount(0);
    }

    public void showList() throws IOException {
        WordList list = new WordList(getListPath());
        ArrayList<Word> _newWords = list.getData();
        ArrayList wordsIndex = new ArrayList();
        for (int i = 0; i < _newWords.size(); i++) {
            Word newWord = _newWords.get(i);
            if (sorting) {
                wordsIndex.add(newWord.getIndex(_listEC));
            } else {
                Vector<String> rowData = new Vector<>();
                rowData.add(newWord.getName());
                rowData.add(newWord.getExplain());
                tableModel.addRow(rowData);
            }
        }
    }
    
    public String getListPath() {
        return _listPath;
    }

    public void setListPath(String _listPath) {
        this._listPath = _listPath;
    }
}
