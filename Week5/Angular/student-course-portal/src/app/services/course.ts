import { Injectable } from '@angular/core';

export interface Course {
  id: number;
  name: string;
  instructor: string;
  duration: string;
  enrolledStudents: number;
}

@Injectable({
  providedIn: 'root',
})
export class CourseService {

  private courses: Course[] = [
    {
      id: 101,
      name: 'Angular',
      instructor: 'John Doe',
      duration: '8 Weeks',
      enrolledStudents: 45
    },
    {
      id: 102,
      name: 'Java',
      instructor: 'Jane Smith',
      duration: '10 Weeks',
      enrolledStudents: 60
    },
    {
      id: 103,
      name: 'Spring Boot',
      instructor: 'David Johnson',
      duration: '6 Weeks',
      enrolledStudents: 35
    },
    {
      id: 104,
      name: 'Python',
      instructor: 'Emily Brown',
      duration: '8 Weeks',
      enrolledStudents: 50
    },
    {
      id: 105,
      name: 'React',
      instructor: 'Michael Lee',
      duration: '7 Weeks',
      enrolledStudents: 40
    }
  ];

  getCourses(): Course[] {
    return this.courses;
  }
}