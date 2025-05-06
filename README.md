# 💱 Conversor de Moedas

Este é um projeto Java que permite ao usuário converter valores entre diferentes moedas usando a **ExchangeRate-API** para obter taxas de câmbio atualizadas em tempo real.

## 📌 Funcionalidades

- Conversão entre 10 moedas principais (USD, BRL, EUR, GBP, JPY, AUD, CAD, CHF, CNY, INR)
- Integração com API externa para obter taxas de câmbio reais
- Interface simples via terminal
- Validações de entrada para garantir operação segura

## 🛠️ Tecnologias Utilizadas

- Java 17+
- [ExchangeRate-API](https://www.exchangerate-api.com/)
- Gson (para tratamento de JSON)
- HTTP Client nativo do Java (`java.net.http`)

## 📂 Estrutura do Projeto

conversorDeMoedas/
├── src/
│ ├── Main.java # Classe principal com interação via terminal
│ ├── Conversor.java # Responsável por se comunicar com a API
│ ├── ExchangeAPI.java # Modelo para mapear a resposta da API
│ ├── ValidacaoDeMoedas.java # Classe auxiliar para validar moedas
├── .gitignore
├── README.md # Este arquivo

bash
Copiar
Editar

## ▶️ Como Executar o Projeto

1. Clone este repositório:

```bash
git clone https://github.com/anthenfer/conversorDeMoedas.git
cd conversorDeMoedas
Abra o projeto em sua IDE Java preferida (ex: IntelliJ, Eclipse).

Certifique-se de que o projeto possui suporte à biblioteca Gson (adicione ao classpath, se necessário).

Execute a classe Main.java.

🗝️ API Key
Este projeto utiliza uma chave gratuita da ExchangeRate-API. Para utilizar com sua própria conta:

Cadastre-se no site.

Substitua a constante CHAVE_API na classe Conversor pela sua chave pessoal:

java
Copiar
Editar
private static final String CHAVE_API = "SUA_CHAVE_AQUI";
⚠️ Evite expor sua chave da API publicamente.

💡 Exemplo de Uso
yaml
Copiar
Editar
=== CONVERSOR DE MOEDAS ===
Escolha a opção desejada (1 a 10) para selecionar moeda de origem:
1 - USD (Dólar americano)
2 - BRL (Real brasileiro)
...
Digite o valor a ser convertido: 100

Taxa de câmbio USD -> BRL: 5.1234
Valor convertido: 512.34 BRL
🧪 Melhorias Futuras
Interface gráfica (GUI)

Suporte a mais moedas

Histórico de conversões

Testes unitários automatizados