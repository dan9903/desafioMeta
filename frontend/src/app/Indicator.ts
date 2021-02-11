import { Country } from "./Country";

export interface Indicator {
  indicatorId: String;
  year: Number;
  country: Country;
  unit: String;
  countryiso3code: String;
  decimal: Number;
  value: String;
  obs_status: String;
  indicatorDescription: String;
}
