
<template>
  <div id="app">
    <span class="bg"></span>
    <router-view/>
  </div>
</template>

<script>
//import Authenticate from './components/Authenticate.vue'

export default {
  name: 'App',
  components: {
    //Authenticate
  }
}
</script>
<style >
    #app {

        @import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
        font-family: 'Press Start 2P', cursive;
        background-image: url('/assets/background2.jpg');
        background-size: 100% 100%;
        background-repeat: no-repeat;
        color: rgb(255, 255, 255);
        background-size: 100% 100%;
        background-repeat: no-repeat;
    }
 .bg{ width: 100%;
         height: 100%;
         position: absolute;
         top: 0;
         left: 0;
         background: url( '/assets/background2.jpg') no-repeat center center;
         background-size: cover;
         transform: scale(1.1);
  }
</style>
