<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld msg="Welcome to demo page for PhotoHub app"/>
        <p>
            <router-link to="/Users">Registration</router-link>
            <router-link to="/Auth">Autorisation</router-link>
        </p>
        <router-view></router-view>
        <button v-on:click="switchRoute">Switch route</button>
        <Users></Users>
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    export default {
        name: 'App',
        components: {
            HelloWorld,

        },
        methods: {
            switchRoute: function () {
                const routeName = this.$router.currentRoute.name;
                if (routeName) {
                    const path = routeName === "Users" ? "/Auth" : "/Users";
                    this.$router.push(path)
                } else {
                    this.$router.push("/Users")
                }
            }
        }
    }
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
    a {
      margin-right: 10px;
    }
</style>
