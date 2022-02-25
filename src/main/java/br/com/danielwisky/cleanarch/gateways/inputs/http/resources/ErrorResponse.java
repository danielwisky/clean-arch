package br.com.danielwisky.cleanarch.gateways.inputs.http.resources;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

  private List<String> errors;
}
