function addressBook(arr) {
    const contacts = [];

    for (const iterator of arr) {
        const info = iterator.split(":");
        const firstName = info[0];
        const address = info[1];
        addressBook[firstName] = address;
    }
    
    const entries = Object.entries(addressBook);
  entries.sort((a, b) => a[0].localeCompare(b[0]));

  for (const [firstName, address] of entries) {
    console.log(`${firstName} -> ${address}`);
  }
}

addressBook([
  "Tim:Doe Crossing",
  "Bill:Nelson Place",
  "Peter:Carlyle Ave",
  "Bill:Ornery Rd",
]);
