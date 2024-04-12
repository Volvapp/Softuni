function solve() {
  document.querySelector("#searchBtn").addEventListener("click", onClick);

  function onClick() {
    const searchedUser = document.querySelector("#searchField");
    const allInput = Array.from(document.querySelectorAll("tbody td"));
    const activeRows = Array.from(document.querySelectorAll("tbody tr.select"));

    activeRows.forEach((row) => {
      row.classList.remove("select");
    });

    allInput.forEach((input) => {
      if (input.textContent.includes(searchedUser.value)) {
        input.parentElement.classList.add("select");
      }
    });

    searchedUser.value = "";
  }
}
