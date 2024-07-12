function extract(content) {
    const text = document.getElementById(content).textContent;

    const matches = text.matchAll(/\(([a-zA-Z\s+]+)\)/g);

    let result = '';

    for (const match of matches) {
        result += match[1] + '; ';
    }
    return result;
}