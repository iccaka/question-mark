import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  baseUrl: string = environment.baseUrl;

  registerForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {}

  onSubmit() {
    const registerUrl: string = `${this.baseUrl}/api/users/register`;

    this.httpClient.post<any>(registerUrl, this.registerForm.value).subscribe(
      (result) => {
        console.log(JSON.stringify(result));
      },
      (error) => console.log(error)
    );
  }
}
