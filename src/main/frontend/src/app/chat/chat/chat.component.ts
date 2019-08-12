import {AfterViewChecked, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ChatService} from "../chat.service";
import {UserMessage} from "./model/user-message";
import {BotMessage} from "./model/bot-message";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit, AfterViewChecked {

  public userMessage: UserMessage;

  public userMessages: UserMessage[];

  public botMessages: BotMessage[];

  public messages: {author: string, text: string, time: Date}[];

  public waitingResponse: boolean;

  @ViewChild('messageContainer', {static: false})
  messageContainer: ElementRef;

  @ViewChild('chatForm', {static: false})
  chatForm: NgForm;

  constructor(private chatService: ChatService) { }

  ngOnInit() {
    this.userMessage = {} as UserMessage;
    this.messages = [];
    this.userMessages = [];
    this.botMessages = [];
    this.waitingResponse = false;
  }

  ngAfterViewChecked(): void {
    this.messageContainer.nativeElement.scrollTop = this.messageContainer.nativeElement.scrollHeight;
  }

  sendMessage() {
    this.waitingResponse = true;
    this.userMessage.author = 'User';
    this.userMessage.time = new Date();
    this.userMessages.push(this.userMessage);
    this.messages.push(this.userMessage);
    this.chatService.getAnswer(this.userMessage)
      .subscribe((response: BotMessage) => {
        this.botMessages.push(response);
        this.messages.push(response);
        this.messages = [...this.messages];
      }, (error: any) => {
        //
      }, () => {
        this.chatForm.resetForm();
        this.waitingResponse = false;
      });
    this.userMessage = {} as UserMessage;
  }
}
