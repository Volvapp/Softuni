function solve(num1, num2) {
  fac1 = 1;
  for (let i = num1; i > 0; i--) {
    fac1 *= i;
  }
  fac2 = 1;
  for (let i = num2; i > 0; i--) {
    fac2 *= i;
  }
 
  console.log(`${(fac1 / fac2).toFixed(2)}`);
}
solve(5,2)