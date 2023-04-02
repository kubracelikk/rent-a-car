package kodlama.io.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllMaintenancesResponse {
    private int id;
    private LocalDate sentDate;
    private LocalDate returnDate;
    private String description;
    private int carId;
}
