package hr.algebra.java.web.projekt.projekt.repository;


import hr.algebra.java.web.projekt.projekt.dto.MemberDTO;
import hr.algebra.java.web.projekt.projekt.models.Member;
import hr.algebra.java.web.projekt.projekt.models.MemberType;
import hr.algebra.java.web.projekt.projekt.models.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final MemberRepositoryInterface memberRepositoryInterface;
    private final MemberTypeRepositoryInterface memberTypeRepositoryInterface;

    @Autowired
    public MemberRepository(MemberRepositoryInterface memberRepositoryInterface, MemberTypeRepositoryInterface memberTypeRepositoryInterface) {
        this.memberRepositoryInterface = memberRepositoryInterface;
        this.memberTypeRepositoryInterface = memberTypeRepositoryInterface;
    }

    public List<Member> findAllMembers(){
        return  memberRepositoryInterface.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findMemberById(Integer id) {
        return memberRepositoryInterface.findById(id);
    }

    public List<Member> findMembersByPackageType(PackageType packageType) {
        return memberRepositoryInterface.findByPackageType(packageType);
    }

    public List<Member> findMembersByFullNameContains(String fullName) {
        return memberRepositoryInterface.findByFullNameContains(fullName);
    }
    @Transactional
    public Member saveMember(MemberDTO memberDTO){
       Member member= new Member();
       member.setFirstName(memberDTO.getFirstName());
       member.setLastName(memberDTO.getLastName());
       member.setAddress(memberDTO.getAddress());
       member.setCroatianPIN(memberDTO.getCroatianPIN());
        MemberType memberType = memberTypeRepositoryInterface.findById(memberDTO.getMemberTypeId())
                .orElseThrow(() -> new RuntimeException("Invalid member type ID: " + memberDTO.getMemberTypeId()));
        member.setMemberType(memberType);
       member.setEmail(memberDTO.getEmail());
       member.setGender(memberDTO.getGender());
       member.setPackageType(memberDTO.getPackageType());
       return  memberRepositoryInterface.save(member);
    }

    @Transactional
    public void deleteMember(Integer id) {
        memberRepositoryInterface.deleteById(id);
    }

    @Transactional
    public Member updateMember(Integer memberId, MemberDTO memberDTO) {
        Member existingMember= memberRepositoryInterface.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existingMember.setFirstName(memberDTO.getFirstName());
        existingMember.setLastName(memberDTO.getLastName());
        existingMember.setAddress(memberDTO.getAddress());
        existingMember.setCroatianPIN(memberDTO.getCroatianPIN());
        MemberType memberType = memberTypeRepositoryInterface.findById(memberDTO.getMemberTypeId())
                .orElseThrow(() -> new RuntimeException("Invalid member type ID: " + memberDTO.getMemberTypeId()));
        existingMember.setMemberType(memberType);
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setGender(memberDTO.getGender());
        existingMember.setPackageType(memberDTO.getPackageType());

        return memberRepositoryInterface.save(existingMember);
    }
}
