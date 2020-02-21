
<template>
  <div id="app">
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
<style>
    #app {
        .fade-enter-active, .fade-leave-active {
            transition-property: opacity;
            transition-duration: .25s;
        }

        .fade-enter-active {
            transition-delay: .25s;
        }

        .fade-enter, .fade-leave-active {
            opacity: 0
        }

        @import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
        font-family: 'Press Start 2P', cursive;
        background-image: url('/assets/background2.jpg');
        background-size: 100% 100%;
        background-repeat: no-repeat;
        color: rgb(255, 255, 255);
        text-align: center;
        background-size: 100% 100%;
        background-repeat: no-repeat;
    }


</style>
