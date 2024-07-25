function loadRepos() {
	const input = document.querySelector('#username');
	const ul = document.querySelector('#repos');

	ul.innerHTML = '';

	fetch(`https://api.github.com/users/${input.value}/repos`)
	.then(res => res.json())
	.then(data => {
		Array.from(data).forEach(data => {
			const newLi = document.createElement('li');
			const newA = document.createElement('a');
			newA.setAttribute('href', data.html_url);
			newA.textContent = data.full_name;

			newLi.appendChild(newA);
			ul.appendChild(newLi);
		})
	})
	.catch(error => {
		const errorLi = document.createElement('li');
		li.textContent = error;

		ul.appendChild(errorLi);
	})
}