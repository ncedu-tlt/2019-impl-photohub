<template>
    <div class="auth">
        <h3>Form for entering user</h3>
        <h3  v-if="msg">
            {{msg}}
        </h3>
    <p>
        <label for="email">Email</label>
        <input id="email" v-model="email" type="email" name="email">
    </p>
    <p>
        <label for="password">Password</label>
        <input id="password" v-model="password" type="password" name="password">
    </p>
    <p>
        <button v-on:click="login">auth</button>
    </p>
    <p v-if="errors.length">
            <b>Please fix next errors:</b>
        <ul>
            <li v-for="error in errors" :key="error">{{ error }}</li>
        </ul>
    </p>
    </div>
</template>

<script>
    import axios from "axios"

    const Auth = {
        name: "Auth.vue",

        data: function () {
            return {
                errors: [],
                email: null,
                password: null,
                msg: null,
            }
          },

        methods: {

            login: function() {
                this.errors = [];
                if (!this.email) {
                    this.errors.push("Enter user email")
                } else if (!this.validateEmail(this.email)) {
                    this.errors.push("Enter valid email address")
                }

                if(!this.password) {
                    this.errors.push("Enter password")
                }

                if (this.errors.length) {
                    return
                }

                axios.post("/api/auth", {
                    email: this.email,
                    password: this.password
                }).then(response => {
                    if (response.status === 200) {
                        this.msg = "success"
                    }
                }).catch(error => {
                    if (error.response.status === 404) {
                        this.msg = "404 NOT FOUND"
                    } else {
                        this.msg = "System Error"
                    }
                    console.error(error)
                })
            },
            validateEmail: function (email) {
                const emailRegEx = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                return emailRegEx.test(email);
            }

        }

    };

    export default Auth


</script>

<style>

    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 10px;
    }

    label {
        margin-right: 10px;
    }
</style>