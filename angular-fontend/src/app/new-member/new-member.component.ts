
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,ReactiveFormsModule,Validators } from '@angular/forms';
import { MemberService } from '../services/member.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-new-member',
  templateUrl: './new-member.component.html',
  styleUrl: './new-member.component.css',
  imports: [CommonModule, ReactiveFormsModule],
  standalone: true
})
export class NewMemberComponent implements OnInit {
  newMemberForm!: FormGroup;
  constructor(private fb:FormBuilder, private memberService:MemberService, private router:Router){}
  ngOnInit() {
    this.newMemberForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(255)]],
      lastName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(255)]],
      address: [''],
      croatianPIN: [''], 
      memberTypeId: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(255)]],
      gender: ['', [Validators.required]],
      packageType: ['', [Validators.required]] 
    });
  }
  onSubmit() {
    if (this.newMemberForm.valid) {
      this.memberService.saveMember(this.newMemberForm.value).subscribe({
        next: (member) => {
          console.log('Member saved:', member);
          this.router.navigate(['/members-list']);
        },
        error: (err) => {
          console.error('Error saving member:', err);
          
        }
      });
    }
  }
}
  

