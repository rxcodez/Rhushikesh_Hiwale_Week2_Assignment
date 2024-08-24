document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('blog-form');
    const contentDiv = document.getElementById('content');
    const apiUrl = 'http://localhost:8080/blogdataApi';

    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const blogPost = {
            title: document.getElementById('name').value,
            content: document.getElementById('textarea').value
        };
        const method = form.dataset.editing ? 'PUT' : 'POST';
        const url = form.dataset.editing ? `${apiUrl}/updatedata/${form.dataset.postId}` : `${apiUrl}/savedata`;

        fetch(url, {
            method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(blogPost)
        })
            .then(response => response.text())
            .then(message => {
                showMessage(message);
                fetchPosts();
                resetForm();
            })
            .catch(() => showMessage('Error processing request'));
    });

    const fetchPosts = () => {
        fetch(`${apiUrl}/fetchallblogs`)
            .then(response => response.json())
            .then(data => {
                contentDiv.innerHTML = '';
                data.forEach(displayPost);
            })
            .catch(() => showMessage('Error fetching posts'));
    };

    const displayPost = (post) => {
        const postDiv = document.createElement('div');
        postDiv.className = 'blog-post';
        postDiv.dataset.id = post.id;
        postDiv.innerHTML = `
            <h2>${post.title}</h2>
            <p>${post.content}</p>
            <button onclick="editPost(${post.id}, '${post.title}', '${post.content}')">Edit</button>
            <button onclick="deletePost(${post.id})">Delete</button>
        `;
        contentDiv.appendChild(postDiv);
    };

    window.editPost = (id, title, content) => {
        document.getElementById('name').value = title;
        document.getElementById('textarea').value = content;
        form.dataset.editing = true;
        form.dataset.postId = id;
        document.getElementById('create-button').textContent = 'Update';
    };

    window.deletePost = (id) => {
        fetch(`${apiUrl}/deletedata/${id}`, { method: 'DELETE' })
            .then(response => response.text())
            .then(message => {
                showMessage(message);
                fetchPosts();
            })
            .catch(() => showMessage('Error deleting post'));
    };

    const resetForm = () => {
        form.reset();
        delete form.dataset.editing;
        delete form.dataset.postId;
        document.getElementById('create-button').textContent = 'Create';
    };

    const showMessage = (message) => {
        const messageContainer = document.getElementById('message-container');
        messageContainer.textContent = message;
        setTimeout(() => messageContainer.textContent = '', 3000);
    };

    fetchPosts();
});




