

  // GRÁFICO DO PROCESSADOR
  const config_line = {
    type: "line",
    data : {
      labels: ["09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"],
      datasets: [{
          label: "Uso do Processador(%)",
          data: ["30", "40", "70", "60", "80", "50", "40", "53", "60", "83", "95", "100", "70"],
          backgroundColor: "#5042ca",
          borderColor: "#5042ca"
      }]
    },
    options: {
      maintainAspectRatio: false,
    }
  }

  var myChartLine = new Chart(document.getElementById("myChartLine"), config_line);


  // GRÁFICO DA RAM
  const config_line2 = {
    type: "line",
    data : {
      labels: ["09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"],
      datasets: [{
          label: "Uso da RAM(%)",
          data: ["30", "30", "50", "45", "64", "70", "74", "59", "60", "83", "77", "90", "74"],
          backgroundColor: "#5042ca",
          borderColor: "#5042ca"
      }]
    },
    options: {
      maintainAspectRatio: false,
    }
  }

  var myChartLine = new Chart(document.getElementById("myChartLine2"), config_line2);

  //GRÁFICO DO DISCO
  const config_line3 = {
    type: "line",
    data : {
      labels: ["09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"],
      datasets: [{
          label: "Uso do Disco(%)",
          data: ["10", "19", "40", "27", "35", "50", "60", "48", "35", "53", "61", "43", "30"],
          backgroundColor: "#5042ca",
          borderColor: "#5042ca"
      }]
    },
    options: {
      maintainAspectRatio: false,
    }
  }

  var myChartLine = new Chart(document.getElementById("myChartLine3"), config_line3);

