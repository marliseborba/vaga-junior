package vaga_junior.vaga_junior.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
