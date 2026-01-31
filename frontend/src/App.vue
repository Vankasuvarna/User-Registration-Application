<template>
  <div class="container">
    <h2>User Registration Form</h2>

    <UserForm
      :editUser="editUser"
      @registerUser="addUser"
      @updateUser="updateUser"
      @cancelEdit="editUser = null"
    />

    <UserTable
      v-if="!editUser"
      :users="users"
      @editUser="setEditUser"
      @deleteUser="deleteUser"
    />
  </div>
</template>

<script>
import UserForm from './components/UserForm.vue'
import UserTable from './components/UserTable.vue'
import UserService from './services/UserService.js'

export default {
  components: { UserForm, UserTable },

  data() {
    return {
      users: [],
      editUser: null
    }
  },

  async created() {
    await this.fetchUsers()
  },

  methods: {
    async fetchUsers() {
      try {
        const response = await UserService.getAllUsers()
        this.users = response.data
      } catch (error) {
        console.error("Error fetching users:", error)
      }
    },

    async addUser(user) {
      try {
        const response = await UserService.createUser(user)
        this.users.push(response.data)
        alert("User registered successfully!")
      } catch (error) {
        console.error("Create user failed:", error)
        alert("Failed to register user")
      }
    },

   async updateUser(userData) {
  try {
    const response = await UserService.updateUser(this.editUser.id, userData)
    const index = this.users.findIndex(u => u.id === this.editUser.id)
    this.users.splice(index, 1, response.data)
    this.editUser = null
    alert("User updated successfully")
  } catch (error) {
    console.error("Update failed:", error)
    alert("Update failed")
  }
},

  async deleteUser(index) {
  const user = this.users[index]
  if (confirm(`Delete ${user.fullName}?`)) {
    try {
      await UserService.deleteUser(user.id)
      this.users.splice(index, 1)
      alert("User deleted successfully")
    } catch (error) {
      console.error("Delete failed:", error)
      alert("Delete failed")
    }
  }
},

    setEditUser(user) {
      this.editUser = user
    }
  }
}

</script>

<style>
.container {
  max-width: 900px;
  margin: 30px auto;
}
.container h2 {
  color: #4169E1;
  text-align: center;
  margin-bottom: 30px;
  font-size: 28px;
  font-weight: bold;
}
</style>