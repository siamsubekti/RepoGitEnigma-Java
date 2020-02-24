import React from 'react';
import './App.css';
import HomePage from '../HomePage/HomePage';
import EmployePage from '../Employe/EmployePage';
import employees from '../HomePage/employees.json';



class App extends React.Component{
  
  constructor(props) {
    super(props);
  

  this.state={
    employees,
    selectedEmployee : null,
    
  };

  this.handleClickEmployee = this.handleClickEmployee.bind(this);
  this.handleChange = this.handleChange.bind(this);
}

handleClickEmployee(selectedEmployee) {
  // console.log(selectedEmployee);

  this.setState({selectedEmployee});
}


  handleChange(e) {
  this.setState({
    employees: employees.filter(item => item.name.toLowerCase()
    .indexOf(e.target.value.toLowerCase()) > -1)
  });
} 
  
  render() {
  return (
    <div className="App">
      <div className="row">
      <header className="App-header">
        <div className=""><HomePage employees={this.state.employees} 
        handleClickEmployee={this.handleClickEmployee} handleChange={this.handleChange}/></div>        
        <div className=""><EmployePage employee={this.state.selectedEmployee}/></div>
      </header>
    </div>
    </div>
  );
}
}

export default App;

