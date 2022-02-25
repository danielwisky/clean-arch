package br.com.danielwisky.cleanarch.gateways.inputs.http;

import static org.springframework.http.HttpStatus.OK;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.inputs.http.resources.CreateBookRequest;
import br.com.danielwisky.cleanarch.gateways.inputs.http.resources.CreateBookResponse;
import br.com.danielwisky.cleanarch.usecases.CreateBookUsecase;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
  
  private final CreateBookUsecase createBookUsecase;
  
  @PostMapping
  @ResponseStatus(OK)
  @ApiOperation(value = "Create book")
  public ResponseEntity<CreateBookResponse> create(
      @RequestBody final CreateBookRequest createBookRequest) {
    
    final Book book = createBookRequest.toDomain();
    final Book bookCreated = createBookUsecase.execute(book);

    return ResponseEntity.ok(new CreateBookResponse(bookCreated));
  }
}
