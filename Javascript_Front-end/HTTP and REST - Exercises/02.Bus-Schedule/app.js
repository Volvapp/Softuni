function solve() {
  const info = document.querySelector("#info .info");
  const arriveButton = document.getElementById("arrive");
  const departButton = document.getElementById("depart");
  const BASE_URL = "http://localhost:3030/jsonstore/bus/schedule/";
  let _id = "depot";
  let stopName = "";

  function depart() {
    
    fetch(BASE_URL + _id)
    .then((res) => res.json())
    .then((json) => {
      stopName = json.name;
      _id = json.next;

      info.textContent = "Next stop " + stopName;
      departButton.disabled = true;
      arriveButton.disabled = false;
    })
    .catch(() => {
      info.textContent = "Error";
      departButton.disabled = false;
      arriveButton.disabled = false;
    });
    
  }

  async function arrive() {
    info.textContent = "Arriving at " + stopName;
    departButton.disabled = false;
    arriveButton.disabled = true;
  }

  return {
    depart,
    arrive,
  };
}

let result = solve();
