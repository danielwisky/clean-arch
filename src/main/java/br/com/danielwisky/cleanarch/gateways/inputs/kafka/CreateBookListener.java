package br.com.danielwisky.cleanarch.gateways.inputs.kafka;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.inputs.kafka.resources.CreateBookJson;
import br.com.danielwisky.cleanarch.usecases.CreateBookUsecase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateBookListener {

  private final ObjectMapper objectMapper;

  private final CreateBookUsecase createBookUsecase;

  @KafkaListener(topics = "clean-arch.create-book.request")
  public void receiver(final String message) {
    try {
      final CreateBookJson createBookJson = convertMessage(message);
      final Book book = createBookJson.toDomain();

      createBookUsecase.execute(book);

    } catch (Exception e) {
      log.error("Error creating a book.", e);
    }
  }

  private CreateBookJson convertMessage(final String message) {
    try {
      return objectMapper.readValue(message, CreateBookJson.class);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
