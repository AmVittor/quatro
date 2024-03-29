module.exports = {
    // Insira aqui seus dados do banco NA NUVEM AZURE
     production: {
      // altere APENAS username, password, database e host.
      username: 'quatro',
      password: '2ads$grupo3',
      database: 'quatro_db',
      host: 'quatro-server.database.windows.net',
      dialect: 'mssql',
      xuse_env_variable: 'DATABASE_URL',
      define: {
        schema: "dbo"
    },
      dialectOptions: {
        options: {
          encrypt: true
        }
      
      },
      pool: { 
        max: 5,
        min: 1,
        acquire: 5000,
        idle: 30000,
        connectTimeout: 5000
      }
    },
  
    // Insira aqui seus dados do banco LOCAL - MySQL Workbench
    // dev: {
    //   // altere APENAS username, password e database.
    //   username: 'root',
    //   password: '4546',
    //   database: '4four',
    //   host: 'localhost',
    //   dialect: 'mysql',
    //   xuse_env_variable: 'DATABASE_URL',
    //   dialectOptions: {
    //     options: {
    //       encrypt: true
    //     }
    //   },
    //   pool: { 
    //     max: 5,
    //     min: 1,
    //     acquire: 5000,
    //     idle: 30000,
    //     connectTimeout: 5000
    //   }
    // },
  };