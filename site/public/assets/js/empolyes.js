
	$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});


 function aguardar() {
   var divAguardar = document.getElementById("div_aguardar");
   divAguardar.style.display = "block";
}

function finalizarAguardar() {
 aguardar();
 var divAguardar = document.getElementById("div_aguardar");
   divAguardar.style.display = "none";
}

// Pegando o ID do cliente para inserir nos usuarios
var idClient = sessionStorage.cliente_id;

console.log("Id do Cliente:" + idClient);

window.onload = pegar(idClient)

function pegar(idClient){
 fetch(`/usuarios/fk/${idClient}`, { cache: 'no-store' }).then(function (response) {
 })
}
 function cadastrar() {
   aguardar();

   var formulario = new URLSearchParams(new FormData(form_cadastro));
   fetch("/usuarios/cadastrar", {
	   method: "POST",
	   body: formulario
   }).then(function (response) {
	   if (response.ok) {
		 console.log("Funcionário cadastrado com sucesso!")
		 window.location.href = 'emprises.html';
	   } else {

		   console.log('Erro de cadastro!');
		   response.text().then(function (resposta) {
			   div_erro.innerHTML = resposta;
		   });
	   }
   });

   return false;
 }