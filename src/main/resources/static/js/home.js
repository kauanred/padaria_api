// Simulação de produtos (você pode puxar do backend depois)
const produtos = [
    {
      nome: "Pão Francês",
      preco: 1.50,
      desconto: "10% OFF",
      frete: "Frete grátis",
      imagem: "assets/pao-frances.jpg"
    },
    {
      nome: "Bolo de Chocolate",
      preco: 25.90,
      desconto: "15% OFF",
      frete: "Frete grátis",
      imagem: "assets/bolo-de-choc.jpg"
    },
    {
      nome: "Café Expresso",
      preco: 12.99,
      desconto: "5% OFF",
      frete: "Opção de frete grátis",
      imagem: "assets/espresso-coffee.jpg"
    },
    {
      nome: "Croissant",
      preco: 4.50,
      desconto: "20% OFF",
      frete: "Frete grátis",
      imagem: "assets/croissant.jpg"
    },

    {
      nome: "Coxinha de Frango",
      preco: 7.50,
      desconto: "Combo com refri!",
      frete: "Frete grátis acima de R$30",
      imagem: "assets/coxinha.jpg"
    },

    {
      nome: "Pudim de Leite (Fatia)",
      preco: 9.90,
      desconto: "Receita da vovó",
      frete: "Opção de frete grátis",
      imagem: "assets/pudim.jpg"
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
    
    `;
    container.appendChild(card);
  });
  // linha 45  <button>Comprar</button>