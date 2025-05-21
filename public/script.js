document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (name && email && password) {
        alert('Cadastro realizado com sucesso!');
        // Aqui você pode adicionar lógica para enviar os dados para o backend.
    } else {
        alert('Por favor, preencha todos os campos.');
    }
});
