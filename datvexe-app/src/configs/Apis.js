import axios from "axios";
import cookies from 'react-cookies'

const SERVER_CONTEXT = '/DatVeXeBackend';
const SERVER = 'http://localhost:8080'
export const endpoint={
    'station':`${SERVER_CONTEXT}/api/station/`,
    'trip':`${SERVER_CONTEXT}/api/trip/`

}
export const authApi = () =>{
    return axios.create({
        baseURL:SERVER,
        headers:{
            'Authorization':cookies.load('token')
        }
    })
}

export default axios.create({
    baseURL:SERVER

})