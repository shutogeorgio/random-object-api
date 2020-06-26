package mvctuto.mvctuto.dao;

import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;

import java.util.List;
import java.util.Optional;

public interface WordDao {
    Optional<Word> selectSingleWord(long id);
    List<Word> selectAllWords();
    void addWord(WordRequest word);
    void updateWordById(long id, WordRequest word);
    void deleteWordById(long id);
}
