function Click (btn){
    if(btn === 'cachorro'){
document.getElementById('todos').classList.remove('btn_todos');//remove a classe btn_todos e deixa apenas as outras
document.getElementById('cachorro').classList.add('btn_todos');//add a classe btn_todos junto as outras apenas as outras
document.getElementById('gato').classList.remove('btn_todos');
}
    if(btn === 'gato'){
        document.getElementById('todos').classList.remove('btn_todos');
        document.getElementById('gato').classList.add('btn_todos');
        document.getElementById('cachorro').classList.remove('btn_todos');
            }

            if(btn === 'todos'){
                document.getElementById('todos').classList.add('btn_todos');
                document.getElementById('gato').classList.remove('btn_todos');
                document.getElementById('cachorro').classList.remove('btn_todos');       
            }
        }
//btn-outline

        
            
   




            

