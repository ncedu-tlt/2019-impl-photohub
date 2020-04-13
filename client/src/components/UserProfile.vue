<template>
    <div class="profile">
        <div class="header">
            <div class="header-wrapper">
                <div class="header_logo">
                    <img src="./../assets/Camera.png" height="32" width="37">
                    <span class="header_logo-text">PHOTOHUB</span>
                </div>
                <div class="header_user">
                    <span class="header_user-text">{{user.email}}</span>
                    <div class="containerAvatar">
                        <div class="avatar" v-if="avatar_show">
                            <img :src="avatar" style="width: 100%"/>
                        </div>
                        <div class="avatar" v-else>
                            <img src="./../assets/user.png" height="32" width="32">
                        </div>
                    </div>
                    <div class="menu" v-on:click="menu($event)">
                        <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M14.25 6.75L9 12L3.75 6.75" stroke="#262F56" stroke-width="1.8"
                                  stroke-linecap="round" stroke-linejoin="round"/>
                        </svg>
                    </div>
                    <div class="menu_show" v-if="menu_show">
                        <button v-on:click="mainPage">Main</button>
                        <button v-on:change="handleFileUpload($event)">Upload</button>
                        <button v-on:change="uploadAvatar($event)">Avatar</button>
                        <button v-on:click="exitMethods">Logout</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="feel">
            <div class="sidebar">
                <div class="ico_user">
                    <div class="avatarSide" v-if="avatar_show">
                        <img :src="avatar" style="width: 100%"/>
                    </div>
                    <div class="avatarSide" v-else>
                        <svg width="128" height="128" viewBox="0 0 128 128" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <ellipse cx="64" cy="34.6667" rx="24" ry="26.6667" fill="#FFC800"/>
                            <path d="M112 101.333C112 117.534 87.5642 112 64 112C40.4359 112 16 117.534 16 101.333C16 85.133 40.4359 72 64 72C87.5642 72 112 85.133 112 101.333Z"
                                  fill="#FFC800"/>
                        </svg>
                    </div>
                </div>
                <p style="font-size: 18px;">{{user.email}}
                </p>
                <div class="separator_top"></div>
                Subscribers<br>
                <div class="sub_ico" v-if="sub_show">
                    <div class="postMain" v-for="subscribe in subscribers" :key="subscribe">
                    <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <ellipse cx="16" cy="8.66667" rx="6" ry="6.66667" fill="#FFC800"/>
                        <path d="M28 25.3333C28 29.3834 21.891 28 16 28C10.109 28 4 29.3834 4 25.3333C4 21.2832 10.109 18 16 18C21.891 18 28 21.2832 28 25.3333Z"
                              fill="#FFC800"/>
                    </svg>
                        {{subscribe}}
                    </div>
                </div>
                <div class="sub_name" v-else>
                    No followers
                </div>
                <div class="separator_top"></div>
                Archive<br>
              <div class="archive_ico" v-if="archive_show">
                  <div v-for="archives in archive" :key="archives">
                      <img :src="archives"/>
                  </div>
              </div>
              <div class="archive_ico" v-else>
                  You have no archived photos
              </div>
          </div>
            <div class="content">
                <form class="search-form">
                    <input type="search" value="" placeholder="Search" class="search-input">
                </form>
                <div class="container">
                    <div class="post" v-for="image in images" :key="image">
                        <div class="postContent">
                            <img :src="image"/>
                        </div>
                    </div>
                </div>
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
                    posts:[],
                    images:[],
                    archive:[],
                    subscribers:[],
                    avatar:"",
                    likes:"",
                    user: {
                        email: ls.get('photohubUser')
                    },
                    menu_show:false,
                    avatar_show:false,
                    archive_show:false,
                    likeOn:false,
                    sub_show:false,
                }
            },
            created: function (){
            axios.get("/api/image/get?email=" + this.user.email)
                .then(response=>{
                    this.images=response.data.images;
                    this.likes=response.data.likes;
                    this.likeOn=response.data.likeOn;
                });
            axios.get("/api/image/get/avatar?email="+this.user.email)
                .then(response=>{
                    this.avatar_show=true;
                    this.avatar=response.data.avatar;
                });
            axios.get("/api/user/get/subscribe?email="+this.user.email)
                .then(response=>{
                    this.sub_show=true;
                    this.name=response.subscribers;
                });
            },


        methods: {
            menu:function(){
                this.menu_show=!this.menu_show;
            },
            mainPage:function(){
                this.$router.push("/main");
            },
            exitMethods:function(){
                ls.remove("photohubUser");
                this.$router.push("/authenticate");
            },
            handleFileUpload(e) {
                const files = e.target.files || e.dataTransfer.files;
                if (!files.length)
                    return;
                const file = files[0];
                const reader = new FileReader();
                reader.addEventListener("load", () => {
                    axios.post("/api/image/upload", {
                        email: ls.get('photohubUser'),
                        base64: reader.result
                    }).then(response => {
                        if (response.status === 200) {
                            this.$router.push('/');
                        }
                    })
                });
                if (/\.(jpe?g|png|gif)$/i.test(file.name)) {
                    reader.readAsDataURL(file);
                }
            },
            uploadAvatar(e) {
                const files = e.target.files || e.dataTransfer.files;
                if (!files.length)
                    return;
                const file = files[0];
                const reader = new FileReader();
                reader.addEventListener("load", () => {
                    axios.post("/api/image/upload/avatar", {
                        email: ls.get('photohubUser'),
                        base64: reader.result
                    }).then(response => {
                        if (response.status === 200) {
                            this.avatar_show=true;
                            this.avatar=reader.result;
                        }
                    })
                });
                if (/\.(jpe?g|png|gif)$/i.test(file.name)) {
                    reader.readAsDataURL(file);
                }
            }
        }
    };
    export default UserProfile

