import axios from 'axios'

const API_URL = 'http://localhost:8080/api/users'

export default {
  getAllUsers() {
    return axios.get(`${API_URL}/all`)
  },
  createUser(user) {
    return axios.post(`${API_URL}/create`, user)
  },
  updateUser(id, user) {
    return axios.put(`${API_URL}/update/${id}`, user)
  },
  deleteUser(id) {
    return axios.delete(`${API_URL}/remove/${id}`)
  }
}