package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    //@Nonnull
    //Maintenance findById(int id);
    Maintenance findMaintenanceByCarIdAndIsCompletedFalse(int carId); //id varsa ve durum false ise getirecek

    boolean existsByCarIdAndIsCompletedFalse(int carId); //businessrule
}
