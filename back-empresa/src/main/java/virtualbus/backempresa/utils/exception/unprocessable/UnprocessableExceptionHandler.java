package virtualbus.backempresa.utils.exception.unprocessable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import virtualbus.backempresa.utils.exception.customError.ErrorMessage;
import virtualbus.backempresa.utils.exception.customError.TypeErrorEnum;

import java.util.Date;

@RestControllerAdvice
public class UnprocessableExceptionHandler {

    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity<ErrorMessage> respone(UnprocessableException exception){
        ErrorMessage errorMessage = new ErrorMessage(422, exception.getMessage(), new Date(), TypeErrorEnum.FATAL);
        return new ResponseEntity<>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
