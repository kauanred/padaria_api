// Evento de submit do formulário
document.getElementById('cadastrarProduto').addEventListener('submit', function(event) {
  event.preventDefault();

  const produto = {
    nome: document.getElementById('nome').value,
    descricao: document.getElementById('descricao').value,
    preco: parseFloat(document.getElementById('preco').value),
    estoque: parseInt(document.getElementById('estoque').value),
    categoria: document.getElementById('categoria').value
  };

  enviarParaBackend(produto);
});

// Função para enviar o produto para o backend
function enviarParaBackend(produto) {
  fetch('http://localhost:8080/produtos', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(produto)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error("Erro ao cadastrar produto");
    }
    return response.json();
  })
  .then(data => {
    console.log('Sucesso:', data);
    document.getElementById('cadastrarProduto').reset();
    abrirModalConfirmacao();
  })
  .catch((error) => {
    console.error('Erro:', error);
    alert("❌ Erro ao criar produto!");
  });
}

// Função para abrir a modal
function abrirModalConfirmacao() {
  const modal = document.getElementById("modalConfirmacao");
  modal.style.display = "flex"; // 🔹 só aparece aqui
}

// Adiciona evento no botão OK para fechar a modal
document.addEventListener("DOMContentLoaded", () => {
  const btnOk = document.getElementById("btnOk");
  const modal = document.getElementById("modalConfirmacao");

  btnOk.addEventListener("click", () => {
    modal.style.display = "none";
    // Se quiser redirecionar para listagem:
    // window.location.href = "listarProdutos.html";
  });
});
