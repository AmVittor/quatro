var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Cliente = require('../models').Cliente;

let sessoes = [];
let id_client;
let plan_client;

/* Recuperar usuário por login e senha */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var login = req.body.n_login // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.n_senha; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from dbo.client where cnpj='${login}' and client_password='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Cliente
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.cnpj);
			console.log('Session ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('CNPJ e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um cliente com o mesmo CNPJ e senha!');
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

// Pegando plano do cliente

router.get('/plan/:plan_client', function(req, res, next) {

	plan_client = req.params.plan_client;

	console.log(plan_client);
});

/*Cadastrar Empresa */
router.post('/cadastrar_empresa', function(req, res, next) {
	console.log('Criando uma empresa filiada');
	Cliente.create({
        id_client: null,
		client_name: req.body.n_nome,
		market_segment: req.body.n_negocio,
		cnpj: req.body.n_cnpj,
		client_plan: plan_client,
		client_password: req.body.n_senha,
		proprietor: id_client
	}).then(resultado => {
		console.log(`Nova empresa filiada criada: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});
/* Cadastrar cliente*/
router.post('/cadastrar', function(req, res, next) {
	console.log('Criando um usuário');
	Cliente.create({
        id_client: null,
		client_name: req.body.n_nome,
		market_segment: req.body.n_negocio,
		cnpj: req.body.n_cnpj,
		plan: req.body.n_plano,
		client_password: req.body.n_senha,
		proprietor: null
	}).then(resultado => {
		console.log(`Novo usuário criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/session/:cnpj', function(req, res, next) {
	let login = req.params.cnpj;
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
router.get('/sair/:cnpj', function(req, res, next) {
	let login = req.params.cnpj;
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
