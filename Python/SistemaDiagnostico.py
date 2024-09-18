import os

contas = []  # Lista para armazenar as contas de usuários
veiculos = []  # Lista para armazenar os veículos (não utilizada diretamente)
usuario_logado = None  # Variável global para armazenar o usuário atualmente logado

# Função para exibir o nome do programa e bem vindo
def exibir_nome_do_programa():
    print('Seja bem-vindo ao Diagnóstico automotivo inteligente da Porto!')

# Função que solicita informações para cadastrar um novo usuário e salva na lista de contas.
def cadastrar_conta():
    exibir_subtitulo('Cadastrar nova conta')
    nome_usuario = input('Digite o nome do seu usuário: ')
    senha_usuario = input(f'Digite a senha do usuário {nome_usuario}: ')
    conta = {'nome': nome_usuario, 'senha': senha_usuario, 'veiculos':[]}
    contas.append(conta)  # Adiciona a nova conta à lista de contas
    print(f'O usuário {nome_usuario} foi cadastrado com sucesso!\n')
    voltar_ao_menu_principal()

# Função que faz o login se as informações estiverem corretas
def login():
    global usuario_logado
    exibir_subtitulo('Login')
    nome_usuario = input('Digite o nome do seu usuário: ')
    senha_usuario = input('Digite a senha do usuário: ')
    
    conta = encontrar_conta_por_nome(nome_usuario)
    if conta and conta['senha'] == senha_usuario:
        usuario_logado = conta  # Define o usuário logado globalmente
        print(f'Login bem-sucedido! Bem-vindo, {nome_usuario}.\n')
    else:
        print('Nome de usuário ou senha incorretos.\n')
    
    voltar_ao_menu_principal()

# Função de Logout
def logout():
    global usuario_logado
    if usuario_logado:
        print(f'Usuário {usuario_logado["nome"]} deslogado com sucesso!\n')
        usuario_logado = None  # Limpa a variável global do usuário logado
    else:
        print('Nenhum usuário está logado.\n')
    
    voltar_ao_menu_principal()


# Função que solicita informações para cadastrar novo veículo
def cadastrar_veiculo():
    exibir_subtitulo('Cadastro de novo veículo')
    if usuario_logado:
        try:
            veiculo = input('Digite o nome e modelo do veículo que deseja cadastrar: ')
            ano = int(input(f'Digite o ano do veículo {veiculo}: '))
            if ano <= 2000:
                raise ValueError("O ano do veículo deve ser maior que 2000.")
            dados_do_veiculo = {'Veículo': veiculo, 'Ano': ano}
            usuario_logado['veiculos'].append(dados_do_veiculo)  # Adiciona o veículo na lista de veículos do usuário
            print(f'O veículo {veiculo} foi cadastrado com sucesso para o usuário {usuario_logado["nome"]}!\n')
        except ValueError as e:
            print(f'Erro: {e}')  # Exibe mensagem de erro se o ano for inválido
    else:
        print('Você precisa estar logado para cadastrar um veículo.\n')
    
    voltar_ao_menu_principal()

# Fução que exibe todos os veículos cadastrados no nome do usuário 
# Também mostra diagnósticos registrados
def exibir_veiculos_usuario():
    if usuario_logado:
        if usuario_logado['veiculos']:
            print(f"Veículos cadastrados no nome do usuário {usuario_logado['nome']}:")
            for veiculo in usuario_logado['veiculos']:
                diagnostico = veiculo.get('Diagnóstico', 'Nenhum diagnóstico registrado.')
                print(f"Veículo: {veiculo['Veículo']}, Ano: {veiculo['Ano']}")
                print(f"Diagnóstico: {diagnostico}")
        else:
            print(f"Não há veículos cadastrados para o usuário {usuario_logado['nome']}.")
    else:
        print('Você precisa estar logado para exibir os veículos.\n')
    
    voltar_ao_menu_principal()

# Função que permite alterar ou remover as informações de um veículo
def alterar_ou_remover_veiculo():
    exibir_subtitulo('Alterar ou remover veículo')
    if usuario_logado:
        if usuario_logado['veiculos']:
            print(f"Veículos cadastrados no nome do usuário {usuario_logado['nome']}:")
            for i, veiculo in enumerate(usuario_logado['veiculos']):
                print(f"{i + 1}. Veículo: {veiculo['Veículo']}, Ano: {veiculo['Ano']}")
            
            opcao = input("Deseja alterar ou remover um veículo? (a/r): ").lower()   #Utiliza as variaveis A(alterar) ou R(remover)
            try:
                if opcao == 'a':
                    indice = int(input("Digite o número do veículo que deseja alterar: ")) - 1 # menos um porque a lista começa no 0
                    if 0 <= indice < len(usuario_logado['veiculos']):
                        novo_nome = input("Digite o novo nome e modelo do veículo: ")
                        novo_ano = int(input(f"Digite o novo ano do veículo {novo_nome}: "))
                        if novo_ano <= 2000:
                            raise ValueError("O ano do veículo deve ser maior que 2000.") # Regra de negócio (Veículos não devem ser mais velhos que o ano 2000)
                        usuario_logado['veiculos'][indice] = {'Veículo': novo_nome, 'Ano': novo_ano}
                        print(f"Veículo atualizado com sucesso para {novo_nome} ({novo_ano})!")
                    else:
                        print("Veículo inválido.")
                elif opcao == 'r':
                    indice = int(input("Digite o número do veículo que deseja remover: ")) - 1 # menos um porque a lista começa no 0
                    if 0 <= indice < len(usuario_logado['veiculos']):
                        veiculo_removido = usuario_logado['veiculos'].pop(indice)
                        print(f"Veículo {veiculo_removido['Veículo']} removido com sucesso!")
                    else:
                        print("Veículo inválido.")
                else:
                    print("Opção inválida.")
            except ValueError as e:
                print(f'Erro: {e}')  # Exibe mensagem de erro para entradas inválidas
        else:
            print(f"Não há veículos cadastrados para o usuário {usuario_logado['nome']}.")
    else:
        print('Você precisa estar logado para alterar ou remover um veículo.\n')
    
    voltar_ao_menu_principal()

