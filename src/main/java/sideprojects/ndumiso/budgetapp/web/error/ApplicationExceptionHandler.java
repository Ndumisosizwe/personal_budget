package sideprojects.ndumiso.budgetapp.web.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sideprojects.ndumiso.budgetapp.web.error.exception.ApplicationException;

import javax.validation.constraints.NotNull;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity handleApplicationExceptions(ApplicationException e) {
        return ResponseEntity.badRequest().body(new HttpClientResponse(e.getMessage()));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity handleRuntimeExceptions(RuntimeException e) {
        return ResponseEntity.badRequest().body(new HttpClientResponse(e.getMessage()));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class HttpClientResponse {

        @NotNull
        private String message;

    }
}
