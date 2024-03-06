package hr.algebra.java.web.projekt.projekt.controller;


import hr.algebra.java.web.projekt.projekt.dto.MemberDTO;
import hr.algebra.java.web.projekt.projekt.models.Member;
import hr.algebra.java.web.projekt.projekt.models.PackageType;
import hr.algebra.java.web.projekt.projekt.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAllMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member>getMemberById(@PathVariable Integer id){
        Optional<Member> member= memberRepository.findMemberById(id);
        return  member.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@Validated @RequestBody MemberDTO memberDTO) {
        Member savedMember = memberRepository.saveMember(memberDTO);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Integer id,@Validated @RequestBody MemberDTO memberDTO) {
        Member updatedMember = memberRepository.updateMember(id, memberDTO);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        memberRepository.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/packageType/{packageType}")
    public ResponseEntity<List<Member>> getMembersByPackageType(@PathVariable PackageType packageType) {
        List<Member> members = memberRepository.findMembersByPackageType(packageType);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> getMembersByFullNameContains(@RequestParam String fullName) {
        List<Member> members = memberRepository.findMembersByFullNameContains(fullName);
        return ResponseEntity.ok(members);
    }
}
