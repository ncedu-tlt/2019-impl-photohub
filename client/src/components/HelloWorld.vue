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
