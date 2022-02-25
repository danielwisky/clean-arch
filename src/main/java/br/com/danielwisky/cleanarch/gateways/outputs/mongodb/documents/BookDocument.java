package br.com.danielwisky.cleanarch.gateways.outputs.mongodb.documents;

import br.com.danielwisky.cleanarch.domains.Book;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class BookDocument {

  @Id
  private String id;
  private String name;
  private String author;

  public BookDocument(final Book book) {
    this.id = book.getCode();
    this.name = book.getName();
    this.author = book.getAuthor();
  }

  public Book toDomain() {
    return Book.builder()
        .code(this.id)
        .name(this.name)
        .author(this.author)
        .build();
  }
}
