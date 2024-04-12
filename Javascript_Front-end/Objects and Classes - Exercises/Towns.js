function solve(arr) {
  arr
    .map((city) => {
      const [name, lat, long] = city.split(" | ");
      return {
        town: name,
        latitude: Number(lat).toFixed(2),
        longitude: Number(long).toFixed(2),
      }; // return {name, lat, long}
    })
    .forEach((city) => {
      console.log(city);
    });
}
solve(["Sofia | 42.696552 | 23.32601", "Beijing | 39.913818 | 116.363625"]);
