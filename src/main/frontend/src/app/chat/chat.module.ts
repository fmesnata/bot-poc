import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChatComponent} from './chat/chat.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule, MatCardModule, MatInputModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";
import {ScrollingModule} from "@angular/cdk/scrolling";


@NgModule({
  declarations: [ChatComponent],
  exports: [
    ChatComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    FlexLayoutModule,
    ScrollingModule,
    MatCardModule
  ]
})
export class ChatModule { }