</script>

<style>
    @import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;1,500&display=swap");
    @import url("https://fonts.googleapis.com/css2?family=Sedgwick+Ave&display=swap");
    .header_user button{
        outline: none;
        border: 0;
        background: transparent;
    }
    .profile {
        width: 100%;
       }
    .feel{
        margin: 0 auto;
        width: 1000px;
    }
    .header{
        background: #ffc800;
        height: 80px;
        display: flex;
    }
    .header-wrapper {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        width: 1220px;
        margin: 0 auto;
    }
    .header_user {
        display: flex;
        flex-direction: row;
        align-items: center;
        position: relative;
    }
    .header_user-text {
        font-family: Roboto, monospace;
        font-size: 18px;
        font-weight: 600;
        margin-right: 10px;
    }
    .header_logo {
        align-items: center;
        flex-direction: row;
        display: flex;
    }
    .header_logo-text {
        font-family: Sedgwick Ave, monospace;
        font-size: 36px;
        font-weight: 600;
        margin-left: 10px;
    }
    .menu_show{
        width: 120px;
        background: #fff;
        border-radius: 10px;
        position: absolute;
        text-align: center;
        z-index: 100;
        right: 0;
        transform: translateY(70%);
    }

    .menu_show button {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 15px;
        color: #000000;
        cursor: pointer;
        position: relative;
        outline: 0;
        z-index: 2;
        width: 120px;
        margin-top: 10px;
        padding: 5px;
        display: inline-block;
    }
    .menu_show button:last-child {
        margin-bottom: 10px;
    }
    .menu_show button:hover {
        background-color: #ffe380;
    }
    .sidebar {
        float: left;
        width: 200px;
        height: 600px;
        background: #FFFFFF;
        padding: 1% 1% 1% 1%;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        margin-top: 40px;
    }
    .content {
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float: left;
        margin-bottom: 10px;
        margin-left: 1%;
        padding: 1% 1% 1% 1%;
        min-height: 580px;
        margin-top: 40px;
    }
    .content button {
        color: #ffffff;
        text-shadow: 0 0 1px rgb(1, 1, 1);
        cursor: pointer;
        position: relative;
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        width: 35px;
        height: 35px;
        margin: 20px 5% 0% 0%;
        padding: 5px;
        display: inline-block;
        float: left;
        margin-left: 5%;
    }
    .sidebar p {
        font-family: "Sedgwick Ave";
        color: rgb(0, 0, 0);
        font-weight: 700;
        margin: 5% 1% 1% 8%;
        font-size: 18px;
        line-height: 21px;
        display: flex;
    }
    .container {
        width: 750px;
    }
    .post {
        margin-bottom: 35px;
        width: 600px;
        height: 580px;
        border: 3px solid #a3a1a6;
        margin-left: 10%;
        border-radius: 30px;
        padding-left: 5px;
        text-align: center;
        padding-top: 5%;
    }
    .postContent{
        text-align: center;
    }
    .postContent img{
        width: 550px;
        height: 500px;
    }
    .postFooter{
        margin: auto;
    }
    .postFooter button{
        color: #000000;
        text-shadow: 0 0 1px rgb(1,1,1);
        cursor: pointer;
        position: relative;
        border-radius: 100px;
        outline: 0;
        z-index: 2;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        padding: 5px;
        display: inline-block;
    }
    .container img {
        width: 550px;
        height: 500px;
    }
    .post like {
        float: bottom;
        float: left;
    }
    div.upload_photo input:hover {
        background-color: #ffe380;
    }
    .menu_show input[type="file" ] {
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0.01;
        cursor: pointer;
    }
    div.menu_show input:hover {
        background-color: #ffe380;
    }
    .sidebar .separator_top {
        display: flex;
        align-items: center;
        text-align: center;
        margin: 5% 3% 3% 3%;
    }
    .sidebar .separator_top::before, .separator_top::after {
        content: '';
        flex: 1;
        border-bottom: 1px solid #000;
    }
    .ico_user {
        text-align: center;
        width: min-content;
        border-radius: 100px;
        border: 1px solid rgb(52, 56, 61);
        margin-left: 13%;
        margin-top: 3%;
    }
    .containerAvatar {
        text-align: center;
        width: min-content;
        border-radius: 100px;
        margin-right: 10px;
    }
    .archive_ico {
        margin: 1% 1% 1% 3%;
        padding: 2% 1% 1% 2%;
        display: inline-block;
    }
    .sub_ico {
        border-radius: 100px;
        border: 1px solid rgb(52, 56, 61);
        width: 18%;
        margin: 4% 7% 4% 4%;
        padding: 2% 1% 1% 2%;
        display: inline-block;
    }
    .sub_name {
        width: 18%;
        margin: 4% 7% 4% 4%;
        padding: 2% 1% 1% 2%;
    }
    .search-form {
        position: relative;
        top: 50%;
        left: 50%;
        width: 680px;
        height: 40px;
        border-radius: 40px;
        box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
        transform: translate(-50%, -50%);
        background: #fff;
        transition: all 0.3s ease;
        margin-bottom: 5%;
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
    .avatar {
        height: 32px;
        width: 32px;
        overflow: hidden;
        border-radius: 100px;
    }
    .avatarSide {
        height: 128px;
        width: 128px;
        overflow: hidden;
        border-radius: 100px;
    }
</style>