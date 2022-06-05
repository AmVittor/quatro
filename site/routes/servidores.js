var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Servidor = require('../models').Servidor;

let id_client;
let localizacaoServer;

/* Recuperar servidor por ID do cliente e IP */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var id = id_client; // depois de .body, use o nome (name) do campo em seu formulário de login
	var ip = req.body.n_ip; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from dbo_server where ip='${ip}' and fk_client='${id}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Servidor
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.ip);
			console.log('Session ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Ip e/ou Id inválido(s)');
		} else {
			res.status(403).send('Mais de um servidor com o mesmo ip e id!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Pegando id do cliente*/
router.delete('/deletar/:id_server', function(req, res){
	let idServer = req.params.id_server;
	
	Servidor.destroy({
		where: {
			id_server: idServer,
		}
	}).then(resultado =>{
		console.log(`Servidor excluído: ${resultado}`);
	}).catch(erro =>{
		console.log(erro);
		
	});
});

router.get('/fk/:id_client', function(req, res, next) {

	id_client = req.params.id_client;
	console.log(id_client);
});

router.get('/localizar/:endereco', function(req, res, next) {
	localizacaoServer = req.params.endereco;
	console.log(localizacaoServer);
});
/* Cadastrar servidor*/
router.post('/cadastrar', function(req, res, next) {
	console.log('Criando um Servidor:');
	Servidor.create({
        id_server: null,
		server_name: req.body.n_s_hostname,
		operational_system: req.body.n_s_so,
		ip: req.body.n_s_ip,
		location: localizacaoServer,
		fk_client: id_client
		
	}).then(resultado => {
		console.log(`Novo servidor criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

router.put('/editar/:id_server', function(req, res){
	let varHostname = req.body.n_s_hostname_a;
	let varOs = req.body.n_s_so_a;
	let varIp = req.body.n_s_ip_a;
	let idServer = req.params.id_server;
	
	Servidor.update(
		{
			server_name: `${varHostname}`,
			operational_system: `${varOs}`,
			ip: `${varIp}`,
			location: `${localizacaoServer}`,
			fk_client: id_client
		},
		{
		  where: { id_server: `${idServer}` },
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
/* Recuperar todos os servidores */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os servidores');
	Servidor.findAndCountAll({
		where :{
			fk_client : id_client
		}
	}).then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});
module.exports = router;
