// function colorize() {
//   const table = document.querySelector("table");
//   const rows = table.getElementsByTagName("tr");
// console.log(table);
// console.log(rows);
//   for (let i = 0; i < rows.length; i++) {
//     if (i % 2 === 1) {
//       rows[i].style.backgroundColor = "teal";
//     }
//   }
// }

function colorize() {
  const rows = Array.from(document.querySelectorAll("tr:nth-child(even)"));
  rows.forEach((row) => {
    row.style.background = "teal";
  });
}
