package ah.com.backend.Model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @class: Sentence
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@Entity
public class Sentence {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String sentence;
    private String translation;

    public Sentence(Long id, String sentence, String translation) {
        this.id = id;
        this.sentence = sentence;
        this.translation = translation;
    }

    public Sentence() { }

    public Long getId() {
        return id;
    }

    public String getSentence() {
        return sentence;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
