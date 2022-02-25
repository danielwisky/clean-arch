package br.com.danielwisky.cleanarch.usecases;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookDataGateway;
import br.com.danielwisky.cleanarch.gateways.BookExternalGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class CreateBookUsecase {

  private final BookDataGateway bookDataGateway;
  private final BookExternalGateway bookExternalGateway;

  public Book execute(final Book book) {
    Assert.notNull(book.getName(), "name is required");
    Assert.notNull(book.getAuthor(), "author is required");

    final Book bookCreated = bookDataGateway.save(book);
    bookExternalGateway.notify(bookCreated);

    return bookCreated;
  }
}
