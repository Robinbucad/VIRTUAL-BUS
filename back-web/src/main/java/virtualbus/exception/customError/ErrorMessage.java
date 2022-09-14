package virtualbus.exception.customError;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class ErrorMessage {
    private int httpCode;
    private String msgError;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TypeErrorEnum type;

    public ErrorMessage(int httpCode,String msgError, Date date,TypeErrorEnum type){
        this.httpCode = httpCode;
        this.msgError = msgError;
        this.date = date;
        this.type = type;
    }

    public ErrorMessage(){}
}
