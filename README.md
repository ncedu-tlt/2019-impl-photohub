# 2019-impl-photohub
![Logo](/PhotoHub.png)

# REST API

    1) POST  /api/registration 

Request : {login: 'aaa', password: '123', email: 'aaa@gmail.com'}

Response : {status: 'success'} - 200. 

{status: 'error', msg: '....'} - в случае ошибки. msg - на русском.
           
    2) POST /api/auth

Request: {email: 'aaa@gmail.com' , password: '123'}

Response : {status: 'success'} - 200. 


{status: 'error', msg: '....'} - в случае ошибки. msg - коды: NOT_FOUND, SYSTEM_ERROR
          
    3) POST /api/imageUpload или /api/image/upload

Request: {email:"...", base64:"..."}

Response : {status: 'success'} - 200.

{status:'error'} - 404 (любую ошибку)
{status:'error'} - 409 - такая картинка уже загружена.

    4) GET /api/imageGet или /api/image/get?id=хх

        /api/imageGet или /api/image/get?email="@.com"
        
  Response: 200 + base64 (path поле) - одна картинка
  
  200 + [base64,base64,base64,...] - для всех картинок
  
  404 - в случае ошибки
  
    5) POST /api/image/archive/add?id= (imageArchiveAdd)
    
    /api/image/archive/del?id= (imageArchiveDel)

Request : id= - ид картинки {id: 'imageId'}

Response: 200 - OK , 404 - NOK