# Função que solicita descrição do diagnóstico e vincula ao veículo
def diagnosticar_veiculo():
    
    exibir_subtitulo('Diagnóstico de Veículo')
    if usuario_logado:
        if usuario_logado['veiculos']:
            print(f"Veículos cadastrados no nome do usuário {usuario_logado['nome']}:")
            for i, veiculo in enumerate(usuario_logado['veiculos']): # enumerate retorna o objeto gerando tupla com o índice e o valor
                print(f"{i + 1}. Veículo: {veiculo['Veículo']}, Ano: {veiculo['Ano']}")
            
            try:
                indice = int(input("Digite o número do veículo que deseja diagnosticar: ")) - 1
                if 0 <= indice < len(usuario_logado['veiculos']):
                    descricao_diagnostico = input("Digite a descrição do diagnóstico para o veículo: ")
                    usuario_logado['veiculos'][indice]['Diagnóstico'] = descricao_diagnostico
                    print(f"Diagnóstico atribuído com sucesso ao veículo {usuario_logado['veiculos'][indice]['Veículo']}!")
                else:
                    print("Veículo inválido.")
            except ValueError:
                print("Erro: Entrada inválida.")  # exceção se a entrada não for um número
        else:
            print(f"Não há veículos cadastrados para o usuário {usuario_logado['nome']}.")
    else:
        print('Você precisa estar logado para realizar um diagnóstico.\n')

    voltar_ao_menu_principal()

# Função para exibir o menu
def menu():
    """Exibe o menu principal com as opções disponíveis para o usuário."""
    print("1. Cadastrar Usuário")
    print("2. Login")
    print("3. Logout")
    print("4. Cadastrar Veículo")
    print("5. Exibir Veículos")
    print("6. Alterar ou remover veículos")
    print("7. Iniciar diagnóstico")
    print("8. Sair")


# Função para finalizar o app
def finalizar_app():
    """Finaliza o aplicativo e exibe uma mensagem de agradecimento."""
    exibir_subtitulo('Finalizar app')
    print('Obrigado por utilizar o sistema!')
    exit()

# Função para escolher opção (1 - 8)
def escolher_opcao():
    """Lê a opção escolhida pelo usuário e chama a função correspondente."""
    try: 
        opcao_escolhida = int(input("Escolha uma opção: "))
        if opcao_escolhida == 1:
            print('Cadastrar Usuário')
            cadastrar_conta()
        elif opcao_escolhida == 2:
            print('Login')
            login()
        elif opcao_escolhida == 3:
            print('Logout')
            logout()
        elif opcao_escolhida == 4:
            print('Cadastrar Veículo')
            cadastrar_veiculo()
        elif opcao_escolhida == 5:
            print('Exibir Veículos')
            exibir_veiculos_usuario()
        elif opcao_escolhida == 6:
            print('Alterar ou remover veículos')
            alterar_ou_remover_veiculo()
        elif opcao_escolhida == 7: 
            print('Iniciar Diagnóstico')
            diagnosticar_veiculo()
        elif opcao_escolhida == 8:
            finalizar_app()
        else:
            opcao_invalida()
    except ValueError: 
        opcao_invalida()  # Erro de conversão de entrada

# Função para sempre que uma opção invalida for digitada
def opcao_invalida():
    """Exibe uma mensagem de erro quando a opção escolhida é inválida."""
    print('Opção inválida\n')
    voltar_ao_menu_principal()

# Exibe o subtitulo
def exibir_subtitulo(texto):
    """Limpa a tela e exibe um subtítulo formatado."""
    os.system('cls')  # Limpa a tela 
    linha = '=' * len(texto) 
    print(linha)
    print(texto)
    print(linha)

# Pausa o programa até o usuário digitar uma tecla e voltar para o menu principal
def voltar_ao_menu_principal():
    input('\nDigite uma tecla para voltar ao menu: ')
    main()


# Função principal que inicia o programa
def main():
    os.system('cls')  # Limpa a tela (no Windows)
    exibir_nome_do_programa()
    menu()
    escolher_opcao()
    
# Função utilizada para verificar o usuário
def encontrar_conta_por_nome(nome):
    for conta in contas:
        if conta['nome'] == nome:
            return conta
    return None

# Inicia o programa
if __name__ == '__main__':
    main()  