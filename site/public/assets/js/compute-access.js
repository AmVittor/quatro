window.onload = function() {
    compute();
}

function compute() {
    var data = new Date();
    var location = window.location.href

    fetch("/servidores/compute", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
          },
        body: JSON.stringify({
            location: location,
            date: data
        })
    }).then(function (response) {
        console.log(response);
        if (response.ok) {
          console.log("Computando acessos...")
        } else {
            console.log('Erro ao computar acessos');
        }
    });

}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-') + " " + date.toLocaleTimeString();
}