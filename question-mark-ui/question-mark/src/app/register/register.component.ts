import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {}

  onSubmit() {
    const registerUrl: string = `http://localhost:8080/api/users/register`;

    this.httpClient.post<any>(registerUrl, this.registerForm.value).subscribe(
      (result) => {
        console.log(JSON.stringify(result));
      },
      (error) => console.log(error)
    );
  }
}
