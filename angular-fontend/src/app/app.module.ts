import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { MembersComponent } from './members/members.component';
import { MemberService } from './services/member.service';
import { CommonModule } from '@angular/common';
import { NewMemberComponent } from './new-member/new-member.component';
import { AppRoutingModule } from './app.routes';
import { RouterModule, RouterOutlet } from '@angular/router';

@NgModule({
  declarations: [
   
    MembersComponent,
   NewMemberComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    AppRoutingModule,
  
  ],
  exports: [
  ],
  providers: [MemberService],
  bootstrap: [],
 
})
export class AppModule { }

