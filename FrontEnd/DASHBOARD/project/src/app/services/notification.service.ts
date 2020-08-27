import { Injectable } from '@angular/core';
import { MatSnackBarConfig, MatSnackBar } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(public snackBar: MatSnackBar) { }

  config: MatSnackBarConfig = {
    duration: 3000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }


  success(msg) {
    this.config['panelClass'] = ['notification', 'success'];
    this.snackBar.open(msg, '',this.config);
  }

  error(msg) {
    this.config['panelClass'] = ['notification', 'error'];
    this.snackBar.open(msg, '',this.config);
  }
}