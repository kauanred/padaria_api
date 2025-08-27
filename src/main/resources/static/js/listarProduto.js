// Função para listar dados
function listarDados() {
    // URL do controller (backend)
    const url = 'http://localhost:8080/produtos';
  
    // Configuração da requisição AJAX
    const config = {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    };
  
    // Envia a requisição AJAX
    fetch(url, config)
      .then(response => response.json())
      .then(data => {
        // Limpa a tabela
        const tbody = document.getElementById('tbody-produtos');
        tbody.innerHTML = '';
  
        // Lista os dados
        data.forEach(produto => {
          const tr = document.createElement('tr');
          tr.innerHTML = `
            <td>${produto.nome}</td>
            <td>${produto.descricao}</td>
            <td>R$ ${produto.preco}</td>
            <td>
              <button>Editar</button>
              <button>Excluir</button>
            </td>
          `;
          tbody.appendChild(tr);
        });
      })
      .catch(error => console.error(error));
  }
  
  // Chama a função para listar dados
  listarDados();