/**
 * For usage, visit Chart.js docs https://www.chartjs.org/docs/latest/
 */
const pieConfig = {
  type: 'doughnut',
  data: {
    datasets: [
      {
        data: [0,0],
        /**
         * These colors come from Tailwind CSS palette
         * https://tailwindcss.com/docs/customizing-colors/#default-color-palette
         */
        backgroundColor: ['#7e3af2', '#fff'],
        label: 'memória ram',
      },
    ],
    labels: ['memória utilizada(%)', 'memória livre(%)',],
  },
  options: {
    responsive: true,
    cutoutPercentage: 80,
    /**
     * Default legends are ugly and impossible to style.
     * See examples in charts.html to add your own legends
     *  */
    legend: {
      display: false,
    },
  },
}

// change this to the id of your chart element in HMTL
const pieCtx = document.getElementById('pie')
window.myPie = new Chart(pieCtx, pieConfig)
var server = sessionStorage.getItem('server');

function recuperarDadosRAM() {
  fetch(`/medidas/recuperar/ram`, {
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
        var used;
        var difference;
        var avaliable;
        parsed.forEach(data => {
          used = (data.usage * 100) / data.size

          difference = data.size - data.usage
          avaliable = (difference * 100) / data.size

          myPie.data.datasets[0].data.splice(0,1, parseFloat(used.toFixed(2)));
          myPie.data.datasets[0].data.splice(1,1, parseFloat(avaliable.toFixed(2)));
          myPie.update();
        });
      });
    } else {
      console.error('Nenhum dado encontrado ou erro na API');
    }
  }).catch(function (error) {
      console.error(`Erro na obtenção dos dados para Ram `, error.message);
    });
}
