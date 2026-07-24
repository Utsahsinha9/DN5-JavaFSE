import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrls: ['./course-list.css']
})
export class CourseList implements OnInit {
  isLoading = true;

  courses = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS201', credits: 3, gradeStatus: 'pending' },
    { id: 3, name: 'Database Systems', code: 'CS301', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Computer Networks', code: 'CS401', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Software Engineering', code: 'CS501', credits: 4, gradeStatus: 'pending' }
  ];
  selectedCourseId: number | null = null;

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy avoids re-rendering every card when the array reference changes —
  // Angular only updates cards whose id actually changed, instead of destroying
  // and recreating every DOM node in the list.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}