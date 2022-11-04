package it.develhope.API.Spring.Repositories2.repositories;

import it.develhope.API.Spring.Repositories2.entity.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = " repo-prog-languagese", itemResourceDescription = @Description("programmLang"))
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
