import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserMessage} from "./chat/model/user-message";
import {Observable} from "rxjs";
import {BotMessage} from "./chat/model/bot-message";

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  constructor(private httpClient: HttpClient) { }

  public getAnswer(userMessage: UserMessage): Observable<BotMessage> {
    const apiUrl = environment.apiUrl;

    return this.httpClient.post<BotMessage>(apiUrl + '/chat', userMessage);
  }
}
