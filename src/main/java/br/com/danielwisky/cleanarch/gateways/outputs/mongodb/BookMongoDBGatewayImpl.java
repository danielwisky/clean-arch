package br.com.danielwisky.cleanarch.gateways.outputs.mongodb;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookDataGateway;
import br.com.danielwisky.cleanarch.gateways.outputs.mongodb.documents.BookDocument;
import br.com.danielwisky.cleanarch.gateways.outputs.mongodb.repositories.BookDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMongoDBGatewayImpl implements BookDataGateway {

  private final BookDocumentRepository bookDocumentRepository;

  @Override
  public Book save(final Book book) {
    final BookDocument bookDocument = new BookDocument(book);
    final BookDocument savedBook = bookDocumentRepository.save(bookDocument);
    return savedBook.toDomain();
  }
}
