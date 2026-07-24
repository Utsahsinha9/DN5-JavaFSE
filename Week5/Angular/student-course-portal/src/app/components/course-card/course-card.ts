import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../services/course';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-card.html',
  styleUrls: ['./course-card.css']
})
export class CourseCardComponent {

  @Input() course!: Course;

  @Output()
  enrollRequested = new EventEmitter<number>();

  onEnrollClick() {
    this.enrollRequested.emit(this.course.id);
  }
}