import { Injectable } from '@angular/core';

@Injectable()
export class AppConfigService {
    public uri: string = "http://localhost:8080/Geromino/api";
}
