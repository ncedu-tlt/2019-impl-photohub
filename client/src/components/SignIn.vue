<template>
    <div class="users-container">
        <div class="column">
                <h1>SignIn </h1>
                <label for="email">Email<br></label>
                <input id="email" v-model="email" type="email" name="email">
                <label for="password">Password<br></label>
                <input id="password" v-model="password" type="password" name="password">

            <p>
                <button v-on:click="Auth">SignIN</button>
            </p>
            <p>
                <router-link to="/Authorization">Not yet registrated?</router-link>
            </p>
            <p v-if="errors.length">
                <b>Please fill out the form correctly :</b>
                <ul>
                    <li v-for="error in errors" :key="error">{{ error }}</li>
                </ul>
            </p>
            </div>
        </div>
</template>

<script>
    import axios from "axios"

    const SignIn = {
        name: "SignIn",

        data: function () {
            return {
                users: [],
                errors: [],
                email:"",
                password:""
            }
        },

        mounted() {

        },

        methods: {
            Auth: function () {
                this.errors = [];
                let email = this.email
                let password = this.password
                this.$store.dispatch('login', { email, password })
               .then(() => this.$router.push('/Profile'))
               .catch(err => console.log(err))
                if (!this.name) {
                    this.errors.push("Enter user name")
                }
                if (!this.email) {
                    this.errors.push("Enter user email")
                } else if (!this.validateEmail(this.email)) {
                    this.errors.push("Enter valid email address")
                }

                if (this.errors.length) {
                    return
                }

                axios.get("/api/auth", {
                    email: this.email,
                    password: this.password
                }).then(response => {
                    if (response.status === 200) {
                            this.$router.push("/Profile")}
                        }
                )
            },
            validateEmail: function (email) {
                const emailRegEx = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                return emailRegEx.test(email);
            },

        }
    };

    export default SignIn
</script>

<style>
    .users-container {
    height:600px;

    }

    .column {
    width:500px;
    }

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
    .column button{
        color: rgb(192, 192, 192);
        text-shadow: 0 0 10px rgb(255, 255, 255);
        cursor: pointer;
        display: block;
        position: relative;
        width: 120px;
        height: 52px;
        color: rgb(192, 192, 192);
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        background: rgb(28, 30, 33);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        border: 6px solid rgb(52, 56, 61);
        font-size: 25px;
        text-indent: 0px;
}

    .column label {
        color: rgb(192, 192, 192);
        height:45px;
        width:170px;
        font-size: 15px;
        float: left;
    }
    .column input {
        border-top-right-radius: 8px;
        border-top-left-radius: 8px;
        border-bottom-right-radius: 8px;
        border-bottom-left-radius: 8px;
        float:right;
        width: 280px;
        height: 45px;
        border: 0;
        outline: 0;
        top: -2px;
        padding: 0 0 0 20px;
        font-weight: 700;
        background: rgb(28, 30, 33);
        text-shadow:0 0 10px rgb(255, 255, 255);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        color: rgb(192, 192, 192);
    }
    .column p{
    }
</style>