import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment.html',
  styleUrl: './reactive-enrollment.css',
})
export class ReactiveEnrollment {

  enrollmentForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.enrollmentForm = this.fb.group({
      studentName: ['', Validators.required],
      studentEmail: ['', [Validators.required, Validators.email]],
      courseId: ['', Validators.required],
      preferredSemester: ['Odd'],
      agreeToTerms: [false, Validators.requiredTrue]
    });
  }

  onSubmit() {
    if (this.enrollmentForm.valid) {
      console.log(this.enrollmentForm.value);
    }
  }
}