package ah.com.backend.Service;

import ah.com.backend.Model.Sentence;
import ah.com.backend.Persistence.SentenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @class: SentenceService
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@Service
public class SentenceService {

    private final SentenceRepository sentenceRepository;

    @Autowired
    public SentenceService(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    public List<Sentence> getAllSentences() {
        return sentenceRepository.findAll();
    }

    public Sentence randomSentence() {
        Random rand = new Random();
        List sentence = sentenceRepository.findAll();
        return (Sentence) sentence.get(rand.nextInt(sentence.size()));
    }
}
