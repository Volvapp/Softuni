function solve(word, text) {
  text = text.split(" ");
  for (let i = 0; i < text.length; i++) {
    if (text[i].toLowerCase() === word.toLowerCase()) {
      console.log(word);
      return;
    }
  }
  console.log(`${word} not found!`);
}

solve("python", "JavaScript is the best programming language");
