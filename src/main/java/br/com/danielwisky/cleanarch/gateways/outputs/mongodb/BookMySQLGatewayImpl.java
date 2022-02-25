package br.com.danielwisky.cleanarch.gateways.outputs.mongodb;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookDataGateway;
import br.com.danielwisky.cleanarch.gateways.outputs.mongodb.documents.BookDocument;
import br.com.danielwisky.cleanarch.gateways.outputs.mongodb.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMySQLGatewayImpl implements BookDataGateway {

  private final BookRepository bookRepository;

  @Override
  public Book save(final Book book) {
    final BookDocument bookDocument = new BookDocument(book);
    final BookDocument savedBook = bookRepository.save(bookDocument);
    return savedBook.toDomain();
  }
}
