const form = document.querySelector('#register-form');

const registerUser = async () => {
    const formData = new FormData(form);
    const data = {
        "name": formData.get('name'),
        "lastname": formData.get('lastname'),
        "email": formData.get('email'),
        "password": formData.get('password'),
        "phone": formData.get('phone')
    };
    if(data.password !== formData.get('repeatPassword')){
        alert('Las contraseñas no coinciden');
        return;
    }
    const response = await fetch("http://localhost:8080/users", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const json = await response.json();
    alert(json.message);
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    registerUser();
});