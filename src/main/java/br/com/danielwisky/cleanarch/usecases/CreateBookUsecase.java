package br.com.danielwisky.cleanarch.usecases;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBookUsecase {

  private final BookDataGateway bookDataGateway;

  public Book execute(final Book book) {
    return null;
  }
}
