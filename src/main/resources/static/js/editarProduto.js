document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("editarProdutoForm");
    const params = new URLSearchParams(window.location.search);
    const produtoId = params.get("id");
  
    if (!produtoId) {
      alert("Produto não encontrado!");
      window.location.href = "listarProdutos.html";
      return;
    }
  
    // 🔹 Buscar os dados do produto
    fetch(`http://localhost:8080/produtos/${produtoId}`)
      .then(response => response.json())
      .then(produto => {
        document.getElementById("nome").value = produto.nome;
        document.getElementById("descricao").value = produto.descricao;
        document.getElementById("preco").value = produto.preco;
        document.getElementById("estoque").value = produto.estoque;
        document.getElementById("categoria").value = produto.categoria;
      })
      .catch(error => {
        console.error("Erro ao carregar produto:", error);
        alert("Erro ao carregar os dados do produto.");
      });
  
    // 🔹 Atualizar produto
    form.addEventListener("submit", event => {
      event.preventDefault();
  
      const produtoAtualizado = {
        nome: document.getElementById("nome").value,
        descricao: document.getElementById("descricao").value,
        preco: parseFloat(document.getElementById("preco").value),
        estoque: parseInt(document.getElementById("estoque").value),
        categoria: document.getElementById("categoria").value
      };
  
      fetch(`http://localhost:8080/produtos/${produtoId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(produtoAtualizado)
      })
        .then(response => {
          if (response.ok) {
            alert("Produto atualizado com sucesso!");
            window.location.href = "listarProdutos.html";
          } else {
            alert("Erro ao atualizar produto.");
          }
        })
        .catch(error => {
          console.error("Erro:", error);
          alert("Erro ao atualizar o produto.");
        });
    });
  });