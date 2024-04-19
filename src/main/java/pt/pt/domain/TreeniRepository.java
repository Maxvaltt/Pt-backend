package pt.pt.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TreeniRepository extends CrudRepository<Treeni, Long> {
    List<Treeni> findByNimi(@Param("nimi") String nimi);
}
