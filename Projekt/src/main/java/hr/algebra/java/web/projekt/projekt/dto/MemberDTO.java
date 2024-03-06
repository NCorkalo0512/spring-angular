package hr.algebra.java.web.projekt.projekt.dto;


import hr.algebra.java.web.projekt.projekt.models.PackageType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 255, message = "First name must be between 2 and 255 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters")
    private String lastName;
    private String address;

    @Size(max = 11, message = "CroatianPIN must be 11 characters")
    private String croatianPIN; // OIB

    @NotNull(message = "Member type is required")
    private Integer memberTypeId; // (1 - Personal, 2 - Legal)

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "[MFN]", message = "Gender must be 'M', 'F', or 'N'")
    private String gender; // 'M', 'F', ili 'N'

    @NotNull(message = "Package type is required")
    private PackageType packageType; //  (Start, Basic, Classic, Exclusive)

}
