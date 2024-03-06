package hr.algebra.java.web.projekt.projekt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MemberTypes")
public class MemberType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMemberType;

    @Column(nullable = false, length = 255)
    private String name;
}
