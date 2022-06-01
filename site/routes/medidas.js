var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Medida = require('../models').Medida;
var Component = require('../models').Component;

router.post('/recuperar/cpu', function (req, res, next) {
	console.log("entrou no req", req.body.hostName);
	let queryCPU = `SELECT 
					top 5
					server_name,
					operational_system,
					id_component, 
					usage, 
					measurement_date, 
					item, 
					speed, 
					[dbo].[measurement].temperature
					from measurement 
					inner join [dbo].[component] 
					on fk_component = id_component 
					inner join [dbo].[server]
					on fk_server = id_server
					where measurement_date > DATEADD(mi, -200, GETDATE()) 
					and item like 'cpu'
					and server_name like '${req.body.hostName}'
					order by measurement_date desc`

	sequelize.query(queryCPU, {
		model: Medida
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

router.post('/recuperar/ram', function (req, res, next) {
	let queryRAM = `SELECT 
					top 5
					server_name,
					operational_system,
					id_component, 
					usage, 
					size,
					measurement_date, 
					item, 
					speed, 
					[dbo].[measurement].temperature
					from measurement 
					inner join [dbo].[component] 
					on fk_component = id_component 
					inner join [dbo].[server]
					on fk_server = id_server
					where measurement_date > DATEADD(mi, -200, GETDATE()) 
					and item like 'ram'
					and server_name like '${req.body.hostName}'
					order by measurement_date desc`

	sequelize.query(queryRAM, {
		model: Medida
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

router.post('/recuperar/disco', function (req, res, next) {
	let queryDISK = `SELECT 
					top 10
					server_name,
					operational_system,
					id_component, 
					usage, 
					measurement_date, 
					item, 
					speed, 
					[dbo].[measurement].temperature
					from measurement 
					inner join [dbo].[component] 
					on fk_component = id_component 
					inner join [dbo].[server]
					on fk_server = id_server
					where measurement_date > DATEADD(mi, -200, GETDATE()) 
					and item like 'disco'
					and server_name like '${req.body.hostName}'
					order by measurement_date desc`

	sequelize.query(queryDISK, {
		model: Medida
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

router.post('/recuperar/quantidade/disco', function (req, res, next) {
	let queryQtdDisk = `
	select count(id_component) as quantidade from [dbo].[component] 
	inner join [dbo].[server]
	on fk_server = id_server
	where item = 'disco' 
	and server_name like '${req.body.hostName}';`

	sequelize.query(queryQtdDisk, {
		model: Component
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});
module.exports = router;