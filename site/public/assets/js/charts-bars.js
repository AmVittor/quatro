const barConfig = {
  type: 'bar',
  data: {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    datasets: [],
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
        beginAtZero:false
    },
    },
    animation: {
      duration: 0
    },
  },
}

const barsCtx = document.getElementById('bars')
window.myBar = new Chart(barsCtx, barConfig)
var qtdDiscos = 0;
var colors = ['#7e3af2', '#085555', '1aa308'];
var hostName = sessionStorage.getItem('hostName');

function recuperarQuantidadeDisco() {
    fetch(`/medidas/recuperar/quantidade/disco`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        hostName: hostName
      })
    }).then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
            this.qtdDiscos = resposta[0][0].quantidade
            setarLabels()
        });
      } else {
        console.error('Nenhum dado encontrado ou erro na API');
      }
    }).catch(function (error) {
        console.error(`Erro na obtenção da quantidade de discos: ${error.message}`);
      });     
}

function setarLabels() {
  for (let i = 0; i < qtdDiscos; i++) {
    myBar.data.datasets.push(
      {
        data: [],
        backgroundColor: colors[i],
        label: 'disco ' + (i + 1) + '(GB)',
      }
    )
  }
}

function recuperarDadosDisco() {
  fetch(`/medidas/recuperar/disco`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      hostName: hostName
    }) 
  }).then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        var stringfied = JSON.stringify(resposta)
        var parsed = JSON.parse(stringfied)

        parsed.forEach(data => {
          for (let j = 0; j < myBar.data.datasets.length;j++) {
            if (myBar.data.datasets[j].data.length == 10) {
              myBar.data.datasets[j].data.shift();
            }
          }

          var convertedToGB = parseFloat(data.usage) / 1024 / 1024 / 1024
          

          if(data.id_component == 3) {
            myBar.data.datasets[0].data.push(convertedToGB.toFixed(2))
          } else {
            myBar.data.datasets[1].data.push((convertedToGB * 1800.).toFixed(2))
          }

          myBar.update();
        });
      });
    } else {
      console.error('Nenhum dado encontrado ou erro na API');
    }
  }).catch(function (error) {
      console.error(`Erro na obtenção dos dados do Disco `, error.message);
    });
}