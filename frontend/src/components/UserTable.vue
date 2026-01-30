<template>
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>DOB</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
       <tr v-if="users.length === 0">
    <td colspan="5">No users found</td>
  </tr>

      <tr v-for="(u, index) in users" :key="index">
        <td>{{ u.fullName }}</td>
        <td>{{ u.email }}</td>
        <td>{{ u.mobileNumber }}</td>
        <td>{{ u.dateOfBirth }}</td>
        <td>
          <div class="action-buttons">
          <button @click="$emit('editUser', u)">Edit</button>
          <button @click="$emit('deleteUser', index)">Delete</button>
          </div>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props: ['users']
}
</script>


<style>
table {
  width: 80%;
  margin: 20px auto;
  border-collapse: collapse;
  background: white;
  font-family: Arial, sans-serif;
}

th {
  background-color: #f9f9f9;
  font-weight: bold;
}
td:nth-child(4),
th:nth-child(4) {
  white-space: nowrap;
  min-width: 110px;
}

th, td {
  border: 1px solid #999;
  padding: 10px 20px;
  text-align: center;
}

tbody tr td[colspan="5"] {
  text-align: center;
  font-style: italic;
  color: #555;
}

td button {
  margin: 0 5px;
  padding: 5px 12px;
  border: none;
  color: white;
  cursor: pointer;
  border-radius: 3px;
  font-size: 14px;
}

.action-buttons {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
}

tbody tr td[colspan="5"] {
  text-align: center;
  font-style: italic;
  color: #555;
}

td:last-child {
  justify-content: center;
  align-items: center;
  gap: 10px;            
}

td button {
  padding: 6px 14px;
  border: none;
  color: white;
  cursor: pointer;
  border-radius: 4px;
  font-size: 14px;
  min-width: 70px;      
}

table td button:first-child {
  background-color: #f18411;
}

table td button:last-child {
  background-color: #e53935;
}
</style>