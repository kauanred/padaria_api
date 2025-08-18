document.addEventListener('DOMContentLoaded', () => {
const formulario = document.querySelector('form');
const botao = document.querySelector('button');
const inome = document.querySelector('.nome');
const iemail = document.querySelector('.email');
const isenha = document.querySelector('.senha');

function cadastrar(){
        fetch("http://localhost:8080/usuarios",{

             headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify({
        nome: inome.value,
        email: iemail.value,
        senha: isenha.value
    })   
})
.then(function (res){ conlose .log(res) })
.catch(function (res) { console.log(res) });     
};

function limpar(){
    inome.value = '';
    iemail.value = '';
    isenha.value = '';
};




formulario.addEventListener('submit', (event) => {
    event.preventDefault();

    cadastrar();
    limpar();
    });

});
