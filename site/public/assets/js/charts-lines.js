const lineConfig = {
  type: 'line',
  data: {
    labels: ["", "", "", "", ""],
    datasets: [
      {
        label: 'uso da cpu (%)',
        fill: false,
        backgroundColor: '#7e3af2',
        borderColor: '#7e3af2',
        data: [],
      },
    ],
  },
  options: {
    responsive: true,
    legend: {
      display: false,
    },
    tooltips: {
      mode: 'index',
      intersect: false,
    },
    hover: {
      mode: 'nearest',
      intersect: true,
    },
    scales: {
      x: {
        display: true,
        scaleLabel: {
          display: true,
          labelString: 'Month',
        },
      },
      y: {
        display: true,
        scaleLabel: {
          display: true,
          labelString: 'Value',
        },
      },
      ticks: {
        beginAtZero:true
    },
    },
    animation: {
      duration: 0
    },
  },
}

const lineCtx = document.getElementById('line')
window.myLine = new Chart(lineCtx, lineConfig)
var server = sessionStorage.getItem('server');

function recuperarDadosCpu() {
  fetch(`/medidas/recuperar/cpu`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      hostName: server.server_name
    }) 
    }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        var stringfied = JSON.stringify(resposta)
        var parsed = JSON.parse(stringfied)

        var firstHour = new Date(parsed[4].measurement_date)
        var secondHour = new Date(parsed[3].measurement_date)
        var thirdHour = new Date(parsed[2].measurement_date)
        var fourthHour = new Date(parsed[1].measurement_date)
        var fifthHour = new Date(parsed[0].measurement_date)

        myLine.data.labels.splice(0, 5,
          firstHour.toLocaleTimeString(),
          secondHour.toLocaleTimeString(),
          thirdHour.toLocaleTimeString(),
          fourthHour.toLocaleTimeString(),
          fifthHour.toLocaleTimeString()
        )

        myLine.update();
        
        parsed.forEach(data => {

          if (myLine.data.datasets[0].data.length == 5) {
            myLine.data.datasets[0].data.shift();
          }

          myLine.data.datasets[0].data.push(parseFloat(data.usage.toFixed(2)));
          myLine.update();
        });
      });
    } else {
      console.error('Nenhum dado encontrado ou erro na API');
    }
  }).catch(function (error) {
      console.error(`Erro na obtenção dos dados para Cpu `, error.message);
    });
}
