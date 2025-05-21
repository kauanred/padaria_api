const form = document.getElementById("loginForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async function (e) {
  e.preventDefault();

  const credentials = {
    username: document.getElementById("username").value,
    password: document.getElementById("password").value
  };

  try {
    const response = await fetch("/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(credentials)
    });

    if (!response.ok) {
      throw new Error("Login inválido");
    }

    const data = await response.json();
    localStorage.setItem("token", data.token);
    mensagem.style.color = "green";
    mensagem.textContent = "Login realizado com sucesso!";

    // Redireciona para outra página, ex: dashboard.html
    // window.location.href = "/dashboard.html";
  } catch (error) {
    mensagem.style.color = "red";
    mensagem.textContent = "Usuário ou senha incorretos.";
  }
});
