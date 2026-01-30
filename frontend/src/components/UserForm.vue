<template>
  <form @submit.prevent="submitForm">
    <h3>{{ editUser ? 'Update User' : 'Register User' }}</h3>

    <input v-model="user.fullName" placeholder="Full Name" required />
    <input v-model="user.email" placeholder="Email" type="email" required />
    <input v-model="user.mobileNumber" placeholder="Mobile Number"  @input="allowNumbersOnly" pattern="\d{10}" title="Mobile number must be 10 digits" required />
    <input type="password" v-model="user.password" placeholder="Password"  minlength="6" required />
    <input type="date" v-model="user.dateOfBirth" placeholder="dd-mm-yyyy" required />
    <button class="register-btn" type="submit">{{ editUser ? 'Update' : 'Register' }}</button>
    <button v-if="editUser" type="button" class="back-btn" @click="cancelEdit">Back</button>
  </form>
</template>

<script>
export default {
  props: ['editUser'],
  data() {
    return {
      user: { fullName: '', email: '', mobileNumber: '', password: '', dateOfBirth: '' },
      errors: {}
    }
  },
  watch: {
    editUser(val) {
      if (val) this.user = { ...val }
    }
  },
  methods: {
    allowNumbersOnly() {
    this.user.mobileNumber = this.user.mobileNumber.replace(/\D/g, '')
  },

    validate() {
      this.errors = {}
      if (!this.user.fullName) this.errors.fullName = "Full Name is required"

      if (!this.user.email.trim()) {
      this.errors.email = "Email is required"
    } else if (!/^\S+@\S+\.\S+$/.test(this.user.email)) {
      this.errors.email = "Invalid email format"
    }
     
       if (!this.user.mobileNumber.trim()) {
      this.errors.mobileNumber = "Mobile number is required"
    } else if (!/^\d{10}$/.test(this.user.mobileNumber)) {
      this.errors.mobileNumber = "Mobile number must be 10 digits"
    }

       if (!this.user.password) {
      this.errors.password = "Password is required"
    } else if (this.user.password.length < 6) {
      this.errors.password = "Password must be at least 6 characters"
    }

    if (!this.user.dateOfBirth) {
      this.errors.dateOfBirth = "Date of Birth is required"
    }

    return Object.keys(this.errors).length === 0
    },

    cancelEdit() {
      this.$emit('cancelEdit')
      this.user = { fullName: '', email: '', mobileNumber: '', password: '', dateOfBirth: '' }
    },

    submitForm() {
      if (this.validate()) {
        // Emit user to parent
        this.$emit(this.editUser ? 'updateUser' : 'registerUser', { ...this.user })
        this.user = { fullName: '', email: '', mobileNumber: '', password: '', dateOfBirth: '' }
      }
    }
  }
}
</script>

<style>
form{
    background: #e3e3e3;
    padding:40PX;
    border-radius: 8PX;
    width: 700px;
  margin: 0 auto 30px auto;
}

form h3 {
  color: #4169E1;
   text-align: center;
  margin-bottom: 25px;
  font-size: 22px;
  font-weight: bold;
}

input {
  width: 100%;
  margin-bottom: 12PX;
  padding: 10PX;
   border: 1px solid #bbb;
  border-radius: 4px;
}

span {
  color: red;
  font-size: 12px;
  display: block;
  margin-bottom: 10px;
  text-align: center;
}

.register-btn {
    display: block;
  margin: 20PX auto 0 auto;
  padding: 10px 25px;
  color: #fff;         
  background-color: #4caf50; 
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.back-btn {
  display: block;
  margin: 10px auto 0 auto;
  padding: 8px 20px;
  color: #fff;
  background-color: #f44336;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>


