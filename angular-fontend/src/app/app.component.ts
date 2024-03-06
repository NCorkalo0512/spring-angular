import { Component, OnInit } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Member } from './models/member';
import { MemberService } from './services/member.service';
import { Router, RouterModule } from '@angular/router';
import { MembersComponent } from './members/members.component';
import { NewMemberComponent } from './new-member/new-member.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports:[CommonModule, RouterModule],

  standalone:true
})
export class AppComponent implements OnInit{
  members: Member[] = [];
  title: string;
 

  constructor(private memberService:MemberService, private router:Router) {
    this.title = 'Spring Boot - Angular Application';
  }
  
  ngOnInit() {
    this.getMembers();
  }

  getMembers(): void {
    this.memberService.getAllMembers().subscribe(
      members => this.members = members
    );
  }

  navigateToNewMember(){
    this.router.navigate(['new-member']);
  }

 
}
