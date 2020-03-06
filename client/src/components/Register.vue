<template>
        <div class="column_reg">
                <h1 style="
                        margin-bottom: 10px;font-size: 50px;
                    ">Registered</h1>
                <label for="name">Name<br></label>
                <input id="name" v-model="name" type="text" name="name">
                <label for="email">Email<br></label>
                <input id="email" v-model="email" type="email" name="email">
                <label for="password">Password<br></label>
                <input id="password" v-model="password" type="password" name="password">

            <p>
                <button v-on:click="addNewUser">SignIN</button>
            </p>

            <div v-if="errors.length">
                <b>Please fill out the form correctly :</b><br>
                <ul>
                    <li v-for="error in errors" :key="error">{{ error }}</li><br>
                </ul>
            </div>
        </div>
</template>

<script>
    import axios from "axios"

    const Register = {
        name: "Register",

        data: function () {
            return {
                users: [],
                errors: [],
                name: null,
                email: null,
                password:null
            }
        },
        methods: {
            addNewUser: function () {
                this.errors = [];

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


                axios.post("/api/registration", {
                    name: this.name,
                    email: this.email,
                    password: this.password
                }).then(response => {
                    if (response.status === 200) {
                        this.users.push({name: this.name, email: this.email,password: this.password}),
                        this.$router.push("/authenticate")
                    }
                    else if(response.status===409){
                        this.errors.push("User already register")
                    }
                    else if(response.status===404){
                        this.errors.push("Try again")
                    }
                })
            },
            validateEmail: function (email) {
                const emailRegEx = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                return emailRegEx.test(email);
            },

            }
    };

    export default Register
</script>

<style>
    .column_reg {
        width: 600px;
        margin-left: 200px;
        margin-top: 100px;
    }

    h1 {
        text-align:center;
        font-size: 50px;


    }


    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 10px;
    }
    .column_reg button{
        color: rgb(192, 192, 192);
        text-shadow: 0 0 10px rgb(255, 255, 255);
        cursor: pointer;
        display: block;
        position: relative;
        width: 200px;
        height: 70px;
        color: rgb(192, 192, 192);
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        background: rgb(28, 30, 33);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        border: 6px solid rgb(52, 56, 61);
        font-size: 35px;
        text-indent: 0px;
}

    .column_reg label {
        color: rgb(192, 192, 192);
        height:45px;
        width:170px;
        font-size: 30px;
        float: left;
    }
    .column_reg input {
        border-top-right-radius: 8px;
        border-top-left-radius: 8px;
        border-bottom-right-radius: 8px;
        border-bottom-left-radius: 8px;
        float:right;
        position: relative;
        display: block;
        width: 280px;
        height: 45px;
        outline: 0;
        top: -2px;
        padding: 0 0 0 20px;
        font-weight: 700;
        font-weight: 700;
        font-size:25px;
        background: rgb(28, 30, 33);
        text-shadow:0 0 10px rgb(255, 255, 255);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        color: rgb(192, 192, 192);
    }
    .column_reg p{
    }
</style>