function colorize() {
    const colored = document.querySelectorAll('table tr:nth-child(even)');

    for (const e of colored) {
        e.style.backgroundColor = 'teal';
    }
}