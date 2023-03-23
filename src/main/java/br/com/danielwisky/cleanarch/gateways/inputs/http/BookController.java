package br.com.danielwisky.cleanarch.gateways.inputs.http;

import static org.springframework.http.HttpStatus.OK;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.inputs.http.resources.CreateBookRequest;
import br.com.danielwisky.cleanarch.gateways.inputs.http.resources.CreateBookResponse;
import br.com.danielwisky.cleanarch.usecases.CreateBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

  private final CreateBook createBook;

  @PostMapping
  @ResponseStatus(OK)
  public ResponseEntity<CreateBookResponse> create(
      @RequestBody final CreateBookRequest createBookRequest) {

    final Book book = createBookRequest.toDomain();
    final Book bookCreated = createBook.execute(book);

    return ResponseEntity.ok(new CreateBookResponse(bookCreated));
  }
}
