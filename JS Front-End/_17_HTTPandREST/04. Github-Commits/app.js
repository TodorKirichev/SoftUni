async function loadCommits() {
    const username = document.querySelector('#username').value;
    const repo = document.querySelector('#repo').value;
    const ul = document.querySelector('#commits');

    ul.innerHTML = '';

    const allCommits = await fetch(`https://api.github.com/repos/${username}/${repo}/commits`);
    try {
        const data = await allCommits.json();

        data.forEach(data => {
            const li = document.createElement('li');
            li.textContent = `${data.commit.author.name}: ${data.commit.message}`;
            
            ul.appendChild(li);
        });
    } catch (error) {
        console.log(error);
            const errorLi = document.createElement('li');
            errorLi.textContent = `Error: ${allCommits.status} (Not Found)`;
            
            ul.appendChild(errorLi);
    }

    // fetch(`https://api.github.com/repos/${username}/${repo}/commits`)
    //     .then(res => res.json())
    //     .then(data => {
    //         data.forEach(data => {
    //             const li = document.createElement('li');
    //             li.textContent = `${data.commit.author.name}: ${data.commit.message}`;
                
    //             ul.appendChild(li);
    //         });
    //     })
    //     .catch((error) => {
    //         console.log(error);
    //         const errorLi = document.createElement('li');
    //         errorLi.textContent = `Error: ${error.status} (Not Found)`;
            
    //         ul.appendChild(errorLi);
    //     });
}