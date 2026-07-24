import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrls: ['./course-card.css']
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus: string };
  @Output() enrollRequested = new EventEmitter<number>();

  isEnrolled = false;
  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Previous course:', changes['course'].previousValue);
      console.log('Current course:', changes['course'].currentValue);
    }
  }

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  get borderStyle() {
    const colors: { [key: string]: string } = {
      passed: 'green',
      failed: 'red',
      pending: 'grey'
    };
    return { 'border-left': `4px solid ${colors[this.course.gradeStatus]}` };
  }

  toggleExpand() {
    this.isExpanded = !this.isExpanded;
  }

  onEnrollClick() {
    this.isEnrolled = !this.isEnrolled;
    this.enrollRequested.emit(this.course.id);
  }
}