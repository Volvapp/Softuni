function extractOddWords(sentence) {
  const words = sentence.toLowerCase().split(" ");
  const oddWords = [];

  for (let i = 0; i < words.length; i++) {
    const currentWord = words[i];
    let count = 0;

    for (let j = 0; j < words.length; j++) {
      if (words[j] === currentWord) {
        count++;
      }
    }

    if (count % 2 !== 0 && !oddWords.includes(currentWord)) {
      oddWords.push(currentWord);
    }
  }

  const oddWordsString = oddWords.join(" ");
  console.log(oddWordsString);
}

solve("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
