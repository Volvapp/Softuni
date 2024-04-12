function phoneBook(arr) {
  for (const iterator of arr) {
    let token = iterator.split(" ");
    let firstName = token[0];
    let phoneNumber = token[1];
    phoneBook[firstName] = phoneNumber;
  }
  for (const key in phoneBook) {
    console.log(`${key} -> ${phoneBook[key]}`);
  }
}
phoneBook([
  "Tim 0834212554",
  "Peter 0877547887",
  "Bill 0896543112",
  "Tim 0876566344",
]);
