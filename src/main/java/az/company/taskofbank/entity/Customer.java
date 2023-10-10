package az.company.taskofbank.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String surname;

    private String birthDate;

    private String gsmNumber;

    private Double balance=100.00;
    @Column(unique = true)

    private Long cardId;

    private Long amount;
}
