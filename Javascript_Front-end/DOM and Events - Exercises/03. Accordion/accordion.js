function toggle() {
  const content = document.querySelector("#extra");
  const button = document.querySelector("span.button");

  if (content.style.display !== "block") {
    content.style.display = "block";
    button.textContent = "Less";
  } else {
    content.style.display = "none";
    button.textContent = "More";
  }
}
