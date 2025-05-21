const form = document.getElementById("formCliente");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async function (e) {
  e.preventDefault();

  const cliente = {
    nome: document.getElementById("nome").value.trim(),
    cpf: document.getElementById("cpf").value.trim(),
    telefone: document.getElementById("telefone").value.trim()
  };

  try {
    const response = await fetch("/api/clientes", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(cliente)
    });

    if (!response.ok) throw new Error("Erro ao cadastrar");

    mensagem.textContent = "Cliente cadastrado com sucesso!";
    mensagem.style.color = "#2e7d32";
    form.reset();
  } catch (error) {
    mensagem.textContent = "Erro ao cadastrar cliente.";
    mensagem.style.color = "#c62828";
  }
});
