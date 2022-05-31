'use strict';

module.exports = (sequelize, DataTypes) => {
    let Medida = sequelize.define('Medida',{
		id_measurement: {
			field: 'id_measurement',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		usage: {
			field: 'usage',
			type: DataTypes.INTEGER
		},
		temperature: {
			field: 'temperature',
			type: DataTypes.INTEGER
		},		
		measurement_date: {
			field: 'measurement_date',
			type: DataTypes.STRING,
		},
		fk_component: {
			field: 'fk_component',
			type: DataTypes.STRING,
            foreignKey: true
		},
		usage_unit: {
			field: 'usage_unit',
			type: DataTypes.STRING
		},
		temperature_unit: {
			field: 'temperature_unit',
			type: DataTypes.STRING
		}
	}, 
	{
		tableName: 'dbo.measurement',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Medida;
};