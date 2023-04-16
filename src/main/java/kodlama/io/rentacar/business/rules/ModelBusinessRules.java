package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkIfModelExists(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Böyle bir model bulunamadı!");
        }
    }

}
