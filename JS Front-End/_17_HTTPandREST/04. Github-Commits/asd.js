function loadCommits() {
    const username = document.querySelector('#username').value;
    const repo = document.querySelector('#repo').value;
    const list = document.querySelector('#commits');

    list.innerHTML = '';

    fetch(`https://api.github.com/repos/${username}/${repo}/commits`)
        .then((res) => res.json())
        .then((commits) => {
            commits.forEach(({ commit }) => {
                const item = document.createElement('li');
                item.textContent = `${commit.author.name}: ${commit.message}`;

                list.appendChild(item);
            });
        })
        .catch((error) => {
            console.log(error);
            const item = document.createElement('li');
            item.textContent = `Error: ${error.status}`;

            list.appendChild(item);
        });
}