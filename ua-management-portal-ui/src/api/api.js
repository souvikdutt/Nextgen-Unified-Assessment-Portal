import axios from 'axios';

const BASE_URL = 'http://localhost:8008';

export const fetchAllMentors = () => {
    return axios({
        method:'GET',
        url:`${BASE_URL}/mentor/available`
    })
}