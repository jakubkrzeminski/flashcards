package pl.jakub.flashcards.contoller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakub.flashcards.model.Flashcard;
import pl.jakub.flashcards.service.FlashcardService;

import java.util.Optional;

@Controller
@RequestMapping("/flashcards")
public class FlashcardController {
    private FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public String showFlashcardsPage(Model model) {
        model.addAttribute("flashcard", new Flashcard());
        return "flashcards";
    }

    @ModelAttribute
    public Flashcard getFlashcard() {
        return new Flashcard();
    }

    @ModelAttribute("flashcards")
    public Page<Flashcard> getFlashcards(@PageableDefault(size = 8) Pageable pageable) {
        return flashcardService.findAll(pageable);
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public Flashcard getOne(@PathVariable long id) {
        Optional<Flashcard> flashcard = flashcardService.findById(id);
        if (flashcard.isEmpty()) {
            return new Flashcard();
        }
        return flashcard.get();
    }

    @PostMapping("/save")
    public String saveFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
        flashcardService.save(flashcard);
        return "redirect:/flashcards";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Flashcard flashcard) {
        flashcardService.save(flashcard);
        return "redirect:/flashcards";
    }

    @GetMapping("/delete/{id}")
    public String deleteFlashcards(@PathVariable("id") Long id) {
        flashcardService.deleteById(id);
        return "redirect:/flashcards";
    }
}
