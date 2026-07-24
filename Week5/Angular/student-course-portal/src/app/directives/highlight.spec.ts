import { HighlightDirective } from './highlight';
import { ElementRef } from '@angular/core';

describe('HighlightDirective', () => {

  it('should create an instance', () => {

    const elementRef = new ElementRef(document.createElement('div'));

    const directive = new HighlightDirective(elementRef);

    expect(directive).toBeTruthy();
  });

});