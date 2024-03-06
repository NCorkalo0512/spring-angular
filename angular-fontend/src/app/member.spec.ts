import { Member } from "./models/member";
import { MemberType } from "./models/member-type";
import { PackageType } from "./models/package-type";
describe('Member', () => {
  it('should create an instance', () => {
   
    const memberType = { idMemberType: 2, name: 'Legal' };
    
    const member = {
      idMembers: 1,
      fullName: 'Maja Majic',
      croatianPIN: '54321678901',
      memberType: memberType, 
      email: 'maja.majic@mail.com',
      gender: 'F',
      packageType: PackageType.BASIC
    };

    expect(member).toBeTruthy();
  });
});