function solve() {
  const inputArea = document.querySelector("#input").value.split(".");
  //clears empty spaces
  inputArea.pop();
  const container = document.querySelector("#output");

  while (inputArea.length > 0) {
    const p = document.createElement("p");
    p.textContent = inputArea
      .splice(0, 3)
      .map((text) => text.trim())
      .join(".") + '.';
    container.appendChild(p);
  }
}
