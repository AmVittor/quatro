# Projeto *Quatro* - Docker Java + MySQL

O Projeto Quatro é um projeto de monitoramento de servidores de e-commerce. Este repositório é responsável por abrigar o front-end do projeto, bem como a documentação e script executável, juntamente com a modelagem do banco de dados. <br>
A API pode ser encontrado no link: https://github.com/AmVittor/api-monitoramento-quatro
## Instalação

1. Acesse o contêiner MySQL:
    ```bash
    sudo docker exec -it ContainerBD bash
    mysql -u root -p
    ```

## Possíveis Problemas

### Erro "docker exec" não está em execução

Se você receber um erro indicando que o comando `docker exec` não está em execução, siga estas etapas:

1. Torne-se superusuário (root):
    ```bash
    sudo su root
    ```

2. Inicie o contêiner com o nome apropriado:
    ```bash
    docker start nome_docker
    ```

### Script com problemas

Se o seu script tiver algum problema, siga estas instruções:

1. Para editá-lo, digite no terminal:
    ```bash
    vim /nome_script
    ```

2. Pressione a tecla `i` para editar o script.

3. Após editar, pressione `Esc` e digite `:x` para salvar e sair.

### Script não está salvando ou não permite `:x`

Se o script não estiver sendo salvo ou não permitir o comando `:x`, siga estas etapas:

1. Pressione `Ctrl+C` algumas vezes para sair do modo de edição.

2. O terminal fornecerá uma instrução para sair; comumente, é o comando `:qw`.

3. Para editar o script, acesse como root (sudo su root) e execute:
    ```bash
    chmod 777 nome_script
    ```

4. Lembre-se de alterar as permissões para 400 quando terminar.

### Script não é executável ou não aparece no comando `ls`

Se o script não for executável ou não estiver visível com `ls`, siga estas etapas:

1. Crie um novo script:
    ```bash
    touch nome_qualquer
    ```

2. Siga as instruções de edição mencionadas acima e insira o script desejado.
