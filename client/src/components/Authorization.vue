<template>
  <div class="Authorization">
    <h1>{{ msg }}</h1>
    <Users/>
  </div>
</template>

<script>
import Users from "./Users";
export default {
  name: 'Authorization',
    components: {Users},
    props: {
    msg: String
  }
}
</script>
<style>
@import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
</style>
