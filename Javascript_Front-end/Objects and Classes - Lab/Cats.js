function solve(arr) {
  class Cat {
    constructor(name, age) {
      this.name = name;
      this.age = age;
    }
    meow() {
      console.log(`${this.name}, age ${this.age} says Meow`);
    }
  }
  let cats = [];
  for (let cat of arr) {
    let [name, age] = cat.split(" ");
    let currentCat = new Cat(name, age);
    cats.push(currentCat);
  }
  for (let cat of cats) {
    cat.meow();
  }
}

solve(["Mellow 2", "Tom 5"]);
