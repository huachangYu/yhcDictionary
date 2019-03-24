package csu.gis.dictionary.ui;

import csu.gis.dictionary.dic.Word;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ListSimilarWords extends JList{
    
    JTextField _jtf=null;
    DefaultListModel<Object> dlm=new DefaultListModel<>();
    protected ArrayList<Word> _wordsEnglishToChinese = new ArrayList<>();
    protected ArrayList<Word> _wordsChineseToEnglish = new ArrayList<>();
    
    public ListSimilarWords(){
        
    }
    
    public void addItem(String item){
        dlm.addElement(item);
        setModel(dlm);
        this.repaint();
    }
    
    public void addWords(int searchType){
        String searchWord=_jtf.getText().trim();
        int endIndex=searchWord.length();
        if(searchType==0){
            for(int i=0;i<_wordsEnglishToChinese.size();i++){
                String myWordName=_wordsEnglishToChinese.get(i).getName();
                if(myWordName.length()<searchWord.length()){
                    continue;
                }else{
                    String str=myWordName.substring(0, endIndex);
                    if(str.equalsIgnoreCase(searchWord)){
                        dlm.addElement(myWordName);
                    }
                }
                if(dlm.getSize()>30){
                    break;
                }
            }
        }
        setModel(dlm);
    }
    
    public void removeData(){
        dlm.removeAllElements();
    }
    
    public void setBuddy(JTextField jtf){
        _jtf=jtf;
    }
    
    public void setBuddy(ArrayList<Word> etc,ArrayList<Word> cte){
        _wordsEnglishToChinese=etc;
        _wordsChineseToEnglish=cte;
    }
}
