import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from '../models/member';
import { PackageType } from '../models/package-type';


@Injectable({  providedIn: 'root'})
export class MemberService {
   
private membersUrl:string;

  constructor(private http: HttpClient) { 
    this.membersUrl='http://localhost:8080/api/members';
  }

  getAllMembers(): Observable<Member[]> {
    return this.http.get<Member[]>(this.membersUrl);
  }

  getMemberById(id: number): Observable<Member> {
    return this.http.get<Member>(`${this.membersUrl}/${id}`);
  }

  saveMember(member: Member): Observable<Member> {
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':'application/json'
      })
    }
    return this.http.post<Member>(this.membersUrl, member, httpOptions);
  }

  updateMember(id: number, member: Member): Observable<Member> {
    return this.http.put<Member>(`${this.membersUrl}/${id}`, member);
  }

  deleteMember(id: number): Observable<void> {
    return this.http.delete<void>(`${this.membersUrl}/${id}`);
  }

  getMembersByPackageType(packageType: PackageType): Observable<Member[]> {
    return this.http.get<Member[]>(`${this.membersUrl}/packageType/${packageType}`);
  }

  searchMembersByFullName(fullName: string): Observable<Member[]> {
    return this.http.get<Member[]>(`${this.membersUrl}/search?fullName=${fullName}`);
  }
}
