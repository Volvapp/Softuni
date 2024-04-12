function solve(arr) {
  let number = 0;
  arr
    .sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase()))
    .forEach((element) => {
      console.log(`${++number}.${element} `);
    });
}
solve(["John", "Bob", "Christina", "Ema"]);
