import { Observable } from "rxjs";
import { ApiService } from "../api.service";
import { Country } from "../Country";
import { Indicator } from "../Indicator";
import { Component, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";

@Component({
  selector: "app-indicator",
  templateUrl: "./indicator.component.html",
  styleUrls: ["./indicator.component.css"],
})
export class IndicatorComponent implements OnInit {
  indicators: Observable<Indicator[]>;
  tableDataSrc: any;
  tableCols: String[] = [
    "indicatorId",
    "year",
    "unit",
    "country iso code",
    "decimal",
    "value",
    "obs status",
    "indicatorDescription",
  ];
  tableData: Indicator[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getIndicators();
    this.tableDataSrc = new MatTableDataSource(this.tableData);
  }

  public getIndicators(): void {
    this.indicators = this.apiService.getIndicators("BRA");
    //this.tableData =
    this.indicators.forEach((ind) => {
      this.tableData = ind;
    });
  }
}
