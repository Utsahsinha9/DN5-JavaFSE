import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrls: ['./course-list.css']
})
export class CourseList  {
  courses = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4 },
    { id: 2, name: 'Operating Systems', code: 'CS201', credits: 3 },
    { id: 3, name: 'Database Systems', code: 'CS301', credits: 4 },
    { id: 4, name: 'Computer Networks', code: 'CS401', credits: 3 },
    { id: 5, name: 'Software Engineering', code: 'CS501', credits: 4 }
  ];
  selectedCourseId: number | null = null;

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}