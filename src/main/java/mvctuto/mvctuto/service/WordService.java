package mvctuto.mvctuto.service;

import mvctuto.mvctuto.dao.WordDao;
import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;
import mvctuto.mvctuto.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService implements WordDao {

    private WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    @Override
    public Optional<Word> selectSingleWord(long id) {
        return wordRepository.findById(String.valueOf(id));
    }

    @Override
    public List<Word> selectAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public void addWord(WordRequest request) {
        Word  word = new Word();
        word.setId(request.getId());
        word.setName(request.getName());
        wordRepository.save(word);
    }

    @Override
    public void updateWordById(long id, WordRequest request){
        Word  word = new Word();
        word.setId(id);
        word.setName(request.getName());
        wordRepository.deleteById(String.valueOf(id));
    }

    @Override
    public void deleteWordById(long id){
        wordRepository.deleteById(String.valueOf(id));
    }
}
