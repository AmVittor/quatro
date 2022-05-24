var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Medida = require('../models').Medida;
var Component = require('../models').Component;

var tempo = 0;

let queryCPU = `SELECT id_component, usage, measurement_date, item, speed, [dbo].[measurement].temperature from measurement inner join [dbo].[component] on fk_component = id_component where measurement_date > DATEADD(mi, -200, GETDATE()) and fk_component = 1;`
let queryRAM = `SELECT id_component, size, usage, measurement_date, item, speed, [dbo].[measurement].temperature from measurement inner join [dbo].[component] on fk_component = id_component where measurement_date > DATEADD(mi, -200, GETDATE()) and fk_component = 2;`
let queryDISK = `SELECT id_component, usage, measurement_date, item, speed, [dbo].[measurement].temperature from measurement inner join [dbo].[component] on fk_component = id_component where measurement_date > DATEADD(mi, -200, GETDATE()) and fk_component IN(3,4);`
let queryQtdDisk = `select count(id_component) as quantidade from [dbo].[component] where item = 'disco' and fk_server = 1;`

router.get('/recuperar/cpu', function (req, res, next) {
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

router.get('/recuperar/ram', function (req, res, next) {
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

router.get('/recuperar/disco', function (req, res, next) {
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

router.get('/recuperar/quantidade/disco', function (req, res, next) {
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