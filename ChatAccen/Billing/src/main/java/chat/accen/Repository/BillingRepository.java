package chat.accen.Repository;

import chat.accen.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    public List<Billing> findBillingsByIdUser(Long idUser);
}
