import { NgModule } from '@angular/core';
import {MatButtonModule,MatSidenavModule,MatToolbarModule,
        MatListModule,MatIconModule,MatCardModule,
        MatFormFieldModule,MatPaginatorModule,MatSortModule,MatInputModule,
        MatTableModule, MatSnackBarModule,MatGridListModule,
        MatDialogModule,MatExpansionModule,MatProgressSpinnerModule,
        MatMenuModule,MatDatepickerModule,MatNativeDateModule,MatOptionModule,MatSelectModule} from '@angular/material';

const MaterialComponents=[MatButtonModule,
                 MatSidenavModule,MatToolbarModule,MatIconModule, 
                 MatListModule,MatCardModule,MatFormFieldModule,MatFormFieldModule,
                MatPaginatorModule,MatSortModule,MatInputModule,MatTableModule,
                MatDialogModule,MatSnackBarModule,MatGridListModule,MatExpansionModule,
                MatProgressSpinnerModule,MatMenuModule,MatDatepickerModule ,
                MatNativeDateModule,MatOptionModule,MatSelectModule];

@NgModule({
  imports: [MaterialComponents],
  exports:[MaterialComponents]
})
export class MaterialModule { }
