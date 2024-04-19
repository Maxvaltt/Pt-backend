package pt.pt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pt.pt.domain.Treeni;
import pt.pt.domain.TreeniRepository;

@Controller
public class TreeniController {

    @Autowired
    private TreeniRepository treeniRepository;

    @GetMapping("/Etusivu")
    public String getEtusivu(Model model) {
        // Retrieve the list of Treeni objects from the repository
        Iterable<Treeni> treenis = treeniRepository.findAll();
        
        // Add the list of Treeni objects to the model
        model.addAttribute("treenis", treenis);
        
        // Return the name of the Thymeleaf template (Etusivu.html)
        return "Etusivu";
    }

    @GetMapping("/addtreeni")
    public String AddBookForm(Model model) {
        model.addAttribute("treeni", new Treeni());
        return "addtreeni";
    }

    @PostMapping("/savetreeni")
    public String saveTreeni(@ModelAttribute("treeni") Treeni treeni) {
        treeniRepository.save(treeni);
        return "redirect:/Etusivu";
    }
    
    @GetMapping("/poistatreeni/{id}")
    public String deleteTreeni(Model model, @PathVariable("id") Long treeniId) {
        treeniRepository.deleteById(treeniId);
        return "redirect:/Etusivu";
    }

    @SuppressWarnings("null")
    @GetMapping("/muokkaatreenia/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showMuokkaaTreeniaForm(@PathVariable Long id, Model model) {
        Optional<Treeni> optionalTreeni = treeniRepository.findById(id);
        if (optionalTreeni.isPresent()) {
            model.addAttribute("treeni", optionalTreeni.get());
            return "muokkaatreenia";
        } else {
            return "redirect:/Etusivu";
        }
    }

    @SuppressWarnings("null")
    @PostMapping("/updatetreeni")
    public String updateTreeni(@ModelAttribute @NonNull Treeni updatedTreeni) {
        treeniRepository.save(updatedTreeni);
        return "redirect:/Etusivu";
    }

}
