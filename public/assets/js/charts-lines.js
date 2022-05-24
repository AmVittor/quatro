
const lineConfig = {
  type: 'line',
  data: {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    datasets: [
      // {
      //   label: 'Organic',

      //   backgroundColor: '#0694a2',
      //   borderColor: '#0694a2',
      //   data: [43, 48, 40, 54, 67, 73, 70],
      //   fill: false,
      // },
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

function recuperarDadosCpu() {
  fetch(`/medidas/recuperar/cpu`, { cache: 'no-store' }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        var stringfied = JSON.stringify(resposta)
        var parsed = JSON.parse(stringfied)

        parsed.forEach(data => {
          if (myLine.data.datasets[0].data.length == 10) {
            myLine.data.datasets[0].data.shift();
          }

          myLine.data.datasets[0].data.push(parseFloat(data.usage));
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
