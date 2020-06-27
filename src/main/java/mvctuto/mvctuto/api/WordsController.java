package mvctuto.mvctuto.api;

import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;
import mvctuto.mvctuto.service.WordService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequestMapping("/api/v1/words")
@RestController
public class WordsController {

	private WordService wordService;

	@Autowired
	public WordsController(WordService wordService) {
		this.wordService = wordService;
	}

	@GetMapping
	public List<Word> getAllWords() {
		return wordService.selectAllWords();
	}

	@GetMapping("/{id}")
	public Optional<Word> getSingleWord(@PathVariable("id") long id) {
		return wordService.selectSingleWord(id);
	}

	@PostMapping
	public void addWord(@RequestBody @Validated @NotEmpty WordRequest word,
			BindingResult errors) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(NOT_FOUND, "Unable to create new word");
		}
		else {
			wordService.addWord(word);
		}
		;
	}

	@PutMapping("/{id}")
	public void updateWordById(@PathVariable("id") long id,
			@RequestBody @Validated @NotEmpty WordRequest word, BindingResult errors) {
		if (errors.hasErrors()) {
			throw new ResponseStatusException(NOT_FOUND, "Unable to update");
		}
		else {
			wordService.updateWordById(id, word);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteWordById(@PathVariable("id") long id)
			throws ResponseStatusException {
		wordService.deleteWordById(id);
	}

}
