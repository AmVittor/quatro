var express = require('express');
var router = express.Router();
var Servidor = require('../models').Servidor;

let id_client;

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
router.get('/fk/:id_client', function(req, res, next) {

	id_client = req.params.id_client;
	console.log(id_client);
})

/* Cadastrar servidor*/
router.post('/cadastrar', function(req, res, next) {
	console.log('Criando um Servidor:');
	Servidor.create({
        id_server: null,
		server_name: req.body.n_hostname,
		operational_system: req.body.n_so,
		ip: req.body.n_ip,
		location: null,
		fk_client: id_client
		
	}).then(resultado => {
		console.log(`Novo servidor criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


module.exports = router;
