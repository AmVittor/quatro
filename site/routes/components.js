var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Component = require('../models').Component;

let sessoes = [];
let id_server;

/* Pegando id do server*/
router.get('/fk/:id_server', function(req, res, next) {

	id_server = req.params.id_server;
	console.log(id_server);
});

router.put('/editar/:id_component', function(req, res){
	let _item = req.body.n_c_item_a;
	let _size = req.body.n_c_size_a;
	let _speed = req.body.n_c_speed_a;
	let _temp = req.body.n_c_temp_a;
	let _uuid = req.body.n_c_uuid_a;

	let idComponent = req.params.id_component;
	
	Component.update(
		{
			item: `${_item}`,
			size: `${_size}`,
			speed: `${_speed}`,
			temperature: `${_temp}`,
			UUID: `${_uuid}`,
		},
		{
		  where: { id_component: `${idComponent}` },
		}
	  ).then(
		function (resultado) {
			console.log("Componente atualizado com sucesso!")
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

router.delete('/deletar/:id_component', function(req, res){
	let idComponent = req.params.id_component;

	Component.destroy({
		where: {
			id_component: idComponent,
		}
	}).then(resultado =>{
		console.log(`Usuário excluído: ${resultado}`);
	}).catch(erro =>{
		console.log(erro);
	
	});
});
// Cadastrar Componente
router.post('/cadastrar', function(req, res, next) {
	
	console.log('Criando um usuário');
	Component.create({
        id_component: null,
		item: req.body.n_c_item,
		size: req.body.n_c_size,
		speed: req.body.n_c_speed,
		fk_server: id_server,
		temperature: req.body.n_c_temp,
		UUID: req.body.n_c_uuid,

	}).then(resultado => {
		console.log(`Novo usuário criado: ${resultado}`);
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});

});

/* Recuperar todos os componente */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os componentes');
	Component.findAndCountAll({
		where :{
			fk_server : id_server
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