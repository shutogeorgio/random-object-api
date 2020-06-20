package mvctuto.mvctuto.api;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {

    @GetMapping
    public List getAllWords() {
        HashMap<String, Object> firstWord = new HashMap<>();
        firstWord.put("id", 1);
        firstWord.put("name", "Google");

        HashMap<String, Object> secondtWord = new HashMap<>();
        secondtWord.put("id", 2);
        secondtWord.put("name", "Firefox");

        List keys = new ArrayList();
        keys.add(firstWord);
        keys.add(secondtWord);

        return keys;
    }

    @PostMapping
    public void addWord() {
        // TODO: Add Single Word
    }

    @GetMapping("/{id}")
    public HashMap<String, Object> getSingleWordById(@PathVariable int id) {
        HashMap<String, Object> word = new HashMap<>();
        word.put("id", id);
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
