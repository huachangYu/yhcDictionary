package csu.gis.dictionary.ui;

import csu.gis.dictionary.dic.Word;
import csu.gis.dictionary.dic.WordList;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListNewWords extends JTable implements MouseListener{

    

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<Word> _listEC = new ArrayList<>();
    ArrayList<Word> _listCE = new ArrayList<>();
    TextSearchWord _textSearch=new TextSearchWord();
    JComboBox _searchWordType=new JComboBox();
    JComboBox _newWordsType=new JComboBox();
    private PopupMenu _newWordsListMenu = null;
    private MenuItem _detailsMenu = null;
    
    protected JTabbedPane _mainPane=null;
    
    protected boolean sorting = false;
    private boolean showName = true;
    private boolean showExplain = true;
    private String _listPath;

    public ListNewWords() {
        init();
        tableModel.addColumn("单词");
        tableModel.addColumn("释义");
        tableHeader.setFont(new Font("楷体", 1, 17));
        _newWordsListMenu = new PopupMenu();
        this.add(_newWordsListMenu);

        _detailsMenu = new MenuItem("look for details");
        _detailsMenu.addActionListener((ActionEvent e) -> {
            doDetail();
        });
        _newWordsListMenu.add(_detailsMenu);
        _detailsMenu=new MenuItem("delete");
        _detailsMenu.addActionListener((ActionEvent e) -> {
            doDelete();
        });
        _newWordsListMenu.add(_detailsMenu);
        
        addMouseListener(this);
    }

    private void init() {
        setModel(tableModel);
        setRowHeight(30);
        setFont(new Font("", 0, 16));
    }

    public void setBuddy(ArrayList<Word> listEC, ArrayList<Word> listCE,TextSearchWord tsw,
            JTabbedPane jtp,JComboBox jcb1,JComboBox jcb2) {
        _listEC = listEC;
        _listCE = listCE;
        _textSearch=tsw;
        _mainPane=jtp;
        _searchWordType=jcb1;
        _newWordsType=jcb2;
    }

    public void add(Word newWord) throws IOException {

        String _listPath1 = new String();

        if (newWord.getType() == 0) {
            _listPath1 = getListPath() + "newWordListEC.txt";
            try (FileWriter writer = new FileWriter(_listPath1, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.append(newWord.getName() + ";;;\n");
                bufferedWriter.append(newWord.getExplain() + ";;;\n");
            }
        } else if (newWord.getType() == 1) {
            _listPath1 = getListPath() + "newWordListCE.txt";
            try (FileWriter writer = new FileWriter(_listPath1, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.append(newWord.getName() + ";;;\n");
                bufferedWriter.append(newWord.getExplain() + ";;;\n");
            }
        }
    }

    public void clearList() {
        tableModel.setRowCount(0);
    }

    public void showList(int type) throws IOException {
        String _listPath1 = new String();
        if (type == 0) {
            _listPath1 = getListPath() + "newWordListEC.txt";
            WordList list = new WordList(_listPath1, type);
            ArrayList<Word> _newWords = list.getData();
            ArrayList wordsIndex = new ArrayList();
            for (int i = 0; i < _newWords.size(); i++) {
                Word newWord = _newWords.get(i);
                if (sorting) {
                    wordsIndex.add(newWord.getIndex(_listEC));
                } else {
                    Vector<String> rowData = new Vector<>();
                    if (isShowName()) {
                        rowData.add(newWord.getName());
                    } else {
                        rowData.add(" ");
                    }
                    if (isShowExplain()) {
                        rowData.add(newWord.getExplain());
                    } else {
                        rowData.add(" ");
                    }
                    tableModel.addRow(rowData);
                }
            }
            if (sorting) {
                Collections.sort(wordsIndex);
                for (int k = 2; k < wordsIndex.size(); k++) {
                    int index = (int) wordsIndex.get(k);
                    Word newWord = new Word(index, _listEC);
                    Vector<String> rowData = new Vector<>();
                    if (isShowName()) {
                        rowData.add(newWord.getName());
                    } else {
                        rowData.add(" ");
                    }
                    if (isShowExplain()) {
                        rowData.add(newWord.getExplain());
                    } else {
                        rowData.add(" ");
                    }
                    tableModel.addRow(rowData);
                }
            }
        } else if (type == 1) {
            _listPath1 = getListPath() + "newWordListCE.txt";
            WordList list = new WordList(_listPath1, type);
            ArrayList<Word> _newWords = list.getData();
            for (int j = 0; j < _newWords.size(); j++) {
                Word newWord = _newWords.get(j);
                Vector<String> rowData = new Vector<>();
                if (isShowName()) {
                    rowData.add(newWord.getName());
                } else {
                    rowData.add(" ");
                }
                if (isShowExplain()) {
                    rowData.add(newWord.getExplain());
                } else {
                    rowData.add(" ");
                }
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
    
    protected void doDetail(){
        int i=_newWordsType.getSelectedIndex();
        _searchWordType.setSelectedIndex(i);
        int rowIndex=this.getSelectedRow();
        String wordName=(String) this.getValueAt(rowIndex, 0);
        _textSearch.setText(wordName.trim());
        _mainPane.setSelectedIndex(0); 
    }
    
    public void setSorting(boolean s) {
        this.sorting = s;
    }

    public void setShowName(boolean showName) {
        this.showName = showName;
    }

    public void setShowExplain(boolean showExplain) {
        this.showExplain = showExplain;
    }

    public boolean isShowName() {
        return showName;
    }

    public boolean isShowExplain() {
        return showExplain;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int rowIndex=this.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            _newWordsListMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void doDelete() {
        
    }
}
