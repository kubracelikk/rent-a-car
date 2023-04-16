package kodlama.io.rentacar.business.rules;


import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository repository;

    public void checkIfMaintenanceExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Böyle bir bakım bilgisine ulaşılamadı!");
    }

    public void chechkIfCarUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new RuntimeException("Araç şu anda bakımda!");
        }
    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new RuntimeException("Bakımda böyle bir araç bulunamadı!");
        }
    }

    public void checkCarAvailabilityforMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new RuntimeException("Araç kirada olduğu için bakıma alınamaz!");
        }
    }
}
