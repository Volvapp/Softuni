function solve(firstName, lastName, hairColor) {
    let person = {
      name: firstName,
      lastName: lastName,
      hairColor: hairColor,
    };
  
    console.log(JSON.stringify(person));
  }
  solve("Kristiyan", "Pavlov", "Brown-ish")