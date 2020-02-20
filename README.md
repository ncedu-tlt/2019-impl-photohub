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
          
3)
