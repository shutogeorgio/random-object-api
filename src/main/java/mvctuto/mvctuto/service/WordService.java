package mvctuto.mvctuto.service;

import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;
import mvctuto.mvctuto.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

	private WordRepository wordRepository;

	@Autowired
	public WordService(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}

	public Optional<Word> selectSingleWord(long id) {
		return wordRepository.findById(String.valueOf(id));
	}

	public List<Word> selectAllWords() {
		return wordRepository.findAll();
	}

	public Word addWord(WordRequest request) {
		Word word = new Word();
		word.setName(request.getName());
		wordRepository.saveAndFlush(word);
		return word;
	}

	public boolean updateWordById(long id, WordRequest request) {
		Word previousWord = selectSingleWord(id).orElse(null);
		previousWord.setName(request.getName());
		wordRepository.saveAndFlush(previousWord);
		return true;
	}

	public void deleteWordById(long id) {
		wordRepository.deleteById(String.valueOf(id));
	}

}
