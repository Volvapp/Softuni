function solve(input) {
  const searchedWords = input[0].split(" ");
  let containedWords = [];

  for (let i = 0; i < searchedWords.length; i++) {
    const currentWord = searchedWords[i];
    let counter = 0;

    for (let j = 1; j < input.length; j++) {
        let temp = input[j]
      if (input[j] ===(currentWord)) {
        counter++;
      }
    }
    containedWords.push({
      currentWord,
      counter,
    });
  }
  containedWords
    .sort((a, b) => b.counter - a.counter)
    .forEach((w) => {
      console.log(w.currentWord + " - " + w.counter);
    });
}

solve([
  "is the",
  "first",
  "sentence",
  "Here",
  "is",
  "another",
  "the",
  "And",
  "finally",
  "the",
  "the",
  "sentence",
]);
