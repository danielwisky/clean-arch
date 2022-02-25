package br.com.danielwisky.cleanarch.gateways;

import br.com.danielwisky.cleanarch.domains.Book;

public interface BookDataGateway {

  Book save(Book book);
}
