package hr.algebra.java.web.projekt.projekt.controller;


import hr.algebra.java.web.projekt.projekt.dto.MemberTypeDTO;
import hr.algebra.java.web.projekt.projekt.models.MemberType;
import hr.algebra.java.web.projekt.projekt.repository.MemberTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memberTypes")
@AllArgsConstructor
public class MemberTypeController {

    private final MemberTypeRepository memberTypeRepository;

    @GetMapping
    public List<MemberType> getAllMemberTypes(){
        return memberTypeRepository.findAllMemberTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberType> getMemberTypeById(@PathVariable Integer id) {
        Optional<MemberType> memberType= memberTypeRepository.findMemberTypeById(id);
        return memberType.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MemberType> createMemberType(@Validated @RequestBody MemberTypeDTO memberTypeDTO) {
        MemberType savedMemberType = memberTypeRepository.saveMemberType(memberTypeDTO);
        return new ResponseEntity<>(savedMemberType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberType> updateMemberType(@PathVariable Integer id, @Validated @RequestBody MemberTypeDTO memberTypeDTO) {
        MemberType updatedMemberType = memberTypeRepository.updateMmemberType(id, memberTypeDTO);
        return ResponseEntity.ok(updatedMemberType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemberType(@PathVariable Integer id) {
        memberTypeRepository.deleteMemberType(id);
        return ResponseEntity.noContent().build();
    }
}
