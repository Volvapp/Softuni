function solve(num) {
  let text = num.toString();
  let flag = true;
  let firstNum = Number(text[0]);
  let result = 0;
  for (let i = 0; i < text.length; i++) {
    if (Number(text[i]) !== firstNum) {
      flag = false;
    }
    result += Number(text[i]);
}
console.log(flag)
console.log(result)
}
solve(22232222);
