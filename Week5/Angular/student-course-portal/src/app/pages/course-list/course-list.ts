import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';

import { CourseCardComponent } from '../../components/course-card/course-card';
import { CourseService, Course } from '../../services/course';

import * as CourseActions from '../../store/course.actions';
import { selectAllCourses, selectCoursesLoading } from '../../store/course.selectors';

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

  constructor(
    private courseService: CourseService,
    private store: Store
  ) {}

  ngOnInit(): void {

    // Dispatch action
    this.store.dispatch(CourseActions.loadCourses());

    // Read loading state
    this.store.select(selectCoursesLoading).subscribe(
      loading => this.isLoading = loading
    );

    // Read courses from store
    this.store.select(selectAllCourses).subscribe(
      courses => this.courses = courses
    );
  }

  addSampleCourse(): void {
    const newCourse: Course = {
      id: 106,
      name: 'Node.js',
      code: 'NODE106',
      credits: 4,
      gradeStatus: 'pending'
    };

    this.courseService.addCourse(newCourse).subscribe(() => {
      alert('Course Added Successfully');
      this.store.dispatch(CourseActions.loadCourses());
    });
  }

  updateFirstCourse(): void {

    if (this.courses.length === 0) return;

    const updatedCourse: Course = {
      ...this.courses[0],
      name: 'Angular Advanced'
    };

    this.courseService.updateCourse(updatedCourse).subscribe(() => {
      alert('Course Updated Successfully');
      this.store.dispatch(CourseActions.loadCourses());
    });
  }

  deleteLastCourse(): void {

    if (this.courses.length === 0) return;

    const lastCourse = this.courses[this.courses.length - 1];

    this.courseService.deleteCourse(lastCourse.id).subscribe(() => {
      alert('Course Deleted Successfully');
      this.store.dispatch(CourseActions.loadCourses());
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