package mvctuto.mvctuto.api;

import lombok.NonNull;
import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;
import mvctuto.mvctuto.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1")
@RestController
public class WordsController {

    private WordService wordService;

    @Autowired
    public WordsController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("words")
    public List<Word> getAllWords() {
        return wordService.selectAllWords();
    }

    @GetMapping("words/{id}")
    public Optional<Word> getSingleWord(@PathVariable("id") long id){
        return wordService.selectSingleWord(id);
    }

    @PostMapping("words")
    public void addWord(@RequestBody @Validated @NonNull WordRequest word) {
        wordService.addWord(word);
    }

    @PutMapping("words/{id}")
    public void updateWordById (@PathVariable("id") long id, @RequestBody @Validated @NonNull WordRequest word) {
        wordService.updateWordById(id, word);
    }

    @DeleteMapping("words/{id}")
    public void deleteWordById(@PathVariable("id") long id) {
        wordService.deleteWordById(id);
    }
}
