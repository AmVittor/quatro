	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id_user: {
			field: 'id_user',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		user_name: {
			field: 'user_name',
			type: DataTypes.STRING,
			allowNull: false
		},
		email: {
			field: 'email',
			type: DataTypes.STRING,
			allowNull: false
		},		
		user_password: {
			field: 'user_password',
			type: DataTypes.STRING,
			allowNull: false
		},
		fk_client: {
			field: 'fk_client',
			type: DataTypes.INTEGER,
			foreignKey: true
		},
	}, 
	{
		tableName: 'dbo_user',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
