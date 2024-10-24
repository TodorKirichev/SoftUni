function attachEvents() {
    const URL = 'http://localhost:3030/jsonstore/phonebook';
    const loadButton = document.querySelector('#btnLoad');
    const phoneBookUl = document.querySelector('#phonebook');
    const createButton = document.querySelector('#btnCreate');
    let contacts = [];

    loadButton.addEventListener('click',loadPhoneBook);

    function loadPhoneBook() {
        phoneBookUl.innerHTML = '';
        fetch(URL)
        .then(res => res.json())
        .then (persons => {
            Object.values(persons).forEach(personObj => {
                const {person, phone} = personObj;
                contacts.push(personObj);
                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Delete';
                deleteButton.classList.add('btnDelete');

                deleteButton.addEventListener('click', deleteContact);
                
                const li = document.createElement('li');
                li.textContent = `${person}: ${phone}`;
                li.appendChild(deleteButton);
                
                phoneBookUl.appendChild(li);

                function deleteContact() {
                    const key = personObj._id;
                    fetch(`http://localhost:3030/jsonstore/phonebook/${key}`, {
                        method: 'DELETE'
                    })
                    li.remove();
                }
            })
        })
    }

    createButton.addEventListener('click',createContact);
    
    function createContact() {
        const [person, phone] = document.querySelectorAll('input');
        
        const contact = {
            person: person.value,
            phone: phone.value
        }
        
        console.log(contact);
        
        fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        })
        .then(res => res.json())
        .then(a => {
            person.value = '';
            phone.value = '';
            loadPhoneBook();
        })
        
    }
    
}

attachEvents();