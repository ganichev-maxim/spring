package com.example.spring.boot.tacos.controller.rest;

import com.example.spring.boot.tacos.controller.rest.resources.TacoResource;
import com.example.spring.boot.tacos.controller.rest.resources.assemblers.TacoResourceAssembler;
import com.example.spring.boot.tacos.model.Taco;
import com.example.spring.boot.tacos.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/rest/design",
        produces="application/json")
@CrossOrigin(origins="*")
public class DesignTacoRestController {
    private TacoRepository tacoRepo;

    @Autowired
    public DesignTacoRestController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }
    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<TacoResource> tacoResources =
                new TacoResourceAssembler().toCollectionModel(tacos);
        tacoResources.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DesignTacoRestController.class)
                .recentTacos()).withRel("recents"));
        return tacoResources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}
