<template>
     <div class="wrapper">
      <div id="header"><h1>User login</h1></div>
      <div id="sidebar">
        <p>avatar</p>
      </div>
          <div id="content">
            <h2>Лента(фоточки будут здесь)</h2>
                <div class="container">
                    <button v-on:click="uploadPhoto">Download</button>
                </div>
          </div>
      <div id="footer">чтобы было, вдруг че</div>
         <div class="buttonExit">
             <button v-on:click="exitMethods">Exit</button>
         </div>
     </div>

</template>

<script>
    import ls from "local-storage"
        const UserProfile = {
        name: "UserProfile",

        methods: {
            exitMethods:function(){
                ls.remove("photohubUser");
                this.$router.push("/authenticate");
            },
            uploadPhoto: function () {
                this.$router.push('/uploadWindow');
            }
        }
    }
    export default UserProfile

</script>

<style>
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