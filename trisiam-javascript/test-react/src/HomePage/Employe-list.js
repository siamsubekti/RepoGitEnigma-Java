import React from 'react';
import EmployeListItem from './Employe-list-item';


import SearchBar from '../shared/SearchBar';

class EmployeList extends React.Component {
    
    render() {
        const {employees, handleClickEmployee, handleChange} = this.props;
        return(
            <div>
                <body className="employelist">
                       <div>
                        
                       <SearchBar searchName="" handleChange={handleChange}/>
                       
                       </div>
                        <div>
                        {employees.map(employee => (  
                        <EmployeListItem key={employee.id} employee={employee} 
                        handleClickEmployee={handleClickEmployee} /> 

                          ))}
                    
                         </div>
                </body>
            </div>
        )
    }
}

export default EmployeList;