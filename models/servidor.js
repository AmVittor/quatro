	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Servidor = sequelize.define('Servidor',{
		id_server: {
			field: 'id_server',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		server_name: {
			field: 'server_name',
			type: DataTypes.STRING,
			allowNull: false
		},
		operational_system: {
			field: 'operational_system',
			type: DataTypes.STRING,
			allowNull: false
		},		
		ip: {
			field: 'ip',
			type: DataTypes.STRING,
			allowNull: false
		},
		location: {
			field: 'location',
			type: DataTypes.STRING,
			foreignKey: true
		},
		fk_client: {
			field: 'fk_client',
			type: DataTypes.INTEGER,
			foreignKey: true
		},
	}, 
	{
		tableName: 'dbo_server',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Servidor;
};
