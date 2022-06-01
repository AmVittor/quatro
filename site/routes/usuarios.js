var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;

let sessoes = [];
let id_client;

/* Recuperar usuário por login e senha */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var email = req.body.n_login; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.n_senha; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from dbo_user where email='${email}' and user_password='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.email);
			console.log('Session ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('E-mail e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um cliente com o mesmo e-mail e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Pegando id do cliente*/
router.get('/fk/:id_client', function(req, res, next) {

	id_client = req.params.id_client;
	console.log(id_client);
});

router.put('/editar/:id_user', function(req, res){
	let user_email = req.body.n_f_email_a;
	let nome = req.body.n_f_nome_a;
	let senha = req.body.n_f_senha_a;
	let idUsuario = req.params.id_user;
	
	Usuario.update(
		{
		  user_name: `${nome}`,
		  email: `${user_email}`,
		  user_password: `${senha}`,
		},
		{
		  where: { id_user: `${idUsuario}` },
		}
	  ).then(
		function (resultado) {
			console.log("Usuário atualizado com sucesso!")
			res.json(resultado);
		}
	)
	.catch(
		function (erro) {
			console.log(erro);
			console.log("Houve um erro ao realizar o post: ", erro.sqlMessage);
			res.status(500).json(erro.sqlMessage);
		}
	);

});

router.delete('/deletar/:id_user', function(req, res){
	let idUsuario = req.params.id_user;

	Usuario.destroy({
		where: {
			id_user: idUsuario,
		}
	}).then(resultado =>{
		console.log(`Usuário excluído: ${resultado}`);
	}).catch(erro =>{
		console.log(erro);
	
	});
});
// Cadastrar usuário
router.post('/cadastrar', function(req, res, next) {
	
	console.log('Criando um usuário');
	Usuario.create({
        id_user: null,
		user_name: req.body.n_f_nome,
		email: req.body.n_f_email,
		user_password: req.body.n_f_senha,
		fk_client: id_client

	}).then(resultado => {
		console.log(`Novo usuário criado: ${resultado}`);
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});

});


/* Verificação de usuário */
router.get('/session/:email', function(req, res, next) {
	let login = req.params.email;
	console.log(`Verificando se o usuário ${login} tem sessão`);
	
	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/sair/:email', function(req, res, next) {
	let login = req.params.email;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os usuários');
	Usuario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;