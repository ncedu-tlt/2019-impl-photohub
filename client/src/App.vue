<template>
  <div class="app">
    <router-view/>
    <notifications group="foo" />

  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>
<style>
    body{
        background-color: #F3F3F3;
        margin: 0
    }
  .vue-notification-group{
    margin: 0 5px 5px;
    font-size: 12px;
    color: #ffffff;
  }
  .vue-notification-group .error{

  }
</style>
