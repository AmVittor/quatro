const barConfig = {
  type: 'bar',
  data: {
    labels: ["", "", "", "", ""],
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
var colors = ['#7e3af2', '#085555', '#1aa308', '#031680', '#06dabd', '#9acc0f', '#f0a911','#f02011', '#f01193', '#119ef0'];
var server = sessionStorage.getItem('server');
var labels_disk = document.getElementById("labels_disk")
var convertedToMB

function recuperarQuantidadeDisco() {
    fetch(`/medidas/recuperar/quantidade/disco`, {
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
            this.qtdDiscos = resposta[0].quantidade
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

    labels_disk.innerHTML += 
              `
              <div class="flex items-center">
              <span class="inline-block w-3 h-3 mr-1 rounded-full" style="background-color: ${colors[i]}"></span>
              <span>Disco ${i + 1}</span>
              </div>
            `
  }
}

function recuperarDadosDisco() {
  fetch(`/medidas/recuperar/disco`, {
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

        myBar.data.labels.splice(0, 5,
          firstHour.toLocaleTimeString(),
          secondHour.toLocaleTimeString(),
          thirdHour.toLocaleTimeString(),
          fourthHour.toLocaleTimeString(),
          fifthHour.toLocaleTimeString()
        )

        myBar.update();
        
        let idList = []

        parsed.forEach(data => {
          idList.push(data.id_component)

          for (let j = 0; j < myBar.data.datasets.length;j++) {
            if (myBar.data.datasets[j].data.length == 10) {
              myBar.data.datasets[j].data.shift();
            }
          }

          myBar.update();
        });

        let filtered = [...new Set(idList)]
        console.log(filtered);
        parsed.forEach(data => {
  
          this.convertedToMB = data.usage / 1024 / 1024 / 1024

          for (let j = 0; j < myBar.data.datasets.length;j++) {
            if(data.id_component == filtered[j]) {
              myBar.data.datasets[j].data.push(convertedToMB.toFixed(2))
            }
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