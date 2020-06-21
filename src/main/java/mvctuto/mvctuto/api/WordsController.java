package mvctuto.mvctuto.api;

import lombok.NonNull;
import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class WordsController {

    @Autowired
    private WordService wordService;

    @GetMapping("words")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @PostMapping("words")
    public void addWord(@RequestBody @NonNull Word word) {
        wordService.addWord(word);
    }

    @DeleteMapping("words/{id}")
    public void deleteWordById(@PathVariable("id") long id) {
        wordService.deleteWord(id);
    }
}
