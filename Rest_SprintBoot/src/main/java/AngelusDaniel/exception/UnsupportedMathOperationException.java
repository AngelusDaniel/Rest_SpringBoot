package AngelusDaniel.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

  public UnsupportedMathOperationException(String exception) {
    super(exception);
  }

}
