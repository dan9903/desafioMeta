import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { Country } from "./Country";
import { Indicator } from "./Indicator";

const API_URL = "http://localhost:8080/country";

@Injectable({
  providedIn: "root",
})
export class ApiService {
  constructor(private http: HttpClient) {}

  public getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${API_URL}/codes`);
  }

  public getIndicators(code: String): Observable<Indicator[]> {
    return this.http.get<Indicator[]>(`${API_URL}indicators/${code}`);
  }
}
