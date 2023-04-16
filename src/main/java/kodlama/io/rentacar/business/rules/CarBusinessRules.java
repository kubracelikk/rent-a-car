package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    public void checkIfCarExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Böyle bir araç bulunamadı!");
    }
}
