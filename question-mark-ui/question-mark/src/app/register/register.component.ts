import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../models/user';

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

  user: User = {
    username: 'test',
    email: 'test.user@email.com',
    password: 'asdf',
  };

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.httpClient
      .post<User>('http://localhost:8080/api/users/register', this.user)
      .subscribe(
        (result) => {
          console.log(result);
        },
        (error) => console.log(error)
      );
  }

  onSubmit() {}
}
