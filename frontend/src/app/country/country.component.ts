import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Observable } from "rxjs";
import { ApiService } from "../api.service";
import { Country } from "../Country";

@Component({
  selector: "app-country",
  templateUrl: "./country.component.html",
  styleUrls: ["./country.component.css"],
})
export class CountryComponent implements OnInit {
  countries: Observable<Country[]>;

  constructor(private apiService: ApiService) {}

  form = new FormGroup({
    website: new FormControl("", Validators.required),
  });

  get f() {
    return this.form.controls;
  }

  submit() {
    console.log(this.form.value);
  }

  ngOnInit(): void {
    this.getCountries();
  }

  public getCountries(): void {
    this.countries = this.apiService.getCountries();
  }
}
