<template>
        <div class="wrapper">
            <notifications classes="my-style"/>
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
                    <div class="ico"><svg width="12" height="22" viewBox="0 0 12 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.563 0.00457747L8.7857 0C5.66554 0 3.64916 2.12509 3.64916 5.41423V7.91055H0.856742C0.615444 7.91055 0.420044 8.1115 0.420044 8.35937V11.9763C0.420044 12.2241 0.615667 12.4249 0.856742 12.4249H3.64916V21.5514C3.64916 21.7993 3.84455 22 4.08585 22H7.72916C7.97046 22 8.16586 21.799 8.16586 21.5514V12.4249H11.4308C11.6721 12.4249 11.8675 12.2241 11.8675 11.9763L11.8689 8.35937C11.8689 8.24036 11.8228 8.12638 11.741 8.04215C11.6592 7.95793 11.5478 7.91055 11.432 7.91055H8.16586V5.79439C8.16586 4.77727 8.40181 4.26094 9.69162 4.26094L11.5625 4.26025C11.8036 4.26025 11.999 4.0593 11.999 3.81166V0.453169C11.999 0.205757 11.8038 0.00503522 11.563 0.00457747Z" fill="black"/>
                    </svg>
                    </div>
                    <div class="ico"><svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.2111 9.50277H21.0865C21.1955 10.1112 21.25 10.6924 21.25 11.2463C21.25 13.2168 20.8368 14.9762 20.0105 16.5245C19.1841 18.0728 18.0059 19.2828 16.4757 20.1546C14.9456 21.0264 13.1908 21.4622 11.2111 21.4622C9.78544 21.4622 8.42785 21.1875 7.13837 20.6381C5.84889 20.0888 4.73649 19.3464 3.80116 18.4111C2.86584 17.4757 2.12348 16.3633 1.57409 15.0739C1.0247 13.7844 0.75 12.4268 0.75 11.0011C0.75 9.57541 1.0247 8.21783 1.57409 6.92835C2.12348 5.63887 2.86584 4.52647 3.80116 3.59114C4.73649 2.65581 5.84889 1.91346 7.13837 1.36406C8.42785 0.814673 9.78544 0.539978 11.2111 0.539978C13.9354 0.539978 16.2737 1.4526 18.2261 3.27785L15.3792 6.01572C14.2623 4.9351 12.8729 4.39479 11.2111 4.39479C10.0397 4.39479 8.95681 4.68992 7.96246 5.28018C6.96811 5.87043 6.18034 6.67181 5.59917 7.68433C5.018 8.69684 4.72741 9.80243 4.72741 11.0011C4.72741 12.1998 5.018 13.3054 5.59917 14.3179C6.18034 15.3304 6.96811 16.1318 7.96246 16.722C8.95681 17.3123 10.0397 17.6074 11.2111 17.6074C12.0012 17.6074 12.7276 17.4984 13.3905 17.2805C14.0534 17.0626 14.5983 16.7901 15.0251 16.4632C15.4519 16.1363 15.8242 15.764 16.142 15.3463C16.4599 14.9286 16.6937 14.5336 16.8435 14.1612C16.9934 13.7889 17.0955 13.4348 17.15 13.0988H11.2111V9.50277Z" fill="black"/>
                    </svg>
                    </div>
                    <div class="ico"><svg width="22" height="18" viewBox="0 0 22 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M21.5 2.77252C20.7271 3.10045 19.8978 3.32285 19.0264 3.42215C19.9161 2.91199 20.5972 2.10281 20.92 1.14158C20.0854 1.61402 19.1642 1.95706 18.1826 2.14303C17.3966 1.34013 16.2785 0.840027 15.0384 0.840027C12.6593 0.840027 10.7303 2.68709 10.7303 4.96388C10.7303 5.28679 10.7683 5.60217 10.8418 5.90376C7.26201 5.73159 4.08768 4.08935 1.96314 1.59391C1.59176 2.20207 1.38049 2.91071 1.38049 3.66715C1.38049 5.09833 2.14161 6.36111 3.2964 7.09991C2.5904 7.07731 1.92639 6.89134 1.34508 6.58223V6.63375C1.34508 8.63159 2.83056 10.299 4.80024 10.6785C4.43936 10.7714 4.05882 10.823 3.66514 10.823C3.38696 10.823 3.11794 10.7966 2.85417 10.7463C3.40267 12.386 4.99315 13.5785 6.87756 13.6111C5.40388 14.7169 3.54573 15.374 1.52749 15.374C1.17976 15.374 0.837236 15.3539 0.5 15.3175C2.40671 16.4898 4.67036 17.1734 7.10327 17.1734C15.028 17.1734 19.3597 10.8883 19.3597 5.4376L19.3453 4.90359C20.1917 4.32555 20.9239 3.59931 21.5 2.77252Z" fill="black"/>
                    </svg>
                    </div>
                </div>


            </div>

            <div class="error" v-if="errors.length">
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
                    this.$notify({ group: 'foo', text: 'Enter user email' })
                } else if (!this.validateEmail(this.email)) {
                    this.$notify({ group: 'foo', text: 'Enter valid email address' })
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
                        this.$notify({ group: 'foo', text: 'User not found, please try again' })
                    }
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
        margin:5% auto;
        max-width: 850px;

    }
    errors{
        font-color:red;
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
        margin-left:2%;
        width: 350px;
        height: 375px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        margin-bottom: 40px;
    }
    .reg_feed{
        font-family: Roboto;
        margin-left:2%;
        width: 350px;
        height: 109px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        text-align: center;
    }
    .error{
        text-align: center;
        float:right;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        width: 350px;
        margin-bottom: 40px;

    }
    .content_feed{
        width: 450px;
        height: 550px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
    }
    .ico{
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 100%;
        background: #FFC800;
        width: 35px;
        height: 30px;
        display: inline-block;
        margin: 20px 15px 20px 25px;
        text-align: center;
        vertical-align: middle;
        padding-top: 8px;
    }
</style>