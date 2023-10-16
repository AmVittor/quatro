# Quatro
Docker java + mysql + executavel
Conexão projeto Quatro (pi) via docker com mysql, azure e java executavel.

## Instalação

Entrar no mysql
```
sudo docker exec -it ContainerBD bash
mysql -u root -p
```

## Possiveis problemas <br><br>
### Caso o docker exec acuse erro dizendo que não está running basta rodar: <br> <br>
` 
sudo su root
docker start nome_docker
` <br>
_E depois os comandos descritos no entrar mysql acima_ <br> <br>

### Script dando algum problema: <br>
` 
Caso o script tenha dado problema, para edita-lo basta (no terminal) escrever vim /nome_script, apertar a telca i do teclado pra editar, após editado
a tecla esc e escrever :x 
`  <br><br>

### Script não salvando ou nao permitindo o :X: <br>
` 
Neste caso, aperte ctrl c algumas vezes e o terminal lhe dirá como sair, comumente é o comando :qw, para editar entre no root (sudo su root) e digite
chmod 777 nome_script, o 777 é para garantir que consiga fazer oq quiser com o script. Lembre-se de mudar para 400 depois.
` <br><br>
### Script não exectavel ou nao está "verdinho" quando dou ls: <br>
` 
Nesso caso, basta criar um script novo, para criar digite 
touch nome_qualquer e depois os comandos de edição ditados acima e inserir o script digitado abaixo
`<br
<br><br><br>
