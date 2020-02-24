<template>
  <div class="Authenticate">
    <h1>{{ msg }}</h1>
    <SignIn/>
  </div>
</template>

<script>
import SignIn from "./SignIn";
export default {
  name: 'Authenticate',
    components: {SignIn}
}
</script>
<style>
@import url('https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap');
</style>
