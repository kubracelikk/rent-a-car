package kodlama.io.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name = "brand_id")
    private Brand brand; //modelin bir tane markası olabilir
    @OneToMany(mappedBy = "model")
   //@JsonBackReference
    private List<Car> cars;

}
