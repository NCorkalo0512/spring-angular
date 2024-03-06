package hr.algebra.java.web.projekt.projekt.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMembers;

    @Column(nullable = false, length = 255)
    private String firstName;

    @Column(nullable = false, length = 255)
    private String lastName;

    @Column(length = 255)
    private String address;

    @Column(length = 11)
    private String croatianPIN;

    public String getFullName() {
        return firstName + " " + lastName;
    }
    @ManyToOne
    @JoinColumn(name = "memberTypeId", nullable = false)
    private MemberType memberType;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 1)
    private String gender; // 'M', 'F' ili 'N'

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PackageType packageType;
}
