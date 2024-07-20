function encodeAndDecodeMessages() {
    const sentMsg = document.querySelector('main div:first-of-type textarea');
    let recievedMsg = document.querySelector('main div:last-of-type textarea');

    const encodeBtn = document.querySelector('main div:first-of-type button');
    const decodeBtn = document.querySelector('main div:last-of-type button');

    encodeBtn.addEventListener('click', encode);

    function encode() {
        let encodedMsg = sentMsg.value.split('').map(e => String.fromCharCode(e.charCodeAt(0) + 1)).join('');
        recievedMsg.value = encodedMsg;
        sentMsg.value = '';
    }

    decodeBtn.addEventListener('click', decode);

    function decode() {
        let decodedMsg = recievedMsg.value.split('').map(e => String.fromCharCode(e.charCodeAt(0) - 1)).join('');
        recievedMsg.value = decodedMsg;
    }
}