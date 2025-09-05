// Simulação de produtos (você pode puxar do backend depois)
const produtos = [
    {
      nome: "Pão Francês",
      preco: 1.50,
      desconto: "10% OFF",
      frete: "Frete grátis",
      imagem: "https://via.placeholder.com/220x180?text=Pão"
    },
    {
      nome: "Bolo de Chocolate",
      preco: 25.90,
      desconto: "15% OFF",
      frete: "Frete grátis",
      imagem: "https://via.placeholder.com/220x180?text=Bolo"
    },
    {
      nome: "Café Torrado",
      preco: 12.99,
      desconto: "5% OFF",
      frete: "Opção de frete grátis",
      imagem: "https://via.placeholder.com/220x180?text=Café"
    },
    {
      nome: "Croissant",
      preco: 4.50,
      desconto: "20% OFF",
      frete: "Frete grátis",
      imagem: "https://via.placeholder.com/220x180?text=Croissant"
    }
  ];
  
  // Carregar produtos no HTML
  const container = document.getElementById("produtosContainer");
  
  produtos.forEach(produto => {
    const card = document.createElement("div");
    card.classList.add("card-produto");
    card.innerHTML = `
      <img src="${produto.imagem}" alt="${produto.nome}">
      <div class="desconto">${produto.desconto}</div>
      <h3>${produto.nome}</h3>
      <div class="preco">R$ ${produto.preco.toFixed(2)}</div>
      <div class="frete">${produto.frete}</div>
      <button>Comprar</button>
    `;
    container.appendChild(card);
  });
  