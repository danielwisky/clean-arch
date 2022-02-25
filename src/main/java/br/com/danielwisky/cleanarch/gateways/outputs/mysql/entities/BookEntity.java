package br.com.danielwisky.cleanarch.gateways.outputs.mysql.entities;

import br.com.danielwisky.cleanarch.domains.Book;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "books")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 120)
  private String name;
  @Column(nullable = false, length = 60)
  private String author;

  public BookEntity(final Book book) {
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
