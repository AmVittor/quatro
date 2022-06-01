// Aqui está a maioria das funções para validação de sessão, logoff e a lógica de seleção de plano

let login_cliente;
let nome_cliente;

let login_usuario;
let nome_usuario;

function redirecionar_login() {
    window.location.href = 'login.html';
}

function verificar_autenticacao() {
    login_usuario = sessionStorage.usuario_email;    
    nome_usuario = sessionStorage.usuario_nome;

    login_cliente = sessionStorage.cliente_cnpj;    
    nome_cliente = sessionStorage.cliente_nome;
    
    if (login_usuario == undefined && login_cliente == undefined)  {
        redirecionar_login();
       
    } else {
        validar_sessao();
    }
    
}

function validarClienteOuFunc(){
  login_cliente = sessionStorage.cliente_cnpj;

  if(login_cliente == undefined){
    window.alert("Você não tem permissão para acessar essa aba. Faça login como Cliente para ter acesso!")
  }else{
    window.location.href = "emprises.html";
  }
}

//function logoff() {
//    finalizar_sessao();
//    sessionStorage.clear();
//    redirecionar_login();
//}

function validar_sessao() {
    if(login_usuario != undefined && login_cliente){
    fetch(`/usuarios/session/${login_usuario}`, {cache:'no-store'})
    .then(resposta => {
        if (resposta.ok) {
            resposta.text().then(texto => {
                console.log('Sessão :) ', texto);    
            });
        } else {
            console.error('Sessão :.( ');
            finalizar_sessao();
        } 
    });
    }
    
    if(login_cliente != undefined && login_usuario){
        fetch(`/clientes/session/${login_cliente}`, {cache:'no-store'})
        .then(resposta => {
            if (resposta.ok) {
                resposta.text().then(texto => {
                    console.log('Sessão :) ', texto);    
                });
            } else {
                console.error('Sessão :.( ');
                finalizar_sessao();
            } 
        });
        }  
}

function finalizar_sessao() {
    if(login_usuario != undefined){
        fetch(`/usuarios/sair/${login_usuario}`, {cache:'no-store'});
        sessionStorage.clear();
        redirecionar_login(); 
    }else{
        fetch(`/clientes/sair/${login_cliente}`, {cache:'no-store'});
        sessionStorage.clear();
        redirecionar_login(); 
    }
}

// funções dos planos


function redCadastro(){
    window.location.href = "cadastro.html";
}

function botaoPlano(e){
   sessionStorage.plano = e;
}