function solve(textToSplit) {
    const regex = /([A-Z][a-z]+)/g;
    const words = textToSplit.match(regex);
    const result = words.join(", ");
    console.log(result);
}
solve("SplitMeIfYouCanHaHaYouCantOrYouCan");
