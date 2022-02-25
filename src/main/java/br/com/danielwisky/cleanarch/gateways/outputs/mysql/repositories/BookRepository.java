package br.com.danielwisky.cleanarch.gateways.outputs.mysql.repositories;

import br.com.danielwisky.cleanarch.gateways.outputs.mysql.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
