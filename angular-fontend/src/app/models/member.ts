import { PackageType } from "./package-type";
import { MemberType } from "./member-type";


export class Member {
  idMembers: number;
  fullName: string;
  address:string;
  croatianPIN: string;
  memberType: MemberType;
  email: string;
  gender: 'M' | 'F' | 'N';
  packageType: PackageType;

  constructor(
    idMembers: number,
    fullName: string,
    address: string,
    croatianPIN: string,
    memberType: MemberType,
    email: string,
    gender: 'M' | 'F' | 'N',
    packageType: PackageType
  ) {
    this.idMembers = idMembers;
    this.fullName = fullName;
    this.address=address;
    this.croatianPIN = croatianPIN;
    this.memberType = memberType;
    this.email = email;
    this.gender = gender;
    this.packageType = packageType;
  }
}
