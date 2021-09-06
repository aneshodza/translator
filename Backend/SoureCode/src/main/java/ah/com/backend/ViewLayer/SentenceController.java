package ah.com.backend.ViewLayer;

import ah.com.backend.Model.Sentence;
import ah.com.backend.Model.UserData;
import ah.com.backend.Service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @class: SentenceController
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@RestController
@RequestMapping(path = "api/sentences")
@CrossOrigin("*")
public class SentenceController {

    private final SentenceService sentenceService;

    @Autowired
    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping
    public List<Sentence> getAllSentences() {
        return sentenceService.getAllSentences();
    }

    @GetMapping(path = "/random")
    public Sentence getRandomSentence() {
        return sentenceService.randomSentence();
    }

}
