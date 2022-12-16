package me.dio.gameawards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoContentException extends RuntimeException {
    public NoContentException(Long id) {
        super("Game not found with ID: " + id);
    }
}
