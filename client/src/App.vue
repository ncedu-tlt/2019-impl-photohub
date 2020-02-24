
<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
    //Authenticate
  }
}
</script>
<style>
body{
        background-image: url('/assets/background2.jpg');
        background-size: 100% 100%;
        background-repeat: no-repeat;
        padding: 80px;
        position: absolute;
        width: 320px;
        left: 50%;
        margin-left: -400px;
        top: 50%;
        margin-top: -360px;
}
    #app {
        @import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
        font-family: 'Press Start 2P', cursive;
        color: rgb(255, 255, 255);
    }

</style>
