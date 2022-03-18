/**
 * 
 */

function confirmar(id){
    let resposta = confirm("Tem certeza que deseja excluir este contato?")

    if(resposta === true){
        window.location.href = "delete?id=" + id
    }
}