	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Component = sequelize.define('Component',{
		id_component: {
			field: 'id_component',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		item: {
			field: 'item',
			type: DataTypes.STRING,
			allowNull: false
		},
		size: {
			field: 'size',
			type: DataTypes.INTEGER,
			allowNull: false
		},		
		speed: {	
			field: 'speed',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		fk_server: {
			field: 'fk_server',
			type: DataTypes.INTEGER,
			foreignKey: true
		},
		temperature: {
			field: 'temperature',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		UUID: {
			field: 'UUID',
			type: DataTypes.STRING,
			allowNull: false
		},
	}, 
	{
		tableName: 'component',
		freezeTableName: true,
		underscored: true,
		timestamps: false,
	});

    return Component;
};
