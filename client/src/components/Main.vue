<template>
     <div class="profile">
      <div class="headerMain">
          <div class="header_logo">
              <h1><img src="./../assets/Camera.png" height="32" width="37">
                  PHOTOHUB</h1>
          </div>
          <div class="header_user">
              <h1>
                  {{user.email}}
                  <div class="avatar" v-if="avatar_show">
                      <img :src="avatar" style="width: 100%"/>
                  </div>
                  <div class="avatar" v-else>
                      <img src="./../assets/user.png" height="32" width="32">
                  </div>
                  <button class="menu" v-on:click="menu"><svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M14.25 6.75L9 12L3.75 6.75" stroke="#262F56" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"/>
                  </svg>
                  </button>
                  <div class="menuShow" v-if="menu_show">
                      <button  v-on:click="mainPage">Profile</button>
                  </div>
              </h1>
          </div>
      </div>
          <div class="contentMain">
              <form class="search-form">
                  <input type="search" value="" placeholder="Search" class="search-input">
              </form>
                <div class="postMain" v-for="image in images" :key="image">
                    <div class="postHeader">
                        <h2>
                            {{image.email}}
                        </h2>
                        <button :key="image" v-on:click="subscribe">Subscribe</button>
                    </div>
                    <div class="postContent">
                        <img :src="image.base64"/>
                    </div>
                    <div class="postFooter">
                        <button v-on:click="like">
                            <img src="./../assets/like.png" style=" width:24px; height:24px">
                        </button>{{likes}}
                    </div>
                </div>

                <div v-for="subscribe in subscribers" :key="subscribe" >
                    {{subscribe}} <button v-on:click="sign">Subscribe</button>
                </div>
          </div>
     </div>
</template>

<script>
        import axios from "axios"
        import ls from "local-storage"
        const UserProfile = {
        name: "UserProfile",
            data: function () {
            return {
                    avatar:"",
                    posts:[],
                    images:[],
                    likes:"",
                    subscription:"",
                    user: {
                        email: ls.get('photohubUser')
                    },
                    emailUser:'',
                    menu_show:false,
                    myEmail:"",
                }
            },
            created: function (){
            axios.get("/api/contentfeed/get_content")
                .then(response=>{
                    this.images=response.data;
                });
            axios.get("/api/image/get/avatar?email="+this.user.email)
                .then(response=>{
                    this.avatar_show=true;
                    this.avatar=response.data.avatar;
                });
            },

        methods: {
            menu:function(){
                this.menu_show=!this.menu_show;
            },
            like:function() {
                axios.post("", {
                    likes:this.likes++
                })
            },
            mainPage:function () {
                this.$router.push("/");
            },
            subscribe:function () {
                axios.post("/api/subscribe", {
                    email: this.user.email,
                    subscription: this.image.email,
                }).then(response => {
                    if (response.status === 200) {
                        ls.set("photohubUser", this.email);
                        this.$router.push("/");
                    } else if (response.status === 404) {
                        this.$notify({ group: 'foo', text: 'User not found, please try again' })
                    }
                })
            }
        }
        };
    export default UserProfile

</script>

<style>
    @import url("https://fonts.googleapis.com/css2?family=Sedgwick+Ave&display=swap");
    @import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;1,500&display=swap");
    .header_user button{
        outline: none;
        border: 0;
        background: transparent;
    }
    .headerMain{
        height:100%;
        background: #FFC800;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        overflow: hidden;
        padding-left: 10px;
        padding-right: 30px;
    }

    .headerMain h1 {
        font-family: Sedgwick Ave;
        align-items: center;
        text-align: center;
        color: #000000;
        font-size: 35px;
        margin-top: 10px;

    }
    .contentMain{
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        margin-bottom: 10px;
        margin: 5% 0% 0% 15%;
        padding: 1% 1% 1% 1%;
        min-height: 580px;
        width: 800px;
    }

    .postMain{
        margin-bottom: 35px;
        width:600px;
        height: 650px;
        border: 3px solid #a3a1a6;
        margin-left: 10%;
        border-radius:30px;
        padding-left: 5px;
    }
    .postHeader{
        display: flex;
        margin-left: inherit;
        font-family: "Sedgwick Ave";
    }
    .postHeader button{
        color: #000000;
        text-shadow: 0 0 1px rgb(1,1,1);
        cursor: pointer;
        position: relative;
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        background: #FFC800;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        width: 85px;
        height: 30px;
        padding: 5px;
        display: inline-block;
        margin:auto;
    }
    .postContent{
        text-align: center;
    }
    .postContent img{
        width: 550px;
        height: 500px;
    }
    .postFooter button{
        color: #000000;
        text-shadow: 0 0 1px rgb(1,1,1);
        cursor: pointer;
        position: relative;
        border-radius: 100px;
        outline: 0;
        z-index: 2;
        background: #FFC800;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        padding: 5px;
        display: inline-block;
    }

    .contentMain img{
        width: 500px;
        height: 500px;
    }
    .contentMain like{
        float:bottom;
        float:left;
    }
    .header_logo{
        float: left;
        display: inline-block;
        margin-left: 5%;
    }

    .menuShow{
        position: absolute;
        width: 120px;
        height: 50px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        position: absolute;
        top: 7%;
        right:1%;
        left: 85%;
        text-align: center;
    }
    .menuShow button{
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 15px;
        color: #000000;
        cursor: pointer;
        position: relative;
        outline: 0;
        z-index: 2;
        width: 100px;
        margin:10px 0% 0% 0%;
        padding: 5px;
        display: inline-block;
    }
    div.menuShow button:hover {
        background-color: #ffe380;
    }
    .search-input {
        position: absolute;
        top: 10px;
        left: 38px;
        font-size: 14px;
        background: none;
        color: #5a6674;
        width: 600px;
        height: 20px;
        border: none;
        appearance: none;
        outline: none;
    }


</style>