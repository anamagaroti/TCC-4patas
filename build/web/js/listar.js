$(document).ready(function (){
    let urlBusca = `${window.location.origin}\petdao\: %s`;
    $.getJSON(urlBusca, function(response){
        if(response !== null || response !== undefined){
            var listaPet = response;
            console.log(listaPet);
        }
    });
});