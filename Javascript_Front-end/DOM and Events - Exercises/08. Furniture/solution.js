function solve() {
  const button = document.querySelector("#exercise button");

  button.addEventListener("click", parseFurnitureInput);
}
function parseFurnitureInput() {
  const input = Json.parse(document.querySelector("#exercise textarea").value);

  input.map((furniture) => {
    const row = document.createElement("tr");

    const cell = document.createElement("td");
  });
}
