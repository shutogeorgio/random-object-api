package mvctuto.mvctuto.repository;

import mvctuto.mvctuto.model.Word;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface WordRepository extends CrudRepository<Word, String> {
}
