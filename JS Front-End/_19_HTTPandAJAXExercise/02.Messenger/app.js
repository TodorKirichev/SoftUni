function attachEvents() {
    const URL = 'http://localhost:3030/jsonstore/messenger';

    const sendButton = document.querySelector('#submit');
    const refreshButton = document.querySelector('#refresh');
    let messagesTextArea = document.querySelector('#messages');

    const [nameInput , messageInput] = document.querySelectorAll('input');

    sendButton.addEventListener('click', sendMessage);

    function sendMessage() {
        if (nameInput.value !== '' && messageInput.value !== '') {
            const message = {
                author: nameInput.value,
                content: messageInput.value
            }
            fetch(URL, {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify(message) 
            })
        } else {
            alert('Both inputs are obligatory');
        }
        nameInput.value = '';
        messageInput.value = '';
    }

    refreshButton.addEventListener('click', getMessages);

    function getMessages() {
        messagesTextArea.textContent = '';
        fetch(URL)
        .then(res => res.json())
        .then(messages => {
            let currentMessages = [];
            for (const key in messages) {
                currentMessages.push(`${messages[key].author}: ${messages[key].content}`);
            }
            messagesTextArea.textContent = currentMessages.join('\n');
        })
    }
}

attachEvents();