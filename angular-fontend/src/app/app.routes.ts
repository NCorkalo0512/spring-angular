import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MembersComponent } from './members/members.component';
import { NewMemberComponent } from './new-member/new-member.component';


export const routes: Routes = [
    {path:'', redirectTo:'members-list', pathMatch:'full'},
    {path:'members-list', component:MembersComponent},
    {path:'new-member',component:NewMemberComponent},
 

];
@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule],
})
export class AppRoutingModule { }