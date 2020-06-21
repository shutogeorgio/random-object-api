package mvctuto.mvctuto.dao;

import mvctuto.mvctuto.model.Word;

import java.util.List;

public interface WordDao {
    List<Word> getAllWords();
    boolean addWord(Word word);
    void deleteWord(long wordId);
}
