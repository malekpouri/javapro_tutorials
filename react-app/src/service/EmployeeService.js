import axios from "axios";

const API_URL = "http://localhost:9191/api/employee/";
const EMPLOYEE_ID = "2"

class EmployeeService {
  async getEmployeeDetails() {
      try {
            const response = await axios.get(API_URL + EMPLOYEE_ID);
            return response.data;
      }catch (error) {
            console.error("Error fetching employee details:", error);
            throw error;
      }
  }
}

export default new EmployeeService();