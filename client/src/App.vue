<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld msg="Welcome to demo page for PhotoHub app"/>
        <p>
            <router-link to="/test1">Go to test 1</router-link>
            <router-link to="/test2">Go to test 2</router-link>
        </p>
        <router-view></router-view>
        <button v-on:click="switchRoute">Switch route</button>
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'

    export default {
        name: 'App',
        components: {
            HelloWorld
        },
        methods: {
            switchRoute: function () {
                const routeName = this.$router.currentRoute.name;
                if (routeName) {
                    const path = routeName === "test1" ? "/test2" : "/test1";
                    this.$router.push(path)
                } else {
                    this.$router.push("/test1")
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
</style>
