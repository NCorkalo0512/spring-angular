package hr.algebra.java.web.projekt.projekt.repository;

import hr.algebra.java.web.projekt.projekt.models.Member;
import hr.algebra.java.web.projekt.projekt.models.PackageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepositoryInterface  extends JpaRepository<Member,Integer> {
    List<Member> findByPackageType(PackageType packageType);

    @Query("SELECT m FROM Member m WHERE CONCAT(m.firstName, ' ', m.lastName) LIKE %?1%")
    List<Member> findByFullNameContains(String fullName);
}
