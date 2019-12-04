function Formdata(validation){
/* если не заполнено поле Ваше имя, длина менее 3-x*/
if (validation.login != null && validation.login.value.length < 3 )
{
alert('Заполните поле "Ваш логин"');
return false;}


if(validation.email != null && validation.email.value.length == 0)
{
alert('поле "E-Mail" пустое');
return false;}

if(validation.email != null && validation.email.value.length < 6)
{
alert('слишком короткий "E-Mail"');
return false;}

if(!(/^[\w-\.]+@[\w-]+\.[a-z]{2,4}$/.test(validation.email.value)) )
{
alert("Введите правильный E-Mail адрес");
return false;}

if (validation.name != null && validation.name.value.length < 3 )
{
alert('Заполните поле "Ваше имя"');
return false;}

if (validation.surname != null && validation.surname.value.length < 3 )
{
alert('Заполните поле "Вашу фамилию"');
return false;}

alert ('Ваше сообщение отправлено! Спасибо!');
     function reload()
     {location = 'index.html'}; 
     setTimeout('reload()', 0);
}

