function attachEvents() {
  const PHONEBOOK_URL = `http://localhost:3030/jsonstore/phonebook/`;
  const phonebookContainer = document.querySelector('#phonebook');
  const loadButton = document.querySelector('#btnLoad');
  const createButton = document.querySelector('#btnCreate');
  const personInput = document.querySelector('#person');
  const phoneInput = document.querySelector('#phone');

  loadButton.addEventListener('click', loadPhonebook);
  createButton.addEventListener('click', createContactEntry);


  function loadPhonebook() {
      fetch(PHONEBOOK_URL)
          .then((res) => res.json())
          .then((phonebook) => {
              const phonebookData = Object.values(phonebook);
              phonebookContainer.innerHTML = '';

              for (const { person, phone, _id } of phonebookData) {
                  row = document.createElement('li');
                  row.innerHTML = `${person}: ${phone}`;

                  const deleteButton = document.createElement('button');
                  deleteButton.setAttribute('id', _id);
                  deleteButton.textContent = 'Delete';
                  deleteButton.addEventListener('click', deleteContactEntry);

                  row.appendChild(deleteButton);
                  phonebookContainer.appendChild(row);
              };
          }
      )
  }

  function deleteContactEntry() {
      const key = this.id;

      fetch(`${PHONEBOOK_URL}${key}`, {
          method: 'DELETE'
      })
          .then((res) => res.json())
          .then(() => loadPhonebook())
          .catch((err) => {
              console.error(err);
          });
  }

  function createContactEntry() {
      person = personInput.value;
      phone = phoneInput.value;

      fetch(PHONEBOOK_URL, {
          method: 'POST',
          body: JSON.stringify({ person, phone })
      })
          .then((res) => res.json())
          .then(() => {
              loadPhonebook();
              personInput.value = '';
              phoneInput.value = '';
          })
          .catch((err) => {
              console.error(err);
          });

      
  }


}

attachEvents();