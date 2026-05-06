package ir.javapro.controller;


import ir.javapro.repository.WikimediaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikimediaController {
    private final WikimediaRepository wikimediaRepository;

    public WikimediaController(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Long count = wikimediaRepository.count();
        model.addAttribute("count", count);
        return "index";
    }
}
