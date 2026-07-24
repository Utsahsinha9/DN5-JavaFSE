import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [],
  templateUrl: './course-card.html',
  styleUrls: ['./course-card.css']
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number };
  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Previous course:', changes['course'].previousValue);
      console.log('Current course:', changes['course'].currentValue);
    }
  }
}