package pl.jakub.flashcards.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.flashcards.model.Flashcard;

@Repository
public interface FlashcardRepository extends PagingAndSortingRepository<Flashcard, Long> {
}
