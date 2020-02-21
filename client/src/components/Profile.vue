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
    components: {SignIn},
    props: {
    msg: String
  }
}
</script>
<style>


</style>
