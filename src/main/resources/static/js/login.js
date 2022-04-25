const form = document.querySelector('#login-form');

const login = async () => {
    const formData = new FormData(form);
    const data = {
        email: formData.get('email'),
        password: formData.get('password')
    };
    const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const json = await response.json();
    if (json.login){
        window.location.href = 'http://localhost:8080/';
    } else {
        alert('Login failed');
    }
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    login();
});