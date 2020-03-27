
<template>
     <div class="profile">
      <div class="header">
          <div class="header logo">
              <h1><img src="./../assets/Camera.png" height="32" width="37">
                  PHOTOHUB</h1>
          </div>
          <div class="header user">
              <h1><img src="./../assets/user.png" height="32" width="37"> {{user.email}}

              </h1>
          </div>
      </div>
         <div class="feel">
          <div class="slidebar">
            <p>Navigation</p>
              <button v-on:click="exitMethods">Exit</button>
              <button v-on:click="subscribe">Subscribe</button>
              <label>
                  <input type="file" id="file" ref="file" accept="image/*" :width="500" :height="500" v-on:change="handleFileUpload()"/>
              </label>
          </div>
          <div class="content">
            <h2>Лента</h2>
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
    .header{
        heigt:100%;
        background: #FFC800;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        overflow: hidden;
        padding-left: 10px;
        padding-right: 30px;
    }
    .feel {
        margin-top: 5%;
        margin-left: 5%;
        margin-right: 5%;

    }
     .logo{
        float:left;
         box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
    }
     .user{
        float:right;
         box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
    }
    .header h1 {
        font-family: Sedgwick Ave;
        align-items: center;
        text-align: center;
        color: #000000;
        font-size: 35px;
        margin-top: 10px;
    }
     .slidebar{
         float:left;
         width: 150px;
         height: 600px;
         background: #FFFFFF;
         padding-left: 20px;
         box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
         border-radius: 10px;
     }
    .content{
        width: 550px;
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        float:left;
        margin-bottom: 40px;
        margin-left: 2%;
        padding: 1% 4% 1% 4%;
    }
    .slidebar button{
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
        margin:20px 5% 1% 1%;
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
        margin:20px 5% 1% 1%;
        padding: 5px;
        display: inline-block;
    }
    .slidebar p{
        color: rgb(0, 0, 0);
        padding: 1px 20px;
        font-weight: 700;
        margin: 5px 0 0 0;
        font-size: 18px;
        line-height: 21px;
        display: flex;
        align-items: center;
    }
     .slidebar input[type="file" ] {
         white-space: nowrap;
         text-overflow: ellipsis;
         -o-text-overflow: ellipsis;
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
         margin:20px 5% 1% 1%;
         padding: 5px;
         display: inline-block;
    }
    .post{
        display: flex;
        align-content: center;
        width: 480px;
        height: 450px;
        background: #FFFFFF;
        padding-left: 20px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
        margin-bottom: 15px;
    }
    .post lile{
        float:bottom;
    }
</style>