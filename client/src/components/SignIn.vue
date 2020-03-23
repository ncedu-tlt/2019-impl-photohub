<template>
        <div class="column_auth">
                <h1 style="
                       margin-bottom: 10px;font-size: 50px;
                   ">SignIn </h1>
                <label for="email">Email<br></label>
                <input id="email" v-model="email" type="email" name="email">
                <label for="password">Password<br></label>
                <input id="password" v-model="password" type="password" name="password">

            <p>
                <button v-on:click="auth">SignIN</button>
            </p>
            <p>
                <router-link to="/Authorization">Not yet registrated ?</router-link>
            </p>
            <div v-if="errors.length">
                <br>
                 <b>Please fill out the form correctly :</b>
            <ul>
                <li v-for="error in errors" :key="error">{{ error }}</li>
            </ul>
            </div>
        </div>
</template>


<script>
    import ls from "local-storage"
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
        methods: {
            auth: function () {
                if (!this.email) {
                    this.errors.push("Enter user email")
                } else if (!this.validateEmail(this.email)) {
                    this.errors.push("Enter valid email address")
                }

                if (this.errors.length) {
                    return
                }

                axios.post("/api/user/auth", {
                    email: this.email,
                    password: this.password
                }).then(response => {
                    if (response.status === 200) {
                            ls.set("photohubUser",this.email);
                            this.$router.push("/");
                            }
                    else if(response.status===404){
                        this.errors.push("User not found")
                    }
                    }).catch(error=>{
                        this.errors.push("User not found " + error)
                })
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
    errors{
        font-color:red;
    }
    .column_auth {
             width: 600px;
             margin-left: 200px;
             margin-top: 100px;

        }

    h1 {
            text-align:center;
    }


    ul {
        list-style-type: none;
        padding: 0;
        color:red;
    }

    li {
        margin: 10px;
        color:red;
    }
    b{
        color:red;
    }
    .column_auth button{
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
        margin-bottom:100px;
}

    .column_auth label {
        color: rgb(192, 192, 192);
        height:45px;
        width:170px;
        font-size: 30px;
        float: left;
    }
    .column_auth input {
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
    .column_auth p{
        color: rgb(192, 192, 192);
        padding: 1px 20px;
        font-weight: 700;
        font-size: 15px;
        margin: 5px 0 0 0;
    }
    .column_auth a{
        color: rgb(245, 245, 245);
        text-decoration: none;
    }
    .column_auth a:hover{
        border-bottom: 1px solid;
    }
</style>