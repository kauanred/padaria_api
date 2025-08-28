document.addEventListener("DOMContentLoaded", carregarProdutos);

function carregarProdutos() {
  fetch("http://localhost:8080/produtos") // GET - buscar produtos do backend
    .then(response => response.json())
    .then(produtos => {
      const tbody = document.getElementById("listaProdutos");
      tbody.innerHTML = "";

      produtos.forEach(produto => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
          <td>${produto.nome}</td>
          <td>${produto.descricao}</td>
          <td>R$ ${parseFloat(produto.preco).toFixed(2)}</td>
          <td>${produto.estoque}</td>
          <td>${produto.categoria}</td>
          <td>
            <button class="btn-acao btn-editar" onclick="editarProduto(${produto.id})">Editar</button>
            <button class="btn-acao btn-deletar" onclick="deletarProduto(${produto.id})">Excluir</button>
          </td>
        `;

        tbody.appendChild(tr);
      });
    })
    .catch(error => console.error("Erro ao carregar produtos:", error));
}

function deletarProduto(id) {
  if (confirm("Tem certeza que deseja excluir este produto?")) {
    fetch(`http://localhost:8080/produtos/${id}`, {
      method: "DELETE"
    })
      .then(response => {
        if (response.ok) {
          alert("Produto excluído com sucesso!");
          carregarProdutos(); // Atualiza a lista
        } else {
          alert("Erro ao excluir produto.");
        }
      })
      .catch(error => console.error("Erro:", error));
  }
}

function editarProduto(id) {
  // Exemplo simples: redireciona para página de edição
  window.location.href = `editarProduto.html?id=${id}`;
}
