package br.com.danielwisky.cleanarch.gateways.outputs.mongodb.repositories;

import br.com.danielwisky.cleanarch.gateways.outputs.mongodb.documents.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDocumentRepository extends MongoRepository<BookDocument, String> {

}
