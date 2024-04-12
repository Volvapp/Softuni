function solve(words, text) {
  arrOfWords = words.split(", ");
  let textArr = text.split(" ");
  for (let i = 0; i < textArr.length; i++) {
    if (textArr[i].startsWith("*")) {
      for (let k = 0; k < arrOfWords.length; k++) {
        if (arrOfWords[k].length === textArr[i].length) {
          textArr[i] = arrOfWords[k];
        }
      }
    }
  }
  console.log(textArr.join(' '));
}
solve(
  "great, learning",
  "softuni is ***** place for ******** new programming languages"
);
