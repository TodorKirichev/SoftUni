function solve(input) {
    let message = input.shift();

    let command = input.shift();

    while (command !== 'Buy') {

        let [commandName, arg1, arg2] = command.split('?');

        switch(commandName) {
            case 'TakeEven':
                takeEven();
                console.log(message);
                break;
            case 'ChangeAll':
                changeAll(arg1, arg2);
                console.log(message);
                break;
            case 'Reverse':
                if (message.includes(arg1)) {
                    reverseSubstring(arg1);
                    console.log(message);
                } else {
                    console.log('error');
                }
                break;
        }

        command = input.shift();
    }

    console.log(`The cryptocurrency is: ${message}`);

    function takeEven() {
        let newMessage = '';

        for (let i = 0; i < message.length; i++) {
            if (i % 2 === 0) {
                newMessage += message[i];
            }
        }
        message = newMessage;
    }

    function changeAll(substring, replacement) {
        while (message.includes(substring)) {
            let newMessage = message.replace(substring, replacement);
            message = newMessage;
        }
    }

    function reverseSubstring(substring) {
        let newMessage = message.replace(substring, '');
        let reversedSubstring = substring.split('').reverse().join('');
        newMessage += reversedSubstring;
        message = newMessage;
    }
    
}

solve((["PZDfA2PkAsakhnefZ7aZ", 
"TakeEven",
"TakeEven",
"TakeEven",
"ChangeAll?Z?X",
"ChangeAll?A?R",
"Reverse?PRX",
"Buy"])
);