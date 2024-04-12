// app.js

document.addEventListener("DOMContentLoaded", () => {
  const loadButton = document.getElementById("load-vacations");
  const addButton = document.getElementById("add-vacation");
  const editButton = document.getElementById("edit-vacation");
  const listContainer = document.getElementById("list");
  let editingItemId = null;

  loadButton.addEventListener("click", loadVacations);
  addButton.addEventListener("click", addVacation);
  editButton.addEventListener("click", editVacation);

  function loadVacations() {
    fetch("http://localhost:3030/jsonstore/tasks/")
      .then((response) => response.json())
      .then((data) => {
        listContainer.innerHTML = "";
        Object.values(data).forEach((vacation) => {
          appendVacationToDOM(vacation);
        });
      })
      .catch((error) => console.error("Error loading vacations:", error));
  }
  function addVacation(e) {
    e.preventDefault();

    const nameInput = document.getElementById("name");
    const numDaysInput = document.getElementById("num-days");
    const fromDateInput = document.getElementById("from-date");

    const newVacation = {
      name: nameInput.value,
      days: numDaysInput.value,
      date: fromDateInput.value,
    };
   
    fetch("http://localhost:3030/jsonstore/tasks/", {
      method: "POST",
      body: JSON.stringify(newVacation),
    })
      .then((response) => response.json())
      .then(() => {
        
        nameInput.value = "";
        numDaysInput.value = "";
        fromDateInput.value = "";

        
        loadVacations();
      })
      .catch((error) => console.error("Error adding vacation:", error));
  }

  function editVacation(e) {
    e.preventDefault();
    const nameInput = document.getElementById("name");
    const numDaysInput = document.getElementById("num-days");
    const fromDateInput = document.getElementById("from-date");

    const editedVacation = {
      name: nameInput.value,
      days: numDaysInput.value,
      date: fromDateInput.value,
    };

    fetch(`http://localhost:3030/jsonstore/tasks/${editingItemId}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(editedVacation),
    })
      .then((response) => response.json())
      .then(() => {
        nameInput.value = "";
        numDaysInput.value = "";
        fromDateInput.value = "";
        editingItemId = null;
        loadVacations();
      })
      .catch((error) => console.error("Error editing vacation:", error));
  }

  function appendVacationToDOM(vacation) {
    const container = document.createElement("div");
    container.classList.add("container");

    const nameElement = document.createElement("h2");
    nameElement.textContent = vacation.name;

    const dateElement = document.createElement("h3");
    dateElement.textContent = vacation.date;

    const daysElement = document.createElement("h3");
    daysElement.textContent = vacation.days;

    const changeButton = document.createElement("button");
    changeButton.classList.add("change-btn");
    changeButton.textContent = "Change";
    changeButton.addEventListener("click", () => populateEditForm(vacation));

    const doneButton = document.createElement("button");
    doneButton.classList.add("done-btn");
    doneButton.textContent = "Done";
    doneButton.addEventListener("click", () => deleteVacation(vacation._id));

    container.appendChild(nameElement);
    container.appendChild(dateElement);
    container.appendChild(daysElement);
    container.appendChild(changeButton);
    container.appendChild(doneButton);
    listContainer.appendChild(container);
  }

  function populateEditForm(vacation) {
    const nameInput = document.getElementById("name");
    const numDaysInput = document.getElementById("num-days");
    const fromDateInput = document.getElementById("from-date");

    nameInput.value = vacation.name;
    numDaysInput.value = vacation.days;
    fromDateInput.value = vacation.date;

    editButton.removeAttribute("disabled");
    addButton.setAttribute("disabled", true);

    editingItemId = vacation._id;
  }

  function deleteVacation(id) {
    fetch(`http://localhost:3030/jsonstore/tasks/${id}`, {
      method: "DELETE",
    })
      .then(() => loadVacations())
      .catch((error) => console.error("Error deleting vacation:", error));
  }
});
