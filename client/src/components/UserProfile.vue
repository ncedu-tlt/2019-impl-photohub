<template>
     <div class="wrapper">
      <div id="header"><h1>User login</h1></div>
      <div id="sidebar">
        <p>avatar</p>
      </div>
      <div id="content">
        <h2>Лента(фоточки будут здесь)</h2>
            <div class="container">
                <div class="large-12 medium-12 small-12 cell">
                  <label>File Preview
                    <input type="file" id="file" ref="file" accept="image/*" v-on:change="handleFileUpload()"/>
                  </label>
                  <img v-bind:src="imagePreview" v-show="showPreview"/>
                  <button v-on:click="submitFile()">Submit</button>
                </div>
              </div>
      </div>
      <div id="footer">чтобы было, вдруг че</div>
     </div>
</template>

<script>
import axios from "axios"
export default {
    data(){
      return {
        file: '',
        showPreview: false,
        imagePreview: ''
      }
    },
    methods: {
      submitFile(){
            let formData = new FormData();
            formData.append('file', this.file);
            axios.post( '/api/...',
                formData,
                {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
              }
            ).then(function(){
          console.log('SUCCESS!!');
        })
        .catch(function(){
          console.log('FAILURE!!');
        });
      },
      handleFileUpload(){
        this.file = this.$refs.file.files[0];
        let reader  = new FileReader();
        reader.addEventListener("load", function () {
          this.showPreview = true;
          this.imagePreview = reader.result;
        }.bind(this), false);
        if( this.file ){
          if ( /\.(jpe?g|png|gif)$/i.test( this.file.name ) ) {
            reader.readAsDataURL( this.file );
          }
        }
      }
    }
  }
</script>

<style>
div.container img{
    max-width: 200px;
    max-height: 200px;
  }
wrapper {
    width: 600;
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