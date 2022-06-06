'use strict';

module.exports = (sequelize, DataTypes) => {
    let Request = sequelize.define('Request',{
		id_request: {
			field: 'id_request',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		location: {
			field: 'location',
			type: DataTypes.STRING
		},		
		request_date: {
			field: 'request_date',
			type: DataTypes.STRING,
		},
		fk_server: {
			field: 'fk_server',
			type: DataTypes.INTEGER,
            foreignKey: true
		}
	}, 
	{
		tableName: 'request',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Request;
};