<template>
  <div id="app">
     <div class="logo">
     <img alt="Vue logo" src="./assets/PhotoHub.png">
     </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>
<style>
body{
        background-image: url('/assets/background2.jpg');
        background-color:rgb(0, 0, 0);
        background-size: 100% 100%;
        background-repeat: no-repeat;
        margin: auto;
        position: absolute;
        top: 5%;
        margin-left: 10%;
        margin-right: 10%;
}
.logo{
margin: auto;
text-align:center
}
    #app {
        @import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
        font-family: 'Press Start 2P', cursive;
        color: rgb(255, 255, 255);
    }

</style>
