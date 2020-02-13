<template>
    <div class="users-container">
        <div class="column">
            <h3>Users stored in database</h3>
            <ul>
                <li v-for="user in users"
                    :key="user.id">
                    {{user.name}}
                </li>
            </ul>
        </div>
        <div class="column">
            <h3>Form for entering new user</h3>
            <p>
                <label for="name">Name</label>
                <input id="name" v-model="name" type="text" name="name">
            </p>
            <p>
                <label for="email">Email</label>
                <input id="email" v-model="email" type="email" name="email">
            </p>
            <p>
                <button v-on:click="addNewUser">Create user</button>
            </p>
            <p v-if="errors.length">
                <b>Please fix next errors:</b>
                <ul>
                    <li v-for="error in errors" :key="error">{{ error }}</li>
                </ul>
            </p>
        </div>
    </div>
</template>

<script>
    import axios from "axios"

    const Users = {
        name: "Users",

        data: function () {
            return {
                users: [],
                errors: [],
                name: null,
                email: null
            }
        },

        mounted() {
            axios.get("/demo/all")
                .then(response => {
                    this.users = response.data
                })
                .catch(error => {
                    console.error(error);
                })
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

                axios.post("/demo/add", {
                    name: this.name,
                    email: this.email
                }).then(response => {
                    console.log(response);
                    this.users.push({name: this.name, email: this.email})
                }).catch(error => {
                    console.error(error)
                })
            },
            validateEmail: function (email) {
                const emailRegEx = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
                return emailRegEx.test(email);
            }
        }
    };

    export default Users
</script>

<style scoped>
    .users-container {
        display: flex;
        width: 50%;
        margin: 0 auto;
    }

    .column {
        flex: 50%;
    }

    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 10px;
    }

    label {
        margin-right: 10px;
    }
</style>