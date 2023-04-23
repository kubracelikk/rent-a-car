package kodlama.io.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import kodlama.io.rentacar.common.utils.annotations.NotFutureYear;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @Min(1998)
    //@Max(2023)
    @NotFutureYear //custom annotation
    private int modelYear;
    private String plate;
    @Min(1)
    private double dailyPrice;

    //private State state;
    private int modelId;


}
