
<template>
     <div class="wrapper">
      <div id="header"><h1>User: {{user.email}}</h1></div>
      <div id="sidebar">
        <p>avatar</p>
      </div>
          <div id="content">
            <h2>Лента(фоточки будут здесь)</h2>
                <div class="container">
                    <div>
                        <div class="post">
                            <img v-for="image in images" :key="image" :src="image"/>
                            <button v-on:click="like" style="width: 35px;">♥</button>:{{likes}}
                        </div>
                        <button v-on:click="subscribe">Subscribe</button>
                        <div v-for="subscribe in subscribers" :key="subscribe" >
                            {{subscribe}} <button v-on:click="sign">Subscribe</button>
                        </div>
                    </div>

                    <label>
                        <input type="file" id="file" ref="file" accept="image/*" :width="500" :height="500" v-on:change="handleFileUpload()"/>
                    </label>
                </div>
          </div>
      <div id="footer">project by netcracker</div>
         <div class="buttonExit">
             <button v-on:click="exitMethods">Exit</button>
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
                    this.images=response.images;
                    this.likes=response.likes;
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
    .image-container {
        height: 330px;
        background-repeat: no-repeat;
        background-position: center center;
        background-size: cover;
    }
    .likes {
        margin: 5px 0;
/*
        margin-bottom: 5px !important;
*/
        font-size: 0.85rem;
        font-weight: bold;
    }
    div.post{

    }
    div.container img{
        max-width: 200px;
        max-height: 200px;
      }
    wrapper {
        width: 600px;
        margin-left: 200px;
        margin-top: 100px;
       }
   h1 {
    font-size: 36px;
    margin: 0;
    color: #ffaa2a;
   }
   h2 {
    margin-top: 0;
   }
   #header {
    background: rgb(0,0,0);
    padding: 10px;
   }
   #sidebar {
    float: left;
    border: 1px solid #333;
    width: 20%;
    padding: 5px;
    margin: 10px 10px 20px 5px;
   }
   #content {
    margin: 10px 5px 20px 25%;
    padding: 5px;
    border: 1px solid #333;
   }
   #footer {
    background: #333;
    padding: 5px;
    color: #fff;
    clear: left;
   }
     input[type="file" ] {
         z-index: 1;
         width: 245px;
         padding-right: 10px;
         white-space: nowrap;
         text-overflow: ellipsis;
         border: 1px solid #34383d;
         background: #1c1e21;
         color: #c0c0c0;
         -o-text-overflow: ellipsis;
         padding: 5px 15px;
         border-radius: 5px;
    }
    button{
        color: rgb(192, 192, 192);
        text-shadow: 0 0 10px rgb(255, 255, 255);
        cursor: pointer;
        display: block;
        position: relative;
        width: 100px;
        height: 35px;
        color: rgb(192, 192, 192);
        border-radius: 10px;
        outline: 0;
        z-index: 2;
        background: rgb(28, 30, 33);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        border: 6px solid rgb(52, 56, 61);
        font-size: 15px;
        text-indent: 0px;
        margin: 10px 10px 20px 5px;
    }
    input[type=file]::-webkit-file-upload-button {
        color: rgb(192, 192, 192);
        text-shadow: 0 0 10px rgb(255, 255, 255);
        cursor: pointer;
        display: block;
        position: relative;
        width: 133px;
        height: 35px;
        color: rgb(192, 192, 192);
        border-radius: 10px;
        outline: 0;
        z-index: 2;
        background: rgb(28, 30, 33);
        box-shadow: inset -100px -100px 0 rgb(28, 30, 33);
        border: 6px solid rgb(52, 56, 61);
        font-size: 15px;
        text-indent: 0px;
        margin: 5px 5px 10px 0px;
    }
</style>