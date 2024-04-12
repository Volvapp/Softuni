function solve(arr) {
  let dictionary = {};

  arr.forEach((jsonString) => {
    const obj = JSON.parse(jsonString);
    const term = Object.keys(obj)[0];
    const definition = obj[term];
    dictionary[term] = definition;
  });

  const sortedTerms = Object.keys(dictionary).sort();

  sortedTerms.forEach((term) => {
    const definition = dictionary[term];
    console.log(`Term: ${term} => Definition: ${definition}`);
  });
}
solve([
  '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of atropical shrub."}',
  '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the publicon a fixed route and for a fare."}',
  '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
  '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
  '{"Microphone":"An instrument for converting sound waves into electrical energy variations"}',
]);
