// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
});

const tbody = document.querySelector('#dataTable tbody');

const loadUsers = async () => {
    const response = await fetch("http://localhost:8080/users");
    const data = await response.json();
    const fragment = document.createDocumentFragment();
    data.forEach(user => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
                <td>${user.name}</td>
                <td>${user.lastname}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>
                    <button onclick="deleteUser(${user.id})" class="btn btn-danger btn-circle btn-sm">
                        <i class="fas fa-trash"></i>
                    </button>
                </td>
            `;
        fragment.appendChild(tr);
    });
    tbody.appendChild(fragment);
};

const deleteUser = async (id) => {
    console.log(id);
    const response = await fetch(`http://localhost:8080/users/${id}`, {
        method: 'DELETE'
    });
    const data = await response.json();
    console.log(data);
};


loadUsers();
