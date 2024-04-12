const obj = { a: 1, b: 2, c: 3 };
for (const key in obj) {
  console.log(key + ": " + obj[key]);
}
//for...in

const arr = [1, 2, 3, 4];
for (const element of arr) {
  console.log(element);
}
//for...of

//Важно е да се отбележи, че for...of цикълът е предназначен за итериране през итерируеми обекти (като масиви),
//докато for...in цикълът е предназначен за итериране през свойствата на обект.


//