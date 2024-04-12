function solve(num) {
  if (num === 100) {
    console.log("100% Complete!");
    console.log("[%%%%%%%%%%]");
    return;
  }

  let filledBlocks = Math.floor(num / 10);
  let emptyBlocks = 10 - filledBlocks;

  let loadingBar = `${num}% [${"%".repeat(filledBlocks)}${".".repeat(emptyBlocks)}]`;
  console.log(loadingBar);
  console.log("Still loading...");
}
solve(80);
