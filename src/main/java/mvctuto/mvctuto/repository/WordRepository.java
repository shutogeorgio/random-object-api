package mvctuto.mvctuto.repository;

import mvctuto.mvctuto.model.Word;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface WordRepository extends JpaRepository<Word, String> {
}
