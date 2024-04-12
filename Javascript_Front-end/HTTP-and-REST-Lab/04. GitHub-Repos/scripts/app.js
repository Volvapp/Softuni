function loadRepos() {
  const BASE_URL = "https://api.github.com/users/testnakov/repos";
  const result = document.getElementById("res");
  fetch(BASE_URL, { method: "GET" })
  .then((res) => res.json())
  .then((data) => {
      result.textContent = data;
    })
    .catch((err) => {
      console.log(err);
    });
}
