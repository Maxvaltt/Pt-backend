package pt.pt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pt.pt.domain.Treeni;
import pt.pt.domain.TreeniRepository;

@RestController
@RequestMapping("/treenis")
public class TreeniRestController {

    private final TreeniRepository treeniRepository;

    @Autowired
    public TreeniRestController(TreeniRepository treeniRepository) {
        this.treeniRepository = treeniRepository;
    }

    @GetMapping
    public List<Treeni> getTreeniRest() {
        return (List<Treeni>) treeniRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treeni> getTreeniByIdRest(@PathVariable("id") Long treeniId) {
        return treeniRepository.findById(treeniId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Treeni> postTreeni(@RequestBody Treeni treeni) {
        treeniRepository.save(treeni);
        return ResponseEntity.ok(treeni);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreeni(@PathVariable("id") Long treeniId) {
        treeniRepository.deleteById(treeniId);
        return ResponseEntity.ok("Deleted");
    }
}
