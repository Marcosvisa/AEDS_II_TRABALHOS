import matplotlib.pyplot as plt
import numpy as np

# Dados
tamanhos = [100, 1000, 10000, 100000]
dados = {
    "Bolha": {
        "tempo": [0.7491, 14.1638, 345.1664, 20446.7482],
        "comparacoes": [9801, 998001, 99980001, 1409865409],
        "movimentacoes": [2504, 246695, 24955027, -1826516008],
    },
    "Selecao": {
        "tempo": [0.1996, 8.7867, 110.1362, 3514.4966],
        "comparacoes": [4950, 499500, 49995000, 704982704],
        "movimentacoes": [94, 982, 9890, 98992],
    },
    "Insercao": {
        "tempo": [0.2474, 12.1143, 180.9917, 5849.1432],
        "comparacoes": [2623, 250661, 24643817, -1824641389],
        "movimentacoes": [2623, 250661, 24643817, -1824641389],
    },
    "Quick Sort": {
        "tempo": [0.1084, 2.3949, 54.1431, 299.3122],
        "comparacoes": [586, 12602, 583888, 50769980],
        "movimentacoes": [215, 4594, 44434, 386025],
    }
}

# Preparação para o gráfico
fig, axs = plt.subplots(2, 2, figsize=(14, 10))  # Cria uma grade de 2x2 para os subgráficos
axs = axs.flatten()  # Facilita o acesso aos subgráficos

# Definir os títulos para cada gráfico
titulos = [
    "Tamanho do Vetor: 100",
    "Tamanho do Vetor: 1000",
    "Tamanho do Vetor: 10000",
    "Tamanho do Vetor: 100000"
]

# Para cada subgráfico, plotar os dados correspondentes
for i, tamanho in enumerate(tamanhos):
    ax = axs[i]
    posicoes = np.arange(len(dados))  # Número de algoritmos

    # Adicionar barras para tempo, comparações e movimentações
    largura_barra = 0.2
    offset = np.array([-largura_barra, 0, largura_barra])  # Deslocamento para tempo, comparações e movimentações
    
    for j, (algoritmo, metadados) in enumerate(dados.items()):
        ax.bar(posicoes + offset[0] + j * largura_barra, metadados["tempo"][i], largura_barra, label=f"{algoritmo} - Tempo (ms)")
        ax.bar(posicoes + offset[1] + j * largura_barra, metadados["comparacoes"][i], largura_barra, label=f"{algoritmo} - Comparações")
        ax.bar(posicoes + offset[2] + j * largura_barra, metadados["movimentacoes"][i], largura_barra, label=f"{algoritmo} - Movimentações")

    ax.set_xticks(posicoes + largura_barra)
    ax.set_xticklabels([algoritmo for algoritmo in dados.keys()])
    ax.set_ylabel('Valores')
    ax.set_title(titulos[i])
    ax.legend()
    ax.grid(True)

# Ajustes finais
plt.tight_layout()
plt.show()
