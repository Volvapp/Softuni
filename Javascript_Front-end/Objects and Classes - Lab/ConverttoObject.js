function solve(params) {
    let person = JSON.parse(params);
  
    for (const key in person) {
      console.log(`${key}: ${person[key]}`);
    }
  }
  solve('{"name": "Kristiyan", "lastName": "Pavlov", "age": "20"}' )