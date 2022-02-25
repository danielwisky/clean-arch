package br.com.danielwisky.cleanarch.gateways.inputs.gateways.inputs.http.resources;

import br.com.danielwisky.cleanarch.domains.Book;
import lombok.Data;

@Data
public class CreateBookRequest {

  private String name;
  private String author;

  public Book toDomain() {
    return Book.builder()
        .name(this.name)
        .author(this.author)
        .build();
  }
}
