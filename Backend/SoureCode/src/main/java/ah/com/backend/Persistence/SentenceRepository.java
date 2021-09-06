package ah.com.backend.Persistence;

import ah.com.backend.Model.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @interface: SentenceRepository
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
}
