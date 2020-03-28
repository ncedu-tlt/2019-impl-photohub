<template>
     <div class="profile">
      <div class="header">
          <div class="header_logo">
              <h1><img src="./../assets/Camera.png" height="32" width="37">
                  PHOTOHUB</h1>
          </div>
          <div class="header_user">
              <h1>
                  {{user.email}}
                  <img src="./../assets/user.png" height="32" width="37">

              </h1>
          </div>
      </div>
         <div class="feel">
          <div class="sidebar">
              <div class="ico_user">
                  <svg width="128" height="128" viewBox="0 0 128 128" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <ellipse cx="64" cy="34.6667" rx="24" ry="26.6667" fill="#FFC800"/>
                      <path d="M112 101.333C112 117.534 87.5642 112 64 112C40.4359 112 16 117.534 16 101.333C16 85.133 40.4359 72 64 72C87.5642 72 112 85.133 112 101.333Z" fill="#FFC800"/>
                  </svg>
              </div>
              <p style="font-size: 24px;">{{user.email}}
              </p>
              <div class="separator_top"></div>
              Subscribers
              <div class="sub_ico">
                  <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <ellipse cx="16" cy="8.66667" rx="6" ry="6.66667" fill="#FFC800"/>
                      <path d="M28 25.3333C28 29.3834 21.891 28 16 28C10.109 28 4 29.3834 4 25.3333C4 21.2832 10.109 18 16 18C21.891 18 28 21.2832 28 25.3333Z" fill="#FFC800"/>
                  </svg>
              </div>
              <div class="separator_top"></div>
              Archive
              <div class="archive_ico">
                  <svg width="50" height="50" viewBox="0 0 50 50" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M5.20825 18.3417C5.20825 16.6615 5.20825 15.8214 5.53523 15.1797C5.82285 14.6152 6.28179 14.1563 6.84628 13.8687C7.48802 13.5417 8.32809 13.5417 10.0083 13.5417H11.7977C12.8122 13.5417 13.3195 13.5417 13.7731 13.3936C14.1745 13.2626 14.5437 13.0483 14.8566 12.7648C15.2103 12.4444 15.4619 12.004 15.9653 11.1231L16.8304 9.60908C17.5295 8.38567 17.8791 7.77396 18.3702 7.32894C18.8048 6.93519 19.3176 6.63761 19.8751 6.45565C20.5051 6.25 21.2097 6.25 22.6187 6.25H27.3811C28.7902 6.25 29.4947 6.25 30.1248 6.45565C30.6822 6.63761 31.195 6.93519 31.6296 7.32894C32.1208 7.77396 32.4703 8.38567 33.1694 9.60908L34.0346 11.1231C34.5379 12.004 34.7896 12.4444 35.1432 12.7648C35.4561 13.0483 35.8253 13.2626 36.2267 13.3936C36.6803 13.5417 37.1876 13.5417 38.2021 13.5417H39.9916C41.6717 13.5417 42.5118 13.5417 43.1536 13.8687C43.718 14.1563 44.177 14.6152 44.4646 15.1797C44.7916 15.8214 44.7916 16.6615 44.7916 18.3417V37.9083C44.7916 39.5885 44.7916 40.4286 44.4646 41.0703C44.177 41.6348 43.718 42.0937 43.1536 42.3814C42.5118 42.7083 41.6717 42.7083 39.9916 42.7083H10.0082C8.32809 42.7083 7.48802 42.7083 6.84628 42.3814C6.28179 42.0937 5.82285 41.6348 5.53523 41.0703C5.20825 40.4286 5.20825 39.5885 5.20825 37.9083V18.3417Z" stroke="black" stroke-opacity="0.25" stroke-width="3.75" stroke-linecap="round" stroke-linejoin="round"/>
                      <circle cx="25.0001" cy="28.125" r="8.33333" stroke="black" stroke-opacity="0.25" stroke-width="3.75"/>
                      <circle cx="38.0208" cy="20.3125" r="1.5625" stroke="black" stroke-opacity="0.25" stroke-width="3"/>
                  </svg>
              </div>
              <button v-on:click="exitMethods">Exit</button>
              <button v-on:click="subscribe">Subscribe</button>
              <div class="upload_photo">
                  Upload
                  <input type="file" id="file" ref="file" accept="image/*" :width="500" :height="500" v-on:change="handleFileUpload()"/>
              </div>
          </div>

          <div class="content">
              <form class="search-form">
                  <input type="search" value="" placeholder="Search" class="search-input">
              </form>
                <div class="container">
                    <div>
                        <div class="post" v-for="image in images" :key="image">
                            <img :src="image"/>
                            <button v-on:click="like" style="width: 35px;margin-top: 390px">
                                <img src="./../assets/like.png" height="24" width="24">
                            </button>:{{likes}}
                        </div>

                        <div v-for="subscribe in subscribers" :key="subscribe" >
                            {{subscribe}} <button v-on:click="sign">Subscribe</button>
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
                    likes:"",
                    subscribers:[],
                    user: {
                        email: ls.get('photohubUser')
                    },
                }
            },
            created: function (){
            axios.get("/api/image/get?email=" + this.user.email)
                .then(response=>{
                    this.images=response.data.images;
                    this.likes=response.data.likes;
                    console.log(response);
                })
            },

        methods: {
            like:function() {
                axios.post("", {
                    likes:this.likes++
                })
            },
            subscribe:function() {
                axios.post("")
                .then(response=>{
                    this.subscribers=response.subscribe;
                })
            },
            sign:function() {
                axios.post("",{
                    email: this.user.email
                })
                    .then(response=>{
                        if (response.status === 200) {
                            alert('Success')
                        }
                    })
            },

            exitMethods:function(){
                ls.remove("photohubUser");
                this.$router.push("/authenticate");
            },
            handleFileUpload() {
                const file = this.$refs.file.files[0];
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
            }
        }
    }
    export default UserProfile

