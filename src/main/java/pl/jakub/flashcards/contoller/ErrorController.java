package pl.jakub.flashcards.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {
    public String getErrorPage() {
        return "error";
    }
}
