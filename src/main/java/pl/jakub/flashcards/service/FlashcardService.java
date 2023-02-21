package pl.jakub.flashcards.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.jakub.flashcards.model.Flashcard;
import pl.jakub.flashcards.repository.FlashcardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlashcardService {
    private FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public Flashcard save(Flashcard flashcard) {
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);
        return savedFlashcard;
    }

    public Page<Flashcard> findAll(Pageable pageable) {
        return flashcardRepository.findAll(pageable);
    }

    public Optional<Flashcard> findById(Long aLong) {
        return flashcardRepository.findById(aLong);
    }

    public Iterable<Flashcard> findAll() {
        return flashcardRepository.findAll();
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        flashcardRepository.deleteAllById(longs);
    }

    public void deleteById(Long aLong) {
        flashcardRepository.deleteById(aLong);
    }

    public boolean dbIsEmpty() {
        return flashcardRepository.count() == 0;
    }

    public Flashcard getRandom() {
        Iterable<Flashcard> flashcardsIterable = flashcardRepository.findAll();
        List<Flashcard> flashcardsList = new ArrayList<>();
        flashcardsIterable.forEach(flashcardsList::add);
        int index = new Random().nextInt(flashcardsList.size());
        return flashcardsList.get(index);
    }
}
