document.getElementById('cadastrarProduto').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o comportamento padrão de recarregar a página

    // Opção 1: Coletar os dados de forma mais simples com FormData
    const formData = new FormData(event.target);
    const dados = {};
    formData.forEach((value, key) => {
      dados[key] = value;
    });

    // Opção 2: Acessar cada campo individualmente
    const nome = document.getElementById('nome').value;
    const descricao = document.getElementById('descricao').value;
    const preco = document.getElementById('preco').value;
    const estoque = document.getElementById('estoque').value;
    const categoria = document.getElementById('categoria').value;
    const produto = { nome: nome, descricao: descricao, preco: preco, categoria: categoria };
    console.log(produto); // Verifica os dados coletados no console

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
    .then(response => response.json()) // Processa a resposta do servidor
    .then(data => {
      console.log('Sucesso:', data);
      alert('Dados enviados com sucesso!');
    })
    .catch((error) => {
      console.error('Erro:', error);
      alert('Erro ao enviar os dados.');
    });
  }