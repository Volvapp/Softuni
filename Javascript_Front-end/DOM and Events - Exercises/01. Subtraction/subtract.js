function subtract() {
  const firstNum = Number(document.querySelector("#firstNumber").value);
  const secondNum = Number(document.querySelector("#secondNumber").value);

  const sum = firstNum - secondNum;

  const result = document.querySelector("#result");
  result.textContent = sum;
}
