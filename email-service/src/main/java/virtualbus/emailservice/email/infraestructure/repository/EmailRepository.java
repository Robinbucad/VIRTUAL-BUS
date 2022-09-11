package virtualbus.emailservice.email.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.emailservice.email.domain.EmailEntity;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<EmailEntity,Long > {

    Optional<EmailEntity> findEmailByEmail(String email);
}
