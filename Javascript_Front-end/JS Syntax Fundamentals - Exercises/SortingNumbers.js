function solve(arr) {
  let newArr = [];
  let temp = 0;
  arr.sort((a,b)=> a-b);
  for (let i = 0; i < arr.length; i++) {
    if (i % 2 === 0) {
      newArr[i] = arr[i - temp];
    } else {
      newArr[i] = arr[arr.length - 1 - temp];
      temp++;
    }
  }
  return newArr;
}
solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);
