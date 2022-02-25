package br.com.danielwisky.cleanarch.gateways.inputs.http;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.danielwisky.cleanarch.gateways.inputs.http.resources.ErrorResponse;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public HttpEntity<ErrorResponse> handlerIllegalArgumentException(
      final IllegalArgumentException ex) {
    return new ResponseEntity<>(createMessage(ex), createHeaders(), HttpStatus.BAD_REQUEST);
  }

  private HttpHeaders createHeaders() {
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
    return responseHeaders;
  }

  private ErrorResponse createMessage(final Throwable ex) {
    ErrorResponse message = null;
    if (isNotBlank(ex.getMessage())) {
      message = new ErrorResponse(List.of(ex.getMessage()));
    }
    return message;
  }
}
