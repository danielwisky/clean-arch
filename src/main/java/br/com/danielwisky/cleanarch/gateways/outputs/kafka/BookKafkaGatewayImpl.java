package br.com.danielwisky.cleanarch.gateways.outputs.kafka;

import br.com.danielwisky.cleanarch.domains.Book;
import br.com.danielwisky.cleanarch.gateways.BookExternalGateway;
import br.com.danielwisky.cleanarch.gateways.outputs.kafka.resources.BookNotifyJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookKafkaGatewayImpl implements BookExternalGateway {

  private final KafkaTemplate<String, String> kafkaTemplate;

  private final ObjectMapper objectMapper;

  @Override
  public void notify(final Book book) {
    final String json = convertToJson(book);
    kafkaTemplate.send("clean-arch.book.broadcast", json);
  }

  private String convertToJson(final Book book) {
    try {
      return objectMapper.writeValueAsString(new BookNotifyJson(book));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
