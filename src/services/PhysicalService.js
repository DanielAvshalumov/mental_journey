import axios from "axios";

const base = "http://localhost:8080/api/physical/"

class PhysicalService {

    createPhysical(id) {
    }

    getPhysical(id) {
        return axios.get(base+`${id}`, {headers:{'Content-Type':'application/json'}});
    }
}

export default new PhysicalService();