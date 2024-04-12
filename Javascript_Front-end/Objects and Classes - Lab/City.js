function printCityInfo(city) {
  for (const key in city) {
    console.log(key + " -> " + city[key]);
  }
}
const city = {
  name: "Sofia",
  area: 492,
  population: 1234567,
  postCode: 1000,
  country: 'Bulgaria',
};

printCityInfo(city)