<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <Users/>
  </div>
</template>

<script>
import Users from "./Users";
export default {
  name: 'HelloWorld',
    components: {Users},
    props: {
    msg: String
  }
}
</script>
<style>
.hello{
    @import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
    font-family: 'Press Start 2P', cursive;
    background-image: url('../assets/background2.jpg');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    color: rgb(255, 255, 255);
    text-align: center;
    background-size: 100% 100%;
    background-repeat: no-repeat;

    }
</style>
