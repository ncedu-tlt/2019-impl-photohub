<template>
    <div class="wrapper">
            <div class="form_reg">
                <h1><img src="./../assets/Camera.png" height="32" width="37"> PHOTO<b style="color:black">HUB</b></h1>
                <div class="separator_top"></div>

                    <input id="name" v-model="name" type="text" name="name" placeholder="name"><div class="tick" v-show="confirm_name"><svg width="18" height="14" viewBox="0 0 18 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6.00002 11.2L1.80002 7L0.400024 8.4L6.00002 14L18 2L16.6 0.599998L6.00002 11.2Z" fill="#75DB6D"/>
                </svg>
                </div>
                    <input id="email" v-model="email" type="email" name="email" placeholder="email@email.com"><div class="tick" v-show="confirm_email"><svg width="18" height="14" viewBox="0 0 18 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6.00002 11.2L1.80002 7L0.400024 8.4L6.00002 14L18 2L16.6 0.599998L6.00002 11.2Z" fill="#75DB6D"/>
                </svg>
                </div>
                    <input id="password" v-model="password" type="password" name="password" placeholder="pass"><div class="tick" v-show="confirm_password"><svg width="18" height="14" viewBox="0 0 18 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6.00002 11.2L1.80002 7L0.400024 8.4L6.00002 14L18 2L16.6 0.599998L6.00002 11.2Z" fill="#75DB6D"/>
                </svg>
                </div>
                    <input id="confirm_password" v-model="password" type="password" name="confirm_password" placeholder="confirm pass"><div class="tick" v-show="confirm_repass"><svg width="18" height="14" viewBox="0 0 18 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6.00002 11.2L1.80002 7L0.400024 8.4L6.00002 14L18 2L16.6 0.599998L6.00002 11.2Z" fill="#75DB6D"/>
                </svg>

            </div>

                <p>
                    <button v-on:click="addNewUser">REGISTER IN PHOTOHUB</button>
                </p>

                <div v-if="errors.length">
                    <ul>
                        <li v-for="error in errors" :key="error">{{ errors }}</li><br>
                    </ul>
                </div>
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
                password:null,
                confirm_name:false,
                confirm_password:false,
                confirm_email: false,
                confirm_repass:false,

            }
        },
        computed:{
            confirm_name:function() {
                if (this.name) {
                    this.confirm_name = true;
                }
            },
            confirm_email:function() {
                if (this.email) {
                    this.confirm_email = true;
                }
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


                axios.post("/api/user/registration", {
                    name: this.name,
                    email: this.email,
                    password: this.password
                }).then(response => {
                    if (response.status === 200) {
                        this.users.push({name: this.name, email: this.email,password: this.password}),
                        alert('Success'),
                        this.$router.push("/authenticate")
                    }
                }).catch(error=>{
                    this.errors.push(error.response.data.message)
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
    .wrapper{
        margin-top: 10%;
        margin-left: 20%;
        margin-right: 5%;
        height: 400px;
        width:840px;
    }
    .form_reg h1 {
        font-family: Sedgwick Ave;
        align-items: center;
        text-align: center;
        color: #FFC800;
        font-size: 35px;
        margin-top: 30px;
    }

    ul {
        list-style-type: none;
        padding: 0;
        color:red;
    }

    li {
        margin: 10px;
    }
    .form_reg button{
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
        height: 35px;
        margin: 5% 0% 0% 0%;
        padding: 5px;
        display: inline-block;
    }

    .form_reg input {
        background: #FFFFFF;
        border: 1px solid rgba(1, 28, 64, 0.25);
        box-sizing: border-box;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        width: 250px;
        height: 35px;
        margin: 5% 10% 0% 0%;
        padding: 10px;
        display: inline-block;


    }

    input::-webkit-input-placeholder {
        color: rgba(0, 0, 0, 0.25);;
        font-size: 18px;
        line-height: 21px;
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
    .form_reg{
        width: 450px;
        height: 500px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        margin:5% 1% 1% 1%;
        align-items: center;
        text-align: center;
    }
    .tick{
        display: inline-block;
    }

</style>