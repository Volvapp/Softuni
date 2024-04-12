function solve(arr) {
  let data = [];
  arr.forEach((hero) => {
    const line = hero.split(" / ");
    const name = line[0];
    const level = Number(line[1]);
    const items = line[2];

    data.push({
      name,
      level,
      items,
    });
  });
  data
    .sort((a, b) => a.level - b.level)
    .forEach((e) => {
      console.log(`Hero: ${e.name}`);
      console.log(`level => ${e.level}`);
      console.log(`items => ${e.items}`);
    });
}
solve([
  "Isacc / 25 / Apple, GravityGun",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
]);
