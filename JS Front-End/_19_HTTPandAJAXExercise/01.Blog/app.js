function attachEvents() {
    const URL_POSTS = 'http://localhost:3030/jsonstore/blog/posts';
    const URL_COMMENTS = 'http://localhost:3030/jsonstore/blog/comments';

    const postsButton = document.querySelector('#btnLoadPosts');
    const commentsButton = document.querySelector('#btnViewPost');
    const selectOptions = document.querySelector('#posts');

    let allPosts = {};

    postsButton.addEventListener('click', getPosts);

    function getPosts() {
        fetch(URL_POSTS)
        .then(res => res.json())
        .then(posts => {
            allPosts = posts;
            console.log(allPosts);
            for (const key in posts) {
                const option = document.createElement('option');
                option.value = key;
                option.textContent = posts[key].title;
                selectOptions.appendChild(option);
            }
        })
    }

    commentsButton.addEventListener('click', getComments);

    function getComments() {
        fetch(URL_COMMENTS)
        .then(res => res.json())
        .then(comments => {
            console.log(comments);
            console.log(selectOptions.value);
            let selectedPost;
            for (const key in allPosts) {
             if (key === selectOptions.value) {
                selectedPost = allPosts[key];
                console.log(selectedPost);
             }
            }
            const postTitle = document.querySelector('#post-title');
            postTitle.textContent = selectedPost.title;

            const postBody = document.querySelector('#post-body');
            postBody.textContent = selectedPost.body;

            const postComments = document.querySelector('#post-comments');
            postComments.innerHTML = '';

            for (const key in comments) {
                if (comments[key].postId === selectedPost.id) {
                    const li = document.createElement('li');
                    li.textContent = comments[key].text;
                    postComments.appendChild(li);
                }
            }
        })
    }
}

attachEvents();