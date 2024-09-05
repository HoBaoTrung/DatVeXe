function  deleteItem(path,back=false){
    fetch(path,{
        method:"delete"
    }).then(res=>{
        if(res.status===204)
           if(back===true)
               window.history.back();
           else location.reload();
      
    })
}

