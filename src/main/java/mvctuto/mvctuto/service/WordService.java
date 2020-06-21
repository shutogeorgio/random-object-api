package mvctuto.mvctuto.service;

import mvctuto.mvctuto.dao.WordDao;
import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService implements WordDao {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> getAllWords() {
        List<Word> list = new ArrayList<>();
        wordRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public boolean addWord(Word word) {
        if (word == null){
            return false;
        }
        wordRepository.save(word);
        return true;
    }


    @Override
    public void deleteWord(long wordId) {

    }
}
