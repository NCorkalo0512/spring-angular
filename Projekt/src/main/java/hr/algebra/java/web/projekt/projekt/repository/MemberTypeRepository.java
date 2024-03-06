package hr.algebra.java.web.projekt.projekt.repository;

import hr.algebra.java.web.projekt.projekt.dto.MemberTypeDTO;
import hr.algebra.java.web.projekt.projekt.models.Member;
import hr.algebra.java.web.projekt.projekt.models.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberTypeRepository {

    private final MemberTypeRepositoryInterface memberTypeRepositoryInterface;


    @Autowired
    public MemberTypeRepository(MemberTypeRepositoryInterface memberTypeRepositoryInterface) {
        this.memberTypeRepositoryInterface = memberTypeRepositoryInterface;
    }

    public List<MemberType> findAllMemberTypes(){
        return memberTypeRepositoryInterface.findAll();
    }

    public Optional<MemberType> findMemberTypeById(Integer idMemberType){
        return memberTypeRepositoryInterface.findById(idMemberType);
    }

    @Transactional
    public MemberType saveMemberType(MemberTypeDTO memberTypeDTO){
        MemberType memberType= new MemberType();
        memberType.setName(memberTypeDTO.getName());
        return memberTypeRepositoryInterface.save(memberType);
    }
    @Transactional
    public MemberType updateMmemberType(Integer memberTypeId, MemberTypeDTO memberTypeDTO){
      MemberType existingMemberType= memberTypeRepositoryInterface.findById(memberTypeId)
              .orElseThrow(()-> new RuntimeException("Member type not found"));

      existingMemberType.setName(memberTypeDTO.getName());
      return memberTypeRepositoryInterface.save(existingMemberType);
    }
    @Transactional
    public void deleteMemberType(Integer idMemberType) {
        memberTypeRepositoryInterface.deleteById(idMemberType);
    }
}
