package br.com.danielwisky.cleanarch.gateways;

import br.com.danielwisky.cleanarch.domains.Book;

public interface BookExternalGateway {

  void notify(Book book);
}
