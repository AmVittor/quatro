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
`  <br><br><br>

### Script não salvando ou nao permitindo o :X: <br>
` 
Neste caso, aperte ctrl c algumas vezes e o terminal lhe dirá como sair, comumente é o comando :qw, para editar entre no root (sudo su root) e digite
chmod 777 nome_script, o 777 é para garantir que consiga fazer oq quiser com o script. Lembre-se de mudar para 400 depois.
` <br><br><br>
### Script não exectavel ou nao está "verdinho" quando dou ls: <br>
` 
Nesso caso, basta criar um script novo, para criar digite 
touch nome_qualquer e depois os comandos de edição ditados acima e inserir o script digitado abaixo
`<br><br>
Lembre-se, atalhos de ctrl+c ou v não funcionam, use insert ou o botão direito copiar/colar
<br><br><br>
## Script

```#!/bin/bash

echo \"Iniciando atualização dos pacotes...\"
sudo apt update && sudo apt upgrade -y


docker --version
if [ $? -eq 0 ]
then
echo \"Docker já instalado!\"
else
echo \"Docker não instalado, gostaria de instalar? [s/n~]?\"
read inst
if [ \"$inst\" == \"s\" ]
then
echo \"Iniciando instalação do docker...\"
sudo apt install docker.io -y
echo \"Verificando imagem MySql\"
sudo docker images | grep mysql
if [ $? -eq 0 ]
then
echo \"MySql instalado\"
else
echo \"MySql não instalado, instalando...\"
sudo docker pull mysql:5.7
echo \"Iniciando docker.\"
sleep 5
sudo docker run -d -p 3306:3306 --name ContainerBD -e "MYSQL_DATABASE=4four" -e "MYSQL_ROOT_PASSWORD=urubu100" mysql:5.7
fi
else
echo \"Você escolheu não instalar o docker\"
fi
fi

cat > Dockerfile <<EOF
FROM openjdk:11
WORKDIR /Java/
COPY executavel-quatro.jar /Java/
CMD ["java","-jar","executavel-quatro-jar"]
EOF
sudo docker build . -t executavel-quatro-jar

fi

```
