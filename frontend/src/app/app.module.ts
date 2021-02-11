import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { MatTableModule } from "@angular/material/table";

import { AppComponent } from "./app.component";
import { CountryComponent } from "./country/country.component";
import { FormsModule } from "@angular/forms";
import { IndicatorComponent } from "./indicator/indicator.component";

@NgModule({
  declarations: [AppComponent, CountryComponent, IndicatorComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, MatTableModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
