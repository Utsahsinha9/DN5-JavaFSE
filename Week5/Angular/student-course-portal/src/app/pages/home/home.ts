import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService, Course } from '../../services/course';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home implements OnInit {

  courses: Course[] = [];
  totalCourses = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courseService.getCourses().subscribe({
      next: (data) => {
        this.courses = data;
        this.totalCourses = data.length;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
}