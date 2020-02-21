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
        background-image: url('/assets/background2.jpg');

</style>
