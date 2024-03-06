import { Component, NgModule, OnInit } from '@angular/core';
import { Member } from '../models/member';
import { MemberService } from '../services/member.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})

export class MembersComponent implements OnInit {
  members: Member[] = [];

  constructor(private memberService: MemberService, private router:Router) { }

  ngOnInit() {
    this.getMembers();
  }

  getMembers(): void {
    this.memberService.getAllMembers().subscribe(
      members => this.members = members
    );
  }


  
}
