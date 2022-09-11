package virtualbus.emailservice.email.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.emailservice.email.domain.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity,Long > {
}
