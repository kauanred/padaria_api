document.addEventListener('DOMContentLoaded', () => {
const formulario = document.querySelector('form');

const Inome = document.querySelector('.nome');
const Iemail = document.querySelector('.email');
const Ipassword = document.querySelector('.password');

function cadastrar(){
        fetch("http://localhost:8080/cadastar",{
             headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
    },
             method: 'POST',
         body: JSON.stringify({
        nome: Inome.value,
        email: Iemail.value,
        password: Ipassword.value
    })   
})
.then(function (res){ conlose .log(res) })
.catch(function (res) { console.log(res) });     
};

function limpar(){
    Inome.value = '';
    Iemail.value = '';
    Ipassword.value = '';
};




formulario.addEventListener('submit', (event) => {
    event.preventDefault();

    cadastrar();
    });

});
