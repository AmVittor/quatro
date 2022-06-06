
anychart.onDocumentReady(function () {

  var server = sessionStorage.getItem('server');

    var data = [
      {x: "Segunda", y: ""},
      {x: "Terça", y: ""} ,
      {x: "Quarta", y: ""},
      {x: "Quinta", y: ""},
      {x: "Sexta", y: ""},
      {x: "Sábado", y: ""},
      {x: "Domingo", y: ""}
    ];

    fetch(`/servidores/getAcessos`, {
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

          console.log(resposta);
          for (let i = 0; i < resposta.length; i++) {
            if(resposta[i].dia == 2) {
                data.push({
                  x: "Segunda", y: resposta[i].location, heat: resposta[i].total
                })
            } else if(resposta[i].dia == 3) {
              data.push({
                x: "Terça", y: resposta[i].location, heat: resposta[i].total
              })
            } else if(resposta[i].dia == 4) {
              data.push({
                x: "Quarta", y: resposta[i].location, heat: resposta[i].total
              })
            } else if(resposta[i].dia == 5) {
              data.push({
                x: "Quinta", y: resposta[i].location, heat: resposta[i].total
              })
            } else if(resposta[i].dia == 6) {
              data.push({
                x: "Sexta", y: resposta[i].location, heat: resposta[i].total
              })
            } else if(resposta[i].dia == 7) {
              data.push({
                x: "Sábado", y: resposta[i].location, heat: resposta[i].total
              })
            } else if(resposta[i].dia == 8) {
              data.push({
                x: "Domingo", y: resposta[i].location, heat: resposta[i].total
              })
            } 
          }
         
          console.log(data);
          chart = anychart.heatMap(data);
  
          // Cria o gráfico e poe os dados
         
          console.log(data);
          // Titulo do gráfico
          chart.title("Acessos ultima semana");
      
          // Cria e configura as cores de acordo com os valores
          var customColorScale = anychart.scales.ordinalColor();
          customColorScale.ranges([
            { less: 10, name: 'Baixo: <= 10', color: '#C0392B' },
            { from: 11, to: 20, name: 'Médio: 11 - 22', color: '#F39C12' },
            { from: 21, to: 30, name: 'Alto: 21 - 30', color: '#F1C40F' },
            { greater: 31, name: 'Muito alto: 31', color: '#27AE60' }
          ]);
      
          // Seta as cores para cada intervalo do menor para o maior
          customColorScale.colors(["#C0392B", "#F39C12", "#F1C40F", "#27AE60"]);
      
          // set the color scale as the color scale of the chart
          chart.colorScale(customColorScale);
      
          // Ativiar ou desativar legenda
          chart.legend(true);
      
          // ativa/desativa números nos quadrados
          chart.labels().enabled(false);
      
          // Pega o id da div
          chart.container("container");
      
          // Desenha o gráfico
          chart.draw();
    })
      } else {
        console.error('Nenhum dado encontrado ou erro na API');
      }
    }).catch(function (error) {
      console.error(`Erro na obtenção dos acessos do servidor`, error.message);
    });

});

const body = document.querySelector('body'),
  sidebar = body.querySelector('nav'),
  toggle = body.querySelector(".toggle"),
  searchBtn = body.querySelector(".search-box"),
  modeSwitch = body.querySelector(".toggle-switch"),
  modeText = body.querySelector(".mode-text");


toggle.addEventListener("click", () => {
  sidebar.classList.toggle("close");
})

searchBtn.addEventListener("click", () => {
  sidebar.classList.remove("close");
})

modeSwitch.addEventListener("click", () => {
  body.classList.toggle("dark");

  if (body.classList.contains("dark")) {
    modeText.innerText = "Light mode";
  } else {
    modeText.innerText = "Dark mode";

  }
});

