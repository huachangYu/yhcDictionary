package csu.gis.dictionary.dic;

import java.util.ArrayList;

public class WordFactory {

    public static Word nameToWord(ArrayList<Word> _matchingWords, String name) {
        for (int i = 0; i < _matchingWords.size(); i++) {
            if (_matchingWords.get(i).getName().equalsIgnoreCase(name)) {
                Word theWord = _matchingWords.get(i);
                return theWord;
            }
        }
        return new Word();
    }
}
