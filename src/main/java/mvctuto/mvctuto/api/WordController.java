package mvctuto.mvctuto.api;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/word")
public class WordController {

    @GetMapping
    public HashMap<String, Object> getAllWords() {
        HashMap<String, Object> words = new HashMap<>();
        words.put("id", 1);
        words.put("name", "google");
        return words;
    }

    @PostMapping
    public void addWord() {
        // TODO: Add Single Word
    }

    @GetMapping("/{id}")
    public HashMap<String, Object> getSingleWordById() {
        HashMap<String, Object> word = new HashMap<>();
        word.put("id", 1);
        word.put("name", "google");
        return word;
    }

    @PutMapping("/{id}")
    public void updateWordById() {
        // TODO: Update Single Word
    }

    @DeleteMapping("/{id}")
    public void deleteWordById() {
        // TODO: Delete Single Word
    }
}
