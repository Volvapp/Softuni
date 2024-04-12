function solve(arr, numOfRotations) {
  for (let i = 0; i < numOfRotations; i++) {
    let temp = arr[0];
    arr.splice(0, 1);
    arr.push(temp);
  }
  let text = "";
  for (let i = 0; i < arr.length; i++) {
    text += arr[i] + " ";
  }
  console.log(text.trim());
}
solve([51, 47, 32, 61, 21], 2);
