package csu.gis.dictionary.dic;

import java.util.ArrayList;

public class Word {

    private String _name = new String();
    private String _explain = new String();
    private int _type = 0;
    private int _index = -1;

    final int ENGLISH_TO_CHINESE = 0;
    final int CHINESE_TO_English = 1;

    public Word() {
        _name = "";
        _explain = "";
    }

    public Word(String name, String explain) {
        _name = name;
        _explain = explain;
    }

    public Word(String name, String explain, int type) {
        _name = name;
        _explain = explain;
        _type = type;
    }

    public Word(String name, String explain, int type, int index) {
        _name = name;
        _explain = explain;
        _type = type;
        _index = index;
    }

    public Word(int index, ArrayList<Word> list) {
        Word theWord = new Word();
        theWord = list.get(index);
        _name = theWord.getName();
        _explain = theWord.getExplain();
        _type = theWord.getType();
        _index = index;
    }

    public int getIndex(ArrayList<Word> list) {
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            if (word.getName().equalsIgnoreCase(getName())) {
                return i;
            }
        }
        return -1;
    }

    public int getType() {
        return _type;
    }

    public int getIndex() {
        return _index;
    }

    @Override
    public String toString() {
        return _name + "\n" + _explain;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getExplain() {
        return _explain;
    }

    public void setExplain(String _explain) {
        this._explain = _explain;
    }

}
