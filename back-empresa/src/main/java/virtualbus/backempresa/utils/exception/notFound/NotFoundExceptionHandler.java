package virtualbus.backempresa.utils.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import virtualbus.backempresa.utils.exception.customError.ErrorMessage;
import virtualbus.backempresa.utils.exception.customError.TypeErrorEnum;


import java.util.Date;

@RestControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> response (NotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(404,exception.getMessage(),new Date(), TypeErrorEnum.FATAL);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
