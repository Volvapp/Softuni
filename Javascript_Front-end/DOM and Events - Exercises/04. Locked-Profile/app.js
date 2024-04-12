function lockedProfile() {
  const buttons = Array.from(document.querySelectorAll("button"));

  buttons.forEach((button) => {
    button.addEventListener("click", (e) => {
      const lockedRadioButton = e.currentTarget.parentElement.querySelector(
        "input[type = 'radio']"
      );
      if (lockedRadioButton.checked) {
        return;
      }
      const isHidden = e.currentTarget.textContent === "Show more";
      const hiddenInfo = e.currentTarget.parentElement.querySelector("div");

      e.currentTarget.textContent = isHidden ? "Hide it" : "Show more";

      hiddenInfo.style.display = isHidden ? "block" : "none";
    });
  });
}
