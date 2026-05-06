import {useEffect, useState} from "react";
import EmployeeService  from "../service/EmployeeService.js";
const EmployeeComponent = () => {
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState(null)
    const [employee, setEmployee] = useState({
        employee:{},
        department:{},
        organization:{}
    })

    useEffect(() => {
        fetchEmployee()
    }, []);

    const fetchEmployee = async () => {
        setLoading(true)
        setError(null)
        try{
            const response = await EmployeeService.getEmployeeDetails();
            console.log(response)
            setEmployee(response)
        }catch (error){
            setError("Error fetching employee details")
            console.error("Error fetching employee details:", error);
        }finally {
            setLoading(false)
        }
    };


    if (loading) {
        return <div>Loading...</div>;
    }
    if (error) {
        return <div>Error: {error.message}</div>;
    }


    return (
        <div>
            <div className="card">
                <div className="card-header">
                    Employee Details
                </div>
                <ul className="text-start list-group list-group-flush">
                    <li className="list-group-item"><strong>First Name :</strong> {employee.employee.firstName}</li>
                    <li className="list-group-item"><strong>Last Name :</strong> {employee.employee.lastName}</li>
                    <li className="list-group-item"><strong>Email :</strong> {employee.employee.email}</li>

                </ul>
                <div className="card-header">
                    View Department Details
                </div>
                <ul className="text-start list-group list-group-flush">
                    <li className="list-group-item"><strong>Department Name
                        :</strong> {employee.department.departmentName}</li>
                    <li className="list-group-item"><strong>Department Description
                        :</strong> {employee.department.departmentDescription}</li>
                    <li className="list-group-item"><strong>Department Code
                        :</strong> {employee.department.departmentCode}</li>

                </ul>
                <div className="card-header">
                    View Organization Details
                </div>
                <ul className="text-start list-group list-group-flush">
                    <li className="list-group-item"><strong>Organization Name
                        :</strong> {employee.organization.organizationName}</li>
                    <li className="list-group-item"><strong>Organization Description
                        :</strong> {employee.organization.organizationDescription}</li>
                    <li className="list-group-item"><strong>organizationCode Code
                        :</strong> {employee.organization.organizationCode}</li>
                    <li className={"list-group-item"}><strong>Created At:</strong> {employee.organization.createDate}</li>

                </ul>

            </div>
        </div>
    );
}

export default EmployeeComponent;