package pl.jakub.flashcards.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakub.flashcards.model.Flashcard;
import pl.jakub.flashcards.service.FlashcardService;

@Controller
@RequestMapping("/practice")
public class PracticeController {

    private FlashcardService flashcardService;

    public PracticeController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public String showPracticeMenuPage() {
        return "practicemenu";
    }

    @GetMapping("/normal")
    public String showNormalPracticePage(Model model) {
        model.addAttribute("randomFlashcard", flashcardService.getRandom());
        return "normalpractice";
    }

    @GetMapping("/reversed")
    public String showReversedPracticePage(Model model) {
        model.addAttribute("randomFlashcard", flashcardService.getRandom());
        return "reversedpractice";
    }

    @ModelAttribute("flashcards")
    public Iterable<Flashcard> getFlashcards() {
        return flashcardService.findAll();
    }
}
