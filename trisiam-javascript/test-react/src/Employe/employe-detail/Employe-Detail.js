import React from 'react';
import '../../App/App.css';

class EmployeDetail extends React.Component {
    
    render () {
        if (this.props.employee == null) {
            return <p>null not found</p>
        }
        return (
            <div>       
                    <div>
                        <img className="gambaremploy" src={this.props.employee.photo} alt=""/>
                        <div className="tulisemploy">
                        <p>Name : {this.props.employee.name}</p>
                        <p>Position : {this.props.employee.position}</p>
                        <p>Detail : {this.props.employee.detail.email}</p>
                                    <p>{this.props.employee.detail.phone}</p>
                                    <p>{this.props.employee.detail.address}</p>
                        </div>
                        <div className="detail">
                           
                        </div>
                    </div>
                
            </div>
        )
    }
}

export default EmployeDetail;