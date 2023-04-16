package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;

    public void checkIfBrandExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Marka bulunamadı!");
    }
}
