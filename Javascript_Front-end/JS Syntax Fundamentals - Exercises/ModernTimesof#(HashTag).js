function solve(text) {
  const pattern = new RegExp("#[A-Za-z]+");

  let textArr = text.split(" ");
  let specialWords = [];
  for (let i = 0; i < textArr.length; i++) {
    let currentWord = textArr[i];
    if (textArr[i].match(pattern)) {
      specialWords.push(textArr[i].replace("#", ""));
    }
  }
  for (let i = 0; i < specialWords.length; i++) {
    console.log(specialWords[i]);
  }
}
solve(
  "The symbol # is known #variously in English-speaking #regions as the #number sign"
);
