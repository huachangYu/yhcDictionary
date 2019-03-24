package csu.gis.dictionary.ui;

import csu.gis.dictionary.dic.Word;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextSearchWord extends JTextField{

    
    JComboBox _searchType=new JComboBox();
    JLayeredPane _nowLayer=new JLayeredPane();
    JList<String> _listSimilarWords=new JList<>();
    
    JPanel _panelSimilarWords=new JPanel();
    JPanel _panelTranslating=new JPanel();
    
    ArrayList<Word> _wordsEnglishToChinese=new ArrayList<>();
    ArrayList<Word> _wordsChineseToEnglish=new ArrayList<>();
    
    Clipboard sysClipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
    
    DefaultListModel dlm=new DefaultListModel();
    
    public TextSearchWord(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                showList();
            }
        });
    }
    
    
    public void setBuddy(JPanel similarWords,JPanel transplating,JList<String> list,
            JComboBox jcb,ArrayList<Word> etc,ArrayList<Word> cte,JLayeredPane jlp){
        _panelSimilarWords=similarWords;
        _panelTranslating=transplating;
        _listSimilarWords=list;
        _searchType=jcb;
        _wordsEnglishToChinese=etc;
        _wordsChineseToEnglish=cte;
        _nowLayer=jlp;
    }
    
    public boolean textEmpty(){
        return getText().equalsIgnoreCase("");
    }
    
    public void showList(){
        _nowLayer.moveToFront(_panelSimilarWords);
        _nowLayer.moveToBack(_panelTranslating);
        dlm = new DefaultListModel();
        String searchWord = this.getText().trim();
        int endIndex = searchWord.length();
        if (!"".equals(searchWord)) {
            if (_searchType.getSelectedIndex() == 0) {
                for (int i = 0; i < _wordsEnglishToChinese.size(); i++) {
                    String myWordName = _wordsEnglishToChinese.get(i).getName();
                    if (myWordName.length() < searchWord.length()) {
                        continue;
                    } else {
                        String str = myWordName.substring(0, endIndex);
                        if (str.equalsIgnoreCase(searchWord)) {
                            dlm.addElement(myWordName);
                        }
                    }
                    if (dlm.getSize() > 20) {
                        break;
                    }
                }
            }else if(_searchType.getSelectedIndex()==1){
                for (int i = 0; i < _wordsChineseToEnglish.size(); i++) {
                    String myWordName = _wordsChineseToEnglish.get(i).getName();
                    if (myWordName.length() < searchWord.length()) {
                        continue;
                    } else {
                        String str = myWordName.substring(0, endIndex);
                        if (str.equalsIgnoreCase(searchWord)) {
                            dlm.addElement(myWordName);
                        }
                    }
                    if (dlm.getSize() > 20) {
                        break;
                    }
                }
            }
        }
        _listSimilarWords.setModel(dlm);
    }
    
    public String getClipBoardContent() throws UnsupportedFlavorException, IOException{
        Transferable content=sysClipboard.getContents(null);
        if(content!=null){
            if(content.isDataFlavorSupported(DataFlavor.stringFlavor)){
                return (String)content.getTransferData(DataFlavor.stringFlavor);
            }
        }
        return "";
    }
    
    public void clearClipBoard(){
        sysClipboard.setContents(null, null);
    }
    
}
