import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { CourseService, Course } from '../../services/course';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrls: ['./course-list.css']
})
export class CourseList implements OnInit {

  isLoading = true;
  courses: Course[] = [];
  selectedCourseId: number | null = null;
  errorMessage = '';

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.isLoading = true;

    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.courses = courses;
        this.isLoading = false;
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to load courses.';
        this.isLoading = false;
      }
    });
  }

  addSampleCourse(): void {
    const newCourse: Course = {
      id: 106,
      name: 'Node.js',
      code: 'NODE106',
      credits: 4,
      gradeStatus: 'pending'
    };

    this.courseService.addCourse(newCourse).subscribe({
      next: () => {
        alert('Course Added Successfully');
        this.loadCourses();
      },
      error: (err) => console.error(err)
    });
  }

  updateFirstCourse(): void {
    if (this.courses.length === 0) {
      return;
    }

    const updatedCourse: Course = {
      ...this.courses[0],
      name: 'Angular Advanced'
    };

    this.courseService.updateCourse(updatedCourse).subscribe({
      next: () => {
        alert('Course Updated Successfully');
        this.loadCourses();
      },
      error: (err) => console.error(err)
    });
  }

  deleteLastCourse(): void {
    if (this.courses.length === 0) {
      return;
    }

    const lastCourse = this.courses[this.courses.length - 1];

    this.courseService.deleteCourse(lastCourse.id).subscribe({
      next: () => {
        alert('Course Deleted Successfully');
        this.loadCourses();
      },
      error: (err) => console.error(err)
    });
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}