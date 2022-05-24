process.env.NODE_ENV = 'production'; // altere para 'production' ou 'dev'

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var clientesRouter = require('./routes/clientes');
var usuariosRouter = require('./routes/usuarios');
var servidoresRouter = require('./routes/servidores');
var medidasRouter = require('./routes/medidas');


var app = express();

app.use(logger('production')); 
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/clientes', clientesRouter);
app.use('/usuarios', usuariosRouter);
app.use('/servidores', servidoresRouter);
app.use('/medidas', medidasRouter);


module.exports = app;

// npm i
// npm i -g nodemon