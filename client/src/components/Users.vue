<template>
    <div>
        <h3>Users stored in database</h3>
        <ul>
            <li v-for="user in users"
                :key="user.id">
                {{user.name}}
            </li>
        </ul>
    </div>
</template>

<script>
    import axios from "axios"

    const Users = {
        name: "Users",

        data: function () {
            return {
                users: []
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
        }
    };

    export default Users
</script>

<style scoped>
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
</style>