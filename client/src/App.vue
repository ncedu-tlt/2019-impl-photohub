<template>
  <div id="app">
    <HelloWorld msg="PhotoHub"/>
    <router-link class="nav-link" active-class="active" to="/HelloWorld">Autorizated</router-link>
    <router-link class="nav-link" active-class="active" to="/SignIn">Page 1</router-link>
    <transition name="fade">
              <router-view></router-view>
        </transition>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
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

    }
</style>
