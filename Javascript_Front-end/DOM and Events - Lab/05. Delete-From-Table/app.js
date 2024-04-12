function deleteByEmail() {
  const email = document.querySelector('input[name="email"]').value;

  const emailBoxes = Array.from(
    document.querySelectorAll("td:nth-child(even)")
  );

  const user = emailBoxes.find((box) => box.textContent === email);

  const result = document.querySelector("#result");

  if (user) {
    user.parentElement.remove();
    result.textContent = "Deleted.";
  } else {
    result.textContent = "Not found.";
  }
}
