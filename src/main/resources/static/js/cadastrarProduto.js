document.getElementById('cadastrarProduto').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o comportamento padrão de recarregar a página

    // Opção 1: Coletar os dados de forma mais simples com FormData
    const formData = new FormData(event.target);
    const dados = {};
    formData.forEach((value, key) => {
      dados[key] = value;
    });

    // Opção 2: Acessar cada campo individualmente
        const produto = {
        nome: document.getElementById('nome').value,
        descricao: document.getElementById('descricao').value,
        preco: parseFloat(document.getElementById('preco').value),   // transforma em número decimal
        estoque: parseInt(document.getElementById('estoque').value), // transforma em número inteiro
        categoria: document.getElementById('categoria').value 
      };

    
    enviarParaBackend(produto); // Chama a função que envia os dados
  });


  function enviarParaBackend(produto) {
    fetch('http://localhost:8080/produtos', { // Substitua pela URL do seu endpoint Java
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(produto) // Converte o objeto JavaScript para JSON
      })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro na requisição: " + response.status);
        }
        return response.json();
    })
    .then(data => {
      console.log('Sucesso:', data);
      alert('Produto cadastrado com sucesso!');
        window.location.href = "cadastrarProduto.html"; // redireciona para a listagem
    })
    .catch((error) => {
      console.error('Erro:', error);
      alert('Erro ao enviar os dados.');
    });
  }