package pl.jakub.flashcards.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.jakub.flashcards.service.FlashcardService;

@Controller
public class MenuController {

    private FlashcardService flashcardService;

    public MenuController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @ModelAttribute("dbIsEmpty")
    public boolean dbIsEmpty() {
        return flashcardService.dbIsEmpty();
    }
}
