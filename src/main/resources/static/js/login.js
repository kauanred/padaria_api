document.getElementById("formLogin").addEventListener("submit", function(event) {
    event.preventDefault();
  
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
  
    // Usuário de teste
    const usuarioCorreto = "admin@padaria.com";
    const senhaCorreta = "123456";
  
    if (email === usuarioCorreto && senha === senhaCorreta) {
      mostrarToast("✅ Login feito com sucesso!", "sucesso");
  
      setTimeout(() => {
        window.location.href = "home.html";
      }, 2000);
    } else {
      mostrarToast("❌ E-mail ou senha incorretos!", "erro");
    }
  });
  function mostrarToast(mensagem, tipo) {
    const toast = document.getElementById("toast");
    toast.textContent = mensagem;
    toast.className = "toast " + tipo;
    toast.style.display = "block";
  
    // força o repaint para que o transition funcione
    setTimeout(() => {
      toast.style.opacity = "1";
    }, 10);
  
    // inicia o fade-out depois de 2.5s
    setTimeout(() => {
      toast.style.opacity = "0";
    }, 2500);
  
    // remove do fluxo após o fade
    setTimeout(() => {
      toast.style.display = "none";
    }, 3300);
  }