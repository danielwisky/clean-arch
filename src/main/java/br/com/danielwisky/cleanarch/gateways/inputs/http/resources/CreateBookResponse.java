package br.com.danielwisky.cleanarch.gateways.inputs.http.resources;

import br.com.danielwisky.cleanarch.domains.Book;
import lombok.Data;

@Data
public class CreateBookResponse {

  private String code;
  private String name;
  private String author;

  public CreateBookResponse(final Book book) {
    this.code = book.getCode();
    this.name = book.getName();
    this.author = book.getAuthor();
  }
}