</script>

<style>

    div.post{

    }
    div.container img{
        max-width: 200px;
        max-height: 200px;
      }
    .profile {

       }
    .feel{
        margin: 5% 5% 1% 5%;
    }
    .header{
        height:100%;
        background: #FFC800;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        overflow: hidden;
        padding-left: 10px;
        padding-right: 30px;
        text-align: justify;




    }

    .header h1 {
        font-family: Sedgwick Ave;
        align-items: center;
        text-align: center;
        color: #000000;
        font-size: 35px;
        margin-top: 10px;
    }
     .sidebar{
         float:left;
         width: 280px;
         height: 600px;
         background: #FFFFFF;
         padding-left: 20px;
         box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
         border-radius: 10px;

     }
    .content{
        width: 600px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        margin-bottom: 40px;
        margin-left: 2%;
        padding: 1% 4% 1% 4%;
        min-height: 580px;
    }
    .sidebar button{
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
        width: 100px;
        margin:20px 5% 0% 0%;
        padding: 5px;
        display: inline-block;
    }
    .content button{
        color: #ffffff;
        text-shadow: 0 0 1px rgb(1,1,1);
        cursor: pointer;
        position: relative;
        border-radius: 50px;
        outline: 0;
        z-index: 2;
        border: 1px solid rgb(52, 56, 61);
        background: #ffc800;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
        width: 25px;
        margin:20px 5% 0% 0%;
        padding: 5px;
        display: inline-block;
    }
    .sidebar p{
        color: rgb(0, 0, 0);
        padding: 1px 20px;
        font-weight: 700;
        margin: 5px 0 0 0;
        font-size: 18px;
        line-height: 21px;
        display: flex;
    }

    .post{
        align-content: center;
        width: 250px;
        height: 250px;
        background: #FFFFFF;
        border-radius: 10px;
        margin-bottom: 15px;

    }
    .post like{
        float:bottom;
    }
    .header header_uesr{
        float: right;

    }
    .header header_logo{
        float: left;

    }
    .upload_photo{
        font-size: 15px;
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
        width: 90px;
        margin:20px 5% 0% 0%;
        height: 15px;
        padding: 5px;
        display: inline-block;
        text-align: center;
    }
    .sidebar input[type="file" ] {
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0.01;
        cursor: pointer;
    }
    .separator_top{
        display: flex;
        align-items: center;
        text-align: center;
        margin:20px 20px 1px 0px;
    }
    .separator_top::before, .separator_top::after {
        content: '';
        flex: 1;
        border-bottom: 1px solid #000;
    }
    .ico_user{
        text-align: center;
        border-radius: 100px;
        border: 1px solid rgb(52, 56, 61);
        width: 50%;
        margin-left: 25%;
    }
    .sub_ico{
        border-radius: 100px;
        border: 1px solid rgb(52, 56, 61);
        width: 13%;
        margin:1% 1% 1% 1%;
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
        margin-bottom:5% ;

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