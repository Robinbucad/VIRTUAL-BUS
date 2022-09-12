package virtualbus.emailservice.email.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "emails")
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    @Enumerated(EnumType.STRING)
    private ReservaStatus reservaStatus;

    public EmailEntity(String email){
        setEmail(email);
        setReservaStatus(ReservaStatus.ACEPTADO);
    }

    public EmailEntity(){}

}
