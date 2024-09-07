import axios from "axios";
import cookies from 'react-cookies'

const SERVER_CONTEXT = '/DatVeXeBackend';
const SERVER = 'http://localhost:8080'
export const endpoint={
    'station':`${SERVER_CONTEXT}/api/station/`,
    'trip':`${SERVER_CONTEXT}/api/public/trip/`,
    'trip-detail':(tripId) =>`${SERVER_CONTEXT}/api/public/tripDetail/${tripId}`,

    //kiểm tra đăng nhập trước khi gọi api này
    'get-orders':`${SERVER_CONTEXT}/api/viewOrders`,
    'get-tickets':(orderID) =>`${SERVER_CONTEXT}/api/viewTicket/${orderID}`,
    'add-order':(tripId) =>`${SERVER_CONTEXT}/api/addOrder/${tripId}`,
    'check-payment':`${SERVER_CONTEXT}/api/checkPaySuccess`,
    

    'login':`${SERVER_CONTEXT}/api/public/login/`,
    'register':`${SERVER_CONTEXT}/api/public/register/`,
    'forgotPassword':`${SERVER_CONTEXT}/api/public/forgotPassword/`

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