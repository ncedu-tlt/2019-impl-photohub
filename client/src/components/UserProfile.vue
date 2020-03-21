
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
                            <button v-on:click="like">♥</button>:{{likes}}
                        </div>

                    </div>

                    <label>File Preview
                        <input type="file" id="file" ref="file" accept="image/*" :width="500" :height="500" v-on:change="handleFileUpload()"/>
                    </label>
                </div>
          </div>
      <div id="footer">чтобы было, вдруг че</div>
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
</style>