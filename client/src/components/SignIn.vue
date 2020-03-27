<template>
        <div class="wrapper">
            <div class="content_feed">
                <vue-displacement-slideshow
                        :images="images"
                        displacement="require('../assets/displacement.png')"
                        :intensity="0.2"
                        :speedIn="1.4"
                        :speedOut="1.4"
                        ease="expo.out"
                        ref="slideshow"></vue-displacement-slideshow>
            </div>
            <div class="form_auth">
                <h1><img src="./../assets/Camera.png" height="32" width="37"> PHOTO<b style="color:black">HUB</b></h1>
                <div class="separator_top"></div>
                <input id="email" v-model="email" type="email" name="email" placeholder="email@email.com">
                <input id="password" v-model="password" type="password" name="password" placeholder="pass">
            <p>
                <button v-on:click="auth">LOG IN PHOTOHUB</button>
            </p>
                <div class="separator">or</div>
                <div class="social_web">
                    <img src="./../assets/facebook.png" height="24" width="24">
                    <img src="./../assets/google.png" height="24" width="24">
                    <img src="./../assets/twitter.png" height="24" width="24">
                </div>


            </div>
            <div v-if="errors.length">
                <br>
                 <b>Please fill out the form correctly :</b>
            <ul>
                <li v-for="error in errors" :key="error">{{ error }}</li>
            </ul>
            </div>
            <div class="reg_feed">
                <p>
                     Doesn’t have a personal account?
                    <button v-on:click="rout_to_reg">REGISTRATION</button>
                </p>
            </div>
        </div>
</template>

<script>
    import ls from "local-storage"
    import axios from "axios"
    import VueDisplacementSlideshow from "vue-displacement-slideshow";


    const SignIn = {
        name: "SignIn",
        data: function () {
            return {
                users: [],
                errors: [],
                email: "",
                password: "",
            }
        },
        components: {
            VueDisplacementSlideshow,
        },
        computed: {
            images() {
                return [
                    require("../assets/images/4.png"),
                    require("../assets/images/3.png"),
                ];
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
                        ls.set("photohubUser", this.email);
                        this.$router.push("/");
                    } else if (response.status === 404) {
                        this.errors.push("User not found")
                    }
                }).catch(error => {
                    this.errors.push("User not found " + error)
                })
            },
            rout_to_reg: function () {
                this.$router.push("/Authorization");
            },
            validateEmail: function (email) {
                const emailRegEx = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                return emailRegEx.test(email);
            },
            init() {
                setInterval(() => {
                    this.$refs.slideshow.next();
                }, 2000);
            },
            mounted() {
                this.init();
            },
        }
    };


    export default SignIn
</script>

<style>
    .wrapper{
        margin-top: 10%;
        margin-left: 20%;
        margin-right: 5%;
        height: 600px;
        width:840px;
    }
    errors{
        font-color:blue;
    }
    .column_auth {
             width: 600px;
             margin-left: 200px;
             margin-top: 100px;

        }

    .form_auth h1 {
            font-family: Sedgwick Ave;
            align-items: center;
            text-align: center;
            color: #FFC800;
            font-size: 35px;
            margin-top: 10px;
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
    .social_web{
        list-style: none;
        font-size:0;
        margin:0px 10% 15% 17%;

    }
    .wrapper button{
        color: #000000;
        text-shadow: 0 0 1px rgb(1,1,1);
        cursor: pointer;
        position: relative;
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        border: 1px solid rgb(52, 56, 61);
        background: #FFC800;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        width: 250px;
        margin:20px 5% 1% 10%;
        padding: 5px;
        display: inline-block;
}

    .form_auth input {
        background: #FFFFFF;
        border: 1px solid rgba(1, 28, 64, 0.25);
        box-sizing: border-box;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        width: 250px;
        height: 35px;
        margin:20px 14% 0 14%;
        padding: 10px;
    }

    input::-webkit-input-placeholder {
        color: rgba(0, 0, 0, 0.25);;
        font-size: 18px;
        line-height: 21px;
    }

    .separator {
        display: flex;
        align-items: center;
        text-align: center;
        margin:20px 20px 1px 20px;
    }
    .separator_top{
        display: flex;
        align-items: center;
        text-align: center;
        margin:20px 20px 1px 20px;
    }
    .separator_top::before, .separator_top::after {
        content: '';
        flex: 1;
        border-bottom: 1px solid #000;
    }

    .separator::before, .separator::after {
        content: '';
        flex: 1;
        border-bottom: 1px solid #000;
    }

    .separator::before {
        margin-right: 1em;
    }
    .separator::after {
        margin-left: 1em;
    }
    .form_auth p{
        color: rgb(192, 192, 192);
        padding: 1px 20px;
        font-weight: 700;
        margin: 5px 0 0 0;
        font-size: 18px;
        line-height: 21px;
        display: flex;
        align-items: center;
    }
    .form_auth a{
        color: rgb(245, 245, 245);
        text-decoration: none;
    }
    .form_auth a:hover{
        border-bottom: 1px solid;
    }
    .form_auth{
        width: 350px;
        height: 375px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:right;
        margin-bottom: 40px;
    }
    .reg_feed{
        width: 350px;
        height: 109px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:right;
        text-align: center;
    }
    .content_feed{
        width: 450px;
        height: 550px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
    }
</style>