import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'cm-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'cargo-management';

  // serverTime: string;

  constructor(private readonly http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/api/time').subscribe(console.log);
  }
}
