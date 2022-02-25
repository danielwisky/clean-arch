package br.com.danielwisky.cleanarch.gateways.outputs.kafka.resources;

import br.com.danielwisky.cleanarch.domains.Book;
import lombok.Data;

@Data
public class BookNotifyJson {

  private String code;
  private String name;
  private String author;

  public BookNotifyJson(final Book book) {
    this.code = book.getCode();
    this.name = book.getName();
    this.author = book.getAuthor();
  }
}
