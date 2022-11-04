package it.develhope.API.Spring.Repositories2.controller;

import it.develhope.API.Spring.Repositories2.entity.ProgrammingLanguage;
import it.develhope.API.Spring.Repositories2.repositories.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/programming")
public class ProgrammingLanguageController {

    @Autowired
    ProgrammingLanguageRepository programmingLanguageRepository;

    @PostMapping
    public ProgrammingLanguage postProgramming(@RequestBody ProgrammingLanguage programmingLanguage){
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @GetMapping
    public Page<ProgrammingLanguage> getList(@RequestParam(required = false)Optional<Integer> page,@RequestParam (required = false) Optional<Integer> size) {
        if (page.isPresent() && size.isPresent()) {
            Pageable pageable = PageRequest.of(page.get(), size.get());
            Page<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll(pageable);
            return programmingLanguages;
        } else {
            Page<ProgrammingLanguage> programmingLanguagesPage = Page.empty();
            return programmingLanguagesPage;
        }
    }


    @PutMapping("/{id}")
    public ProgrammingLanguage putProgramming(@PathVariable Long id, @RequestBody ProgrammingLanguage programmingLanguage) {
        if (programmingLanguageRepository.existsById(id)) {
            programmingLanguage.setId(id);
            ProgrammingLanguage putProgramming = programmingLanguageRepository.save(programmingLanguage);
            return putProgramming;
        } else
            return new ProgrammingLanguage();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (!programmingLanguageRepository.existsById(id)) {
            System.out.println(HttpStatus.CONFLICT);
        } else
            programmingLanguageRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteCars() {
        programmingLanguageRepository.deleteAll();
    }



}
