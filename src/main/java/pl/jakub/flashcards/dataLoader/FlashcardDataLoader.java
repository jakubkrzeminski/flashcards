package pl.jakub.flashcards.dataLoader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.jakub.flashcards.model.Flashcard;
import pl.jakub.flashcards.repository.FlashcardRepository;

import java.util.List;

@Component
public class FlashcardDataLoader implements ApplicationRunner {
    private FlashcardRepository flashcardRepository;

    public FlashcardDataLoader(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (flashcardRepository.count() == 0) {
            List<Flashcard> flashcards = List.of(
                    new Flashcard(null, "der Hund", "pies"),
                    new Flashcard(null, "die Katze", "kot"),
                    new Flashcard(null, "die Eule", "sowa"),
                    new Flashcard(null, "das Pferd", "koń"),
                    new Flashcard(null, "die Maus", "mysz"),
                    new Flashcard(null, "der Hamster", "chomik"),
                    new Flashcard(null, "das Kaninchen", "królik"),
                    new Flashcard(null, "der Fisch", "ryba"),
                    new Flashcard(null, "das Schwein", "świnia"),
                    new Flashcard(null, "das Schaf", "owca")
            );
            flashcardRepository.saveAll(flashcards);
        }
    }
}
