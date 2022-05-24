	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Cliente = sequelize.define('Cliente',{
		id_client: {
			field: 'id_client',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		client_name: {
			field: 'client_name',
			type: DataTypes.STRING,
			allowNull: false
		},
		market_segment: {
			field: 'market_segment',
			type: DataTypes.STRING,
			allowNull: false
		},		
		cnpj: {
			field: 'cnpj',
			type: DataTypes.STRING,
			allowNull: false
		},
		plan: {
			field: 'plan',
			type: DataTypes.STRING,
			allowNull: false
		},
		client_password: {
			field: 'client_password',
			type: DataTypes.STRING,
			allowNull: false
		},
		proprietor: {
			field: 'proprietor',
			type: DataTypes.STRING,
			allowNull: true
		},
	}, 
	{
		tableName: 'dbo_client',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Cliente;
};
