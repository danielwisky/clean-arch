package br.com.danielwisky.cleanarch.gateways.outputs.mysql;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookDataGateway;
import br.com.danielwisky.cleanarch.gateways.outputs.mysql.entities.BookEntity;
import br.com.danielwisky.cleanarch.gateways.outputs.mysql.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMySQLGatewayImpl implements BookDataGateway {

  private final BookRepository bookRepository;

  @Override
  public Book save(final Book book) {
    final BookEntity bookEntity = new BookEntity(book);
    final BookEntity savedBook = bookRepository.save(bookEntity);
    return savedBook.toDomain();
  }
}
